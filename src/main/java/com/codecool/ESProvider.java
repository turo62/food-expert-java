package com.codecool;

import java.util.*;

public class ESProvider {
    private Printing printing;
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userPreferences;
    private Fact fact;
    private String result;
    
    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
        printing = new Printing();
    }
    
    public void collectAnswers() {
        userPreferences = new HashMap<>();
        Scanner input = new Scanner(System.in);
        Iterator<Question> questionIterator = this.ruleRepository.getIterator();
        
        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            String questionId = question.getId();
            System.out.println(question.getQuestion());
            Boolean inputEval = getAnswerByQuestion(questionId, question, input);
            this.userPreferences.put(questionId, inputEval);
        }
        input.close();
    }
    
    public Boolean getAnswerByQuestion(String questionId, Question question, Scanner input) {
        String userInput = getUserInput(input);
        Boolean evaluation = question.getEvaluatedAnswer(userInput);
        return evaluation;
    }
    
    private String getUserInput(Scanner input) {
        String userInput;
        userInput = input.next().toLowerCase();
        return userInput;
    }
    
    public String evaluate() {
        Iterator<Fact> factIterator = this.factRepository.getIterator();
        result = "";
        
        while (factIterator.hasNext()) {
            this.fact = factIterator.next();
            if (!checkMatch(this.fact.getEvaluation())) {
                continue;
            }
            result = this.fact.getDescription();
        }
        
        return result;
    }
    
    private boolean checkMatch(Map<String, Boolean> evaluation) {
        
        for (int i = 0; i < evaluation.size(); i++) {
            Object key = evaluation.keySet().toArray()[i];
            if (!evaluation.get(key.toString()) == this.userPreferences.get(key.toString())) {
                return false;
            }
        }
        return true;
    }
    
    /*public void showResult() {
        evaluate();
        if (result.size() > 0) {
        
        }
    }*/
}
