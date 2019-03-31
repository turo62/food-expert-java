package com.codecool;

import java.util.*;

public class Answer {
    private Map<Boolean, List<String>> answer;
    
    public Answer() {
        this.answer = new HashMap<>();
    }
    
    public void addValue(Value value) {
        this.answer.put(value.getSelectionType(), value.getInputPattern());
    }
    
    /*public Boolean evaluateAnswerByInput(String input) throws InputMismatchException {
        for (Value value : this.answer) {
            if (value.getInputPattern().contains(input)) {
                return value.getSelectionType();
            }
        }
        throw new InputMismatchException()
    }*/
}
