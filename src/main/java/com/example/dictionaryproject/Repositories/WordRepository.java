package com.example.dictionaryproject.Repositories;

import com.example.dictionaryproject.Entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {
    void deleteWordById(Long id);

    Optional<Word> findWordById(Long id);
}
