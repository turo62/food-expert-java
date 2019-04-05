package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String FACTSROOT = "Facts.xml";
        final String RULESROOT = "Rules.xml";
        ESProvider myESP = new ESProvider(new FactParser(FACTSROOT), new RuleParser(RULESROOT));
        //Printing printing = new Printing();
        //printing.printWelcome();
    
        myESP.collectAnswers();
        //FactParser myFacts = new FactParser(FACTSROOT);
        //myFacts.getFactRepository();
        //getAnswers();
    }
    
    /*public static void getAnswers() {
        Iterator<Fact> factIterator = new FactRepository().getIterator();
        
        while (factIterator.hasNext()) {
            Fact myFact = factIterator.next();
            System.out.println(myFact.getId());
        }
        
    }*/
}
