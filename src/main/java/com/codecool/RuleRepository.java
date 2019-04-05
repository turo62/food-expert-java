package com.codecool;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class RuleRepository {
    
    private List<Question> questions;
    private Iterator<Question> questionIterator;
    
    public RuleRepository() {
        this.questionIterator = new QuestionIterator();
        this.questions = new ArrayList<>();
    }
    
    public void addQuestion(Question question) {
        this.questions.add(question);
    }
    
    public Iterator<Question> getIterator() {
        return questionIterator;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }
    
    private class QuestionIterator implements Iterator {
        int index;
    
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
