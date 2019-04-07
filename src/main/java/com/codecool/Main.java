package com.codecool;

import com.codecool.printing.Printing;
import com.codecool.parsers.FactParser;
import com.codecool.parsers.RuleParser;

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
