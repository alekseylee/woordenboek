package org.example.woordenboek.data.dtos;

import lombok.Value;

@Value
public class DictionaryUpdateRequest {

    String word;
    String translation;

}
