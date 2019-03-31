package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            RuleParser myParser = new RuleParser();
            myParser.getRuleRepository();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException s) {
            s.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        
    
    }
}
