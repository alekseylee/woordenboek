package org.example.woordenboek.services.flows;

import org.example.woordenboek.data.dtos.DictionaryCreateRequest;
import org.example.woordenboek.data.dtos.DictionaryDeleteRequest;
import org.example.woordenboek.data.dtos.DictionaryResponse;
import org.example.woordenboek.data.dtos.DictionaryUpdateRequest;
import org.example.woordenboek.data.entity.DictionaryEntity;
import org.example.woordenboek.data.repository.DictionaryRepository;
import org.example.woordenboek.services.mappers.DictionaryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DictionaryServiceImpl implements DictionaryService{


    private DictionaryRepository dictionaryRepository;
    private DictionaryMapper dictionaryMapper;

    public DictionaryServiceImpl (DictionaryRepository dictionaryRepository, DictionaryMapper dictionaryMapper) {
        this.dictionaryRepository = dictionaryRepository;
        this.dictionaryMapper = dictionaryMapper;
    }


    @Override
    public Long createDictionary(DictionaryCreateRequest req) {
        DictionaryEntity entityToSave = dictionaryMapper.toEntity(req);
        DictionaryEntity savedEntity = dictionaryRepository.save(entityToSave);
        return savedEntity.getId();
    }


    public List<Long> createDictionaries(List<DictionaryCreateRequest> requests) {
        List<DictionaryEntity> entitiesToSave = requests.stream()
                .map(dictionaryMapper::toEntity)
                .collect(Collectors.toList());
        List<DictionaryEntity> savedEntities = dictionaryRepository.saveAll(entitiesToSave);
        return savedEntities.stream()
                .map(DictionaryEntity::getId)
                .collect(Collectors.toList());
    }


    @Override
    public Long updateDictionary(DictionaryUpdateRequest req) {
        DictionaryEntity entityToUpdate = dictionaryMapper.toEntity(req);
        DictionaryEntity updatedEntity = dictionaryRepository.save(entityToUpdate);
        return updatedEntity.getId();
    }


    @Override
    public Long deleteDictionary(DictionaryDeleteRequest req) {
        DictionaryEntity entityToDelete = dictionaryMapper.toEntity(req);
        DictionaryEntity updatedEntity = dictionaryRepository.save(entityToDelete);
        return updatedEntity.getId();
    }
    @Override
    public List<DictionaryResponse> getAllDictionaries() {
        return null;
    }

    @Override
    public Optional<DictionaryResponse> getDictionaryById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<DictionaryResponse> getDictionaryByDutchWord(String dutchWord) {
        return Optional.empty();
    }

    @Override
    public Optional<DictionaryResponse> getDictionaryByEnglishWord(String englishWord) {
        return Optional.empty();
    }
}
