package org.example.woordenboek.data.repository;

import org.example.woordenboek.data.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository <DictionaryEntity, Long> {
}
