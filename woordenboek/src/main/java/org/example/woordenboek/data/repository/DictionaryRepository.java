package org.example.woordenboek.data.repository;

import org.example.woordenboek.data.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryRepository extends JpaRepository <DictionaryEntity, Long> {
    DictionaryEntity findByWord(String word);

    DictionaryEntity findByTranslation(String translation);
}
