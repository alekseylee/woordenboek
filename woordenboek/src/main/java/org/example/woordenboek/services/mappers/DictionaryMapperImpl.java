package org.example.woordenboek.services.mappers;

import lombok.RequiredArgsConstructor;
import org.example.woordenboek.data.dtos.DictionaryCreateRequest;
import org.example.woordenboek.data.dtos.DictionaryDeleteRequest;
import org.example.woordenboek.data.dtos.DictionaryResponse;
import org.example.woordenboek.data.dtos.DictionaryUpdateRequest;
import org.example.woordenboek.data.entity.DictionaryEntity;
import org.springframework.stereotype.Component;

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

}
