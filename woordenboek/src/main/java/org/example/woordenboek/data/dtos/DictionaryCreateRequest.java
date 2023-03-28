package org.example.woordenboek.data.dtos;

import lombok.Value;

@Value
public class DictionaryCreateRequest {

    String word;
    String translation;

}
