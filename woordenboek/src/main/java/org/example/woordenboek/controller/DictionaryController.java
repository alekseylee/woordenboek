package org.example.woordenboek.controller;

import org.example.woordenboek.data.dtos.DictionaryCreateRequest;
import org.example.woordenboek.data.dtos.DictionaryResponse;
import org.example.woordenboek.data.dtos.DictionaryUpdateRequest;
import org.example.woordenboek.services.exceptions.DictionaryException;
import org.example.woordenboek.services.flows.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/words")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

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
    public ResponseEntity<List<DictionaryResponse>> get() {
        List<DictionaryResponse> responses = dictionaryService.getAllDictionaries();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Long> createDictionary(@RequestBody DictionaryCreateRequest req) {
//        try {
//            Long response = dictionaryService.createDictionary(req);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } catch (DictionaryException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }



    @PostMapping("/create")
    public ResponseEntity<List<Long>> createDictionaries(@RequestBody List<DictionaryCreateRequest> requests) {
        System.out.println(requests);
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

    @GetMapping("/{dutch}")
    public ResponseEntity <DictionaryResponse> getByDutch(@PathVariable String dutchWord) {
        Optional<DictionaryResponse> dictionaryResponse = dictionaryService.getDictionaryByDutchWord(dutchWord);
        return dictionaryResponse.map(response -> new ResponseEntity<>(response, HttpStatus.FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{english}")
    public ResponseEntity <DictionaryResponse> getByEnglish(@PathVariable String englishWord) {
        Optional<DictionaryResponse> dictionaryResponse = dictionaryService.getDictionaryByEnglishWord(englishWord);
        return dictionaryResponse.map(response -> new ResponseEntity<>(response, HttpStatus.FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete")
    public ResponseEntity <DictionaryResponse> deleteById(@PathVariable Long id) {
        Optional<DictionaryResponse> dictionaryResponse = dictionaryService.getDictionaryById(id);
        return dictionaryResponse.map(response -> new ResponseEntity<>(response, HttpStatus.FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
