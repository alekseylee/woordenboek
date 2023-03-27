package org.example.woordenboek.services.flows;

import org.example.woordenboek.data.dtos.*;
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

    DictionaryResponseWord getDictionaryByWord(String translation);
    DictionaryResponseTranslation getDictionaryByTranslation(String translation);





}
