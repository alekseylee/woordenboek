package org.example.woordenboek.data.dtos;

import lombok.Value;

@Value
public class UpdateWordRequest {
    String dutchName;
    String englishName;
}
