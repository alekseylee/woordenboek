package org.example.woordenboek.data.dtos;

import lombok.Value;

@Value
public class DictionaryResponse {

    Long id;
    String word;
    String translation;

}
