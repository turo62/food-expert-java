package com.codecool.containers;

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
        private int index;
        public boolean hasNext() {
            if (index < questions.size()) {
                return true;
            }
            return false;
        }
    
        public Question next() {
            return questions.get(index++);
        }
    }
}
