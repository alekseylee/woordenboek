package org.example.woordenboek.services.flows;

import org.example.woordenboek.data.dtos.CreateWordRequest;
import org.example.woordenboek.data.dtos.DeleteWordRequest;
import org.example.woordenboek.data.dtos.UpdateWordRequest;
import org.example.woordenboek.data.dtos.WordResponse;
import org.example.woordenboek.data.entity.ItWordEntity;
import org.example.woordenboek.data.repository.ItWordRepository;
import org.example.woordenboek.services.exceptions.WordException;
import org.example.woordenboek.services.mappers.ItWordMapperImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItWordServiceImpl implements ItWordService {

    private ItWordRepository wordRepository;
    private ItWordMapperImpl wordMapper;

    public ItWordServiceImpl(ItWordRepository repository, ItWordMapperImpl wordMapper) {
        this.wordRepository = repository;
        this.wordMapper = wordMapper;
    }


    @Override
    public Long createWord(CreateWordRequest req) throws WordException {
        ItWordEntity entity = wordMapper.toEntity(req);
        ItWordEntity updated = wordRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateWord(UpdateWordRequest req) throws WordException {
        ItWordEntity entity = wordMapper.toEntity(req);
        ItWordEntity updated = wordRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long deleteWord(DeleteWordRequest req) throws WordException {
        ItWordEntity entity = wordMapper.toEntity(req);
        ItWordEntity updated = wordRepository.save(entity);
        return updated.getId();
    }

    @Override
    public List<WordResponse> getAllWords() {
        return wordRepository.findAll().stream().map(wordMapper::toResponse).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<WordResponse> getWordsById(Long id) {
        ItWordEntity ent = wordRepository.getReferenceById(id);
        return Optional.of(wordMapper.toResponse(ent));
    }
}

