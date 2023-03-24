package org.example.woordenboek.services.mappers;

import org.example.woordenboek.data.dtos.CreateWordRequest;
import org.example.woordenboek.data.dtos.DeleteWordRequest;
import org.example.woordenboek.data.dtos.UpdateWordRequest;
import org.example.woordenboek.data.dtos.WordResponse;
import org.example.woordenboek.data.entity.ItWordEntity;
import org.example.woordenboek.data.repository.ItWordRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItWordMapperImpl implements ItWordMapper {
    private ItWordRepository repository;

    @Override
    public WordResponse toResponse(ItWordEntity entity) {
        WordResponse response = new WordResponse(
                entity.getId(),
                entity.getDutchName(),
                entity.getEnglishName()
        );
        return response;
    }

    @Override
    public ItWordEntity toEntity(CreateWordRequest req) {
        ItWordEntity entity = new ItWordEntity();
        entity.setDutchName(req.getDutchName());
        entity.setEnglishName(req.getEnglishName());
        return entity;
    }
    @Override
    public ItWordEntity toEntity(UpdateWordRequest req) {
        ItWordEntity entity = new ItWordEntity();
        entity.setEnglishName(req.getEnglishName());
        entity.setDutchName(req.getDutchName());
        return entity;
    }

    @Override
    public ItWordEntity toEntity(DeleteWordRequest req) {
        ItWordEntity entity = new ItWordEntity();
        entity.setId(req.getId());
        return entity;
    }

    @Override
    public WordResponse toEntity(ItWordEntity ent) {
        WordResponse response = new WordResponse(
                ent.getId(),
                ent.getEnglishName(),
                ent.getDutchName()
        );
        return response;
    }

    @Override
    public List<WordResponse> toResponses(List<ItWordEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toUnmodifiableList());
    }


}
