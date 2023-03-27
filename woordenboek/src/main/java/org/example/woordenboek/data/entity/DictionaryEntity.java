package org.example.woordenboek.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DictionaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private String translation;

    public DictionaryEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryEntity entity = (DictionaryEntity) o;
        return id.equals(entity.id) && word.equals(entity.word) && translation.equals(entity.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, translation);
    }

    @Override
    public String toString() {
        return "DictionaryEntity{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
