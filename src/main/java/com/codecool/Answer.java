package com.codecool;

import java.util.*;

public class Answer {
    private List<Value> answer;
    
    public Answer() {
        this.answer = new ArrayList<>();
    }
    
    public void addValue(Value value) {
        this.answer.add(value);
    }
    
    public Boolean evaluateAnswerByInput(String input) throws InputMismatchException {
        for (Value value : this.answer) {
            if (value.getInputPattern().contains(input)) {
                return value.getSelectionType();
            }
        }
        throw new InputMismatchException();
    }
}
