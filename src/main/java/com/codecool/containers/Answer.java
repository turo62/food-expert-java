package com.codecool.containers;

import java.util.*;

public class Answer {
    private List<Value> answers;
    
    public Answer() {
        this.answers = new ArrayList<>();
    }
    
    public void addValue(Value value) {
        answers.add(value);
    }
    
    public Boolean evaluateAnswerByInput(String input) throws InputMismatchException {
        for (Value value : this.answers) {
            if (value.getInputPattern().contains(input)) {
                return value.getSelectionType();
            }
        }
        throw new InputMismatchException();
    }
    
    public List<Value> getAnswers() {
        return answers;
    }
}
