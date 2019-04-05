package com.codecool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ESProvider {
    Printing printing;
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userPreferences;
    private Fact fact;
    private Question question;
    
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
    
        for (int p = 0; p < userPreferences.size(); p++) {
            Object key = userPreferences.keySet().toArray()[p];
            Boolean value = userPreferences.get(key.toString());
            System.out.println(key);
            System.out.println(value);
        }
    }
    
    public Boolean getAnswerByQuestion(String questionId, Question question, Scanner input) {
        String userInput = getUserInput(input);
        Boolean evaluation = question.getEvaluatedAnswer(userInput);
        return evaluation;
    }
    
    public String getUserInput(Scanner input) {
        String userInput;
        userInput = input.next().toLowerCase();
        return userInput;
    }
}
