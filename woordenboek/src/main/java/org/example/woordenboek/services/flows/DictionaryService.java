package org.example.woordenboek.services.flows;

import org.example.woordenboek.data.dtos.DictionaryCreateRequest;
import org.example.woordenboek.data.dtos.DictionaryDeleteRequest;
import org.example.woordenboek.data.dtos.DictionaryResponse;
import org.example.woordenboek.data.dtos.DictionaryUpdateRequest;
import org.example.woordenboek.services.exceptions.DictionaryException;

import java.util.List;
import java.util.Optional;

public interface DictionaryService {

    Long createDictionary(DictionaryCreateRequest req);
    List<Long> createDictionaries(List<DictionaryCreateRequest> requests);
    Long updateDictionary(DictionaryUpdateRequest req);
    Long deleteDictionary(DictionaryDeleteRequest req);

    List<DictionaryResponse> getAllDictionaries();
    Optional<DictionaryResponse> getDictionaryById(Long id);

    Optional<DictionaryResponse> getDictionaryByDutchWord(String dutchWord);
    Optional<DictionaryResponse> getDictionaryByEnglishWord(String englishWord);





}
