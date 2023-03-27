package org.example.woordenboek.data.dtos;

import lombok.Data;
import lombok.Value;

@Value
public class DictionaryResponseWord {
    Long id;
    String translation;
}
