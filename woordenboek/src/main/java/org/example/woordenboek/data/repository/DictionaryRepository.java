package org.example.woordenboek.data.repository;

import org.example.woordenboek.data.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DictionaryRepository extends JpaRepository <DictionaryEntity, Long> {
    @Query("select new DictionaryEntity(id, word, translation) from DictionaryEntity where word LIKE ?1")
    DictionaryEntity findByWord(String word);

    @Query("select new DictionaryEntity(id, word, translation) from DictionaryEntity where translation LIKE ?1")
    DictionaryEntity findByTranslation(String translation);
}
