package org.example.woordenboek.services.mappers;

import org.example.woordenboek.data.dtos.DictionaryCreateRequest;
import org.example.woordenboek.data.dtos.DictionaryDeleteRequest;
import org.example.woordenboek.data.dtos.DictionaryResponse;
import org.example.woordenboek.data.dtos.DictionaryUpdateRequest;
import org.example.woordenboek.data.entity.DictionaryEntity;

public interface DictionaryMapper {

    DictionaryEntity toEntity(DictionaryCreateRequest req);
    DictionaryEntity toEntity(DictionaryUpdateRequest req);
    DictionaryEntity toEntity(DictionaryDeleteRequest req);
    DictionaryResponse toResponse(DictionaryEntity ent);

}
