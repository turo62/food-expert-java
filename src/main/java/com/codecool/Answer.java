package com.codecool;

import java.util.*;

public class Answer {
    private List<Value> answers;
    
    public Answer() {
        this.answers = new ArrayList<>();
    }
    
    public Answer addValue(Value value) {
        return answers.add(value);
    }
    
    public Boolean evaluateAnswerByInput(String input) throws InputMismatchException {
        for (Value value : this.answers) {
            if (value.getInputPattern().contains(input)) {
                return value.getSelectionType();
            }
        }
        throw new InputMismatchException();
    }
}
