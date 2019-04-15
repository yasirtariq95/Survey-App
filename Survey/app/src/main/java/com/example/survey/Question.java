package com.example.survey;

public class Question {

    private String id;
    private String question;

    public Question(){

    }

    public Question(String id, String question) {
        this.id = id;
        this.question = question;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
