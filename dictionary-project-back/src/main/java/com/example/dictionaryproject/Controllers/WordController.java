package com.example.dictionaryproject.Controllers;

import com.example.dictionaryproject.Entities.Word;
import com.example.dictionaryproject.Service.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService){

        this.wordService = wordService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Word>> getAllWords(){
        List<Word> words = wordService.findAll();
        return new ResponseEntity<>(words, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Word> getWordByID(@PathVariable("id") Long id){
        Word word = wordService.findWord(id);
        return new ResponseEntity<>(word, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Word> addWord(@RequestBody Word word){
        Word newWord = wordService.addWord(word);
        return new ResponseEntity<>(newWord, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Word> updateWord(@RequestBody Word word){
        Word updateWord = wordService.uprateWord(word);
        return new ResponseEntity<>(updateWord, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWord(@PathVariable("id") Long id){
        wordService.deleteWord(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
