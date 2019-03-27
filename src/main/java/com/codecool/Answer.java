package com.codecool;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> answers;
    
    public Answer() {
        this.answers = new ArrayList<>();
    }
    
    public void addValue(Value value) {
        this.answers.add(value);
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
