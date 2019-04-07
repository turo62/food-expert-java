package com.codecool.containers;

public class Question {
    private String id;
    private String question;
    private Answer answer;
    
    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }
    
    public String getId() {
        return id;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public Answer getAnswer() {
        return answer;
    }
    
    public Boolean getEvaluatedAnswer(String input) {
        Boolean evaluation = this.answer.evaluateAnswerByInput(input);
        
        return evaluation;
    }
}
