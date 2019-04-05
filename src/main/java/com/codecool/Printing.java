package com.codecool;

public class Printing {
    
    public void printWelcome() {
        System.out.println("Welcome to Restaurant Advisor! \n" +
            "Do you want to eat somewhere away home?\n" +
            "Please, reply some questions to let us know your preferences. ");
    }
    
    public void printQuestion(Question question) {
        System.out.println(question.getQuestion() + "\n" + "\n");
    }
    
    
}
