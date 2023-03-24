package org.example.woordenboek.data.repository;

import org.example.woordenboek.data.entity.ItWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItWordRepository extends JpaRepository <ItWordEntity, Long>{
    List<ItWordRepository> findByDutchNameContainingIgnoreCaseOrEnglishNameContainingIgnoreCase
            (String dutchName, String englishName);
}

