package org.example.woordenboek.controller;

import org.example.woordenboek.data.dtos.DeleteWordRequest;
import org.example.woordenboek.data.dtos.UpdateWordRequest;
import org.example.woordenboek.data.entity.ItWordEntity;
import org.example.woordenboek.data.repository.ItWordRepository;
import org.example.woordenboek.services.exceptions.WordException;
import org.example.woordenboek.services.flows.ItWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itwords")
public class ItWordController {

    @Autowired
    private ItWordRepository itWordRepository;
    private ItWordService itWordService;

    @GetMapping
    public List<ItWordEntity> getAllITWords() {
        return itWordRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItWordEntity> getWordById(@PathVariable Long id) {
        Optional<ItWordEntity> itWord = itWordRepository.findById(id);
        if (itWord.isPresent()) {
            return ResponseEntity.ok(itWord.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addWord")
    public ResponseEntity<ItWordEntity> addWord(@RequestBody ItWordEntity itWord) {
        ItWordEntity savedITWord = itWordRepository.save(itWord);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedITWord);
    }

    @PostMapping("/update")
    public ResponseEntity<Long> updateWord(@RequestBody UpdateWordRequest request) {
        try {
            Long response = itWordService.updateWord(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (WordException e) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> deleteWord(@RequestBody DeleteWordRequest request) {
        try {
            Long response = itWordService.deleteWord(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (WordException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
