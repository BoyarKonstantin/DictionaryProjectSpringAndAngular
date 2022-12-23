package com.example.dictionaryproject.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private long id;
    @Column(nullable = false)
    private String englishWord;
    @Column(nullable = false)
    private String translateWord;
    @Column
    private String transcription;
    @Column(nullable = false, updatable = false)
    private String wordCode;

    public Word(String englishWord, String translateWord, String transcription) {
        this.englishWord = englishWord;
        this.translateWord = translateWord;
        this.transcription = transcription;
    }

    public Word() {
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public void setTranslateWord(String translateWord) {
        this.translateWord = translateWord;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getTranscription() {
        return transcription;
    }

    public String getTranslateWord() {
        return translateWord;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", englishWord='" + englishWord + '\'' +
                ", translateWord='" + translateWord + '\'' +
                ", transcription='" + transcription + '\'' +
                '}';
    }

    public String getWordCode() {
        return wordCode;
    }

    public void setWordCode(String wordCode) {
        this.wordCode = wordCode;
    }
}
