package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {
    private Iterator<Question> questionIterator;
    private List<Question> questions;
    
    public RuleRepository() {
        this.questions = new ArrayList<>();
        this.questionIterator = new QuestionIterator();
    }
    
    public Iterator<Question> getIterator() {
        return questionIterator;
    }
    
    public void addQuestion(Question question) {
        this.questions.add(question);
    }
    
    private class QuestionIterator implements Iterator {
        int index = 0;
        
        @Override
        public boolean hasNext() {
            return index < questions.size();
        }
        
        @Override
        public Question next() {
            if (this.hasNext()) {
                return questions.get(index++);
            } else {
                return null;
            }
        }
    }
}
