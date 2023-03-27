package org.example.woordenboek.data.dtos;


import lombok.Value;
import org.example.woordenboek.data.entity.DictionaryEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Value
public class DictionaryCreateRequest {

    String word;
    String translation;

}
