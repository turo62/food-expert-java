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
        RuleParser myParser = new RuleParser("Rules.xml");
            myParser.getRuleRepository();
    }
}
