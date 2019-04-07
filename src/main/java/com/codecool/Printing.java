package com.codecool;

import java.util.List;

public class Printing {
    
    public void printWelcome() {
        System.out.println("Welcome to Restaurant Advisor! \n" +
            "Do you want to eat somewhere away home?\n" +
            "Please, reply some questions to let us know your preferences. ");
    }
    
    public void printQuestion(Question question) {
        System.out.println(question.getQuestion() + "\n" + "\n");
    }
    
    public void printResult(String result) {
        System.out.println("We may recommend to eat at " + result + ".");
        
    }
    
    public void printFail() {
        System.out.println("We are sorry but could not find a place fulfilling your expectations.");
    }
}
