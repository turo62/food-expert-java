package com.codecool;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String FACTSROOT = "Facts.xml";
        final String RULESROOT = "Rules.xml";
        ESProvider myESP = new ESProvider(new FactParser(FACTSROOT), new RuleParser(RULESROOT));
        Printing printing = new Printing();
        printing.printWelcome();
    
        myESP.collectAnswers();
        String result = myESP.evaluate();
    
        if (result.equals("")) {
            printing.printFail();
        } else {
            printing.printResult(result);
        }
    }
}
