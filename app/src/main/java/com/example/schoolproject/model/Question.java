package com.example.schoolproject.model;

public class Question {
    private String quest;
    private int num;

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Question(String quest, int num) {
        this.quest = quest;
        this.num = num;
    }
}
