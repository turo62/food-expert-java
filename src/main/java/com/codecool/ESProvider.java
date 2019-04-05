package com.codecool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ESProvider {
    Printing printing;
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, String> userPreferences;
    private Fact fact;
    
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
            /*for (int i = 0; i < question.getAnswer().getAnswers().size(); i++) {
                Value value = question.getAnswer().getAnswers().get(i);
                System.out.println(value.getSelectionType());
            }*/
            System.out.println("répa");
            String userInput = getUserInput(input);
            this.userPreferences.put(questionId, userInput);
        }
    }
    
    public String getUserInput(Scanner input) {
        String userInput;
        userInput = input.next().toLowerCase();
        return userInput;
    }
}
