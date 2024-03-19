package com.example.schoolproject.model;

public class Word {
    private String word;
    private String definition;
    private String id;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Word(String id, String word, String definition) {
        this.word = word;
        this.definition = definition;
        this.id = id;
    }
}
