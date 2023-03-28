package org.example.woordenboek.services.mappers;

import org.example.woordenboek.data.dtos.*;
import org.example.woordenboek.data.entity.DictionaryEntity;

import java.util.List;

public interface DictionaryMapper {

    DictionaryEntity toEntity(DictionaryCreateRequest req);
    DictionaryEntity toEntity(DictionaryUpdateRequest req);
    DictionaryEntity toEntity(DictionaryDeleteRequest req);
    DictionaryResponse toResponse(DictionaryEntity ent);

    List<DictionaryResponse> toResponses(List<DictionaryEntity> entities);

}
