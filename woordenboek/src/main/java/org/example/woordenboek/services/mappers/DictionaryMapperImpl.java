package org.example.woordenboek.services.mappers;

import lombok.RequiredArgsConstructor;
import org.example.woordenboek.data.dtos.*;
import org.example.woordenboek.data.entity.DictionaryEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DictionaryMapperImpl implements DictionaryMapper{


    @Override
    public DictionaryEntity toEntity(DictionaryCreateRequest req) {
        DictionaryEntity ent = new DictionaryEntity();
        ent.setWord(req.getWord());
        ent.setTranslation(req.getTranslation());
        return ent;
    }

    @Override
    public DictionaryEntity toEntity(DictionaryUpdateRequest req) {
        DictionaryEntity ent = new DictionaryEntity();
        ent.setWord(req.getWord());
        ent.setTranslation(req.getTranslation());
        return ent;
    }

    @Override
    public DictionaryEntity toEntity(DictionaryDeleteRequest req) {
        DictionaryEntity ent = new DictionaryEntity();
        ent.setId(req.getId());
        return ent;
    }


    @Override
    public DictionaryResponse toResponse(DictionaryEntity ent) {
        return new DictionaryResponse(
                ent.getId(),
                ent.getWord(),
                ent.getTranslation()
        );
    }

    @Override
    public DictionaryResponseWord toResponseWord(DictionaryEntity ent) {
        return new DictionaryResponseWord(
                ent.getId(),
                ent.getTranslation()
        );
    }

    @Override
    public DictionaryResponseTranslation toResponseTranslation(DictionaryEntity ent) {
        return new DictionaryResponseTranslation(
                ent.getId(),
                ent.getWord()
        );
    }



    @Override
    public List<DictionaryResponse> toResponses(List<DictionaryEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toUnmodifiableList());
    }
}
