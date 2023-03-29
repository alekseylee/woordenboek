package org.example.woordenboek.controller;

import org.example.woordenboek.data.dtos.*;
import org.example.woordenboek.data.entity.DictionaryEntity;
import org.example.woordenboek.data.repository.DictionaryRepository;
import org.example.woordenboek.services.exceptions.DictionaryException;
import org.example.woordenboek.services.flows.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dictionary")
public class DictionaryController {
    private List<DictionaryEntity> words = new ArrayList<>();

    private DictionaryService dictionaryService;

    private DictionaryRepository repository;


    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity <DictionaryResponse> getById(@PathVariable Long id) {
        Optional<DictionaryResponse> dictionaryResponse = dictionaryService.getDictionaryById(id);
        return dictionaryResponse.map(response -> new ResponseEntity<>(response, HttpStatus.FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/all")
    public ResponseEntity<List<DictionaryResponse>> getAll() {
        List<DictionaryResponse> responses = dictionaryService.getAllDictionaries();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @PostMapping("/create")
    public ResponseEntity<List<Long>> createDictionaries(@RequestBody List<DictionaryCreateRequest> requests) {
        List<Long> savedIds = new ArrayList<>();
        savedIds = dictionaryService.createDictionaries(requests);
        return new ResponseEntity<List<Long>>(savedIds, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Long> updateDictionary(@RequestBody DictionaryUpdateRequest req) {
        try {
            Long response = dictionaryService.updateDictionary(req);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (DictionaryException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <DictionaryResponse> deleteById(@PathVariable Long id) {
        Optional<DictionaryResponse> dictionaryResponse = dictionaryService.getDictionaryById(id);
        return dictionaryResponse.map(response -> new ResponseEntity<>(response, HttpStatus.FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/translate/{translation}")
    public ResponseEntity <DictionaryResponse> getByTranslation(@PathVariable String translation) {
        Optional<DictionaryResponse> dictionaryResponse = Optional.of(dictionaryService.getDictionaryByTranslation(translation));
        return dictionaryResponse.map(response -> new ResponseEntity<>(response, HttpStatus.FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/translate/{word}")
    public ResponseEntity <DictionaryResponse> getByWord(@PathVariable String word) {
        Optional<DictionaryResponse> dictionaryResponse = Optional.of(dictionaryService.getDictionaryByWord(word));
        return dictionaryResponse.map(response -> new ResponseEntity<>(response, HttpStatus.FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
