package com.example.dictionaryproject.Service;

import com.example.dictionaryproject.Entities.Word;
import com.example.dictionaryproject.Exceptions.WordFindByIDException;
import com.example.dictionaryproject.Repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }
    public Word addWord(Word word){
        word.setWordCode(UUID.randomUUID().toString());
        return wordRepository.save(word);
    }
    public List<Word> findAll(){
        return wordRepository.findAll();
    }
    public Word uprateWord(Word word){
         return wordRepository.save(word);
    }
    public void deleteWord(Long id){
        wordRepository.deleteWordById(id);
    }
    public Word findWord(Long id){
        return wordRepository.findWordById(id)
                .orElseThrow(() -> new WordFindByIDException("Word by id " + id + "was not found"));
    }
}
