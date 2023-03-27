package org.example.woordenboek.data.dtos;

import lombok.Data;
import lombok.Value;
import org.example.woordenboek.data.entity.DictionaryEntity;

import java.util.List;

@Value
public class DictionaryResponse {

    Long id;
    String word;
    String translation;

}
