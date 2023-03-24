package org.example.woordenboek.services.flows;

import org.example.woordenboek.data.dtos.CreateWordRequest;
import org.example.woordenboek.data.dtos.DeleteWordRequest;
import org.example.woordenboek.data.dtos.UpdateWordRequest;
import org.example.woordenboek.data.dtos.WordResponse;
import org.example.woordenboek.services.exceptions.WordException;

import java.util.List;
import java.util.Optional;

public interface ItWordService {

    Long createWord(CreateWordRequest req)throws WordException;
    Long updateWord(UpdateWordRequest req)throws WordException;
    Long deleteWord(DeleteWordRequest req)throws WordException;

    List<WordResponse> getAllWords();
    Optional<WordResponse> getWordsById(Long id);


}

