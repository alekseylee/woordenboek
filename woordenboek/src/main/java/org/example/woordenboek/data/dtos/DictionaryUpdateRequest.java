package org.example.woordenboek.data.dtos;

import lombok.Value;
import org.example.woordenboek.data.entity.DictionaryEntity;

import java.util.List;

@Value
public class DictionaryUpdateRequest {

    String word;
    String translation;

}
