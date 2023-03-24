package org.example.woordenboek.services.mappers;

import org.example.woordenboek.data.dtos.CreateWordRequest;
import org.example.woordenboek.data.dtos.DeleteWordRequest;
import org.example.woordenboek.data.dtos.UpdateWordRequest;
import org.example.woordenboek.data.dtos.WordResponse;
import org.example.woordenboek.data.entity.ItWordEntity;
import org.example.woordenboek.services.flows.ItWordServiceImpl;

import java.util.List;

public interface ItWordMapper {
    WordResponse toResponse(ItWordEntity entity);

    ItWordEntity toEntity(CreateWordRequest req);
    ItWordEntity toEntity(UpdateWordRequest req);
    ItWordEntity toEntity(DeleteWordRequest req);
    WordResponse toEntity(ItWordEntity ent);
    List<WordResponse> toResponses(List<ItWordEntity> entities);
}
