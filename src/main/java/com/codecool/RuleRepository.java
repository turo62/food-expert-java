package com.codecool;

import java.util.*;

public class RuleRepository {
    private String id;
    private Map<String, String> ruleRepository;
    private Iterator questionIterator;
    private Question question;
    private List<Question> questions;
    
    public RuleRepository() {
        this.ruleRepository = new HashMap<>();
    }
    
    public void addQuestion(Question question) {
        this.ruleRepository.put(question.getId(), question.getQuestion());
    }
    
    public Iterator<Question> getIterator() {
        return questionIterator;
    }
    
    /*public void addQuestion(Question question) {
        questions.add(question);
    }*/
    
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
