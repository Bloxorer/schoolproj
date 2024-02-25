package com.example.schoolproject.model;

public class Question {
    private String quest;
    private String id;


    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Question(String quest, String id) {
        this.quest = quest;
        this.id = id;
    }
}
