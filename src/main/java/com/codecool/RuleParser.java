package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleParser extends XMLParser {
    protected Element root;
    protected XMLParser myParser;
    private RuleRepository ruleRepository;
    
    public RuleParser() {
        this.ruleRepository = new RuleRepository();
    }
    
    public RuleRepository getRuleRepository() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
        InputStream is = new FileInputStream("Rules.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.parse(is);
        Element root = d.getDocumentElement();
        
        for (int i = 0; i < root.getElementsByTagName("Rule").getLength(); i++) {
            Node n = root.getElementsByTagName("Rule").item(i);
            if (n.getNodeType() == n.ELEMENT_NODE) {
                Element r = (Element) n;
                String id = r.getAttribute("id");
                
                String myQuestion = r.getElementsByTagName("Question").item(0).getTextContent();
                System.out.println(myQuestion);
                
                Answer myAnswer = new Answer();
                
                for (int j = 0; j < r.getElementsByTagName("Answer").getLength(); j++) {
                    Node n2 = r.getElementsByTagName("Answer").item(j);
                    if (n2.getNodeType() == n2.ELEMENT_NODE) {
                        Element r2 = (Element) n2;
                        
                        for (int k = 0; k < r2.getElementsByTagName("Selection").getLength(); k++) {
                            Node n3 = r2.getElementsByTagName("Selection").item(k);
                            if (n3.getNodeType() == n3.ELEMENT_NODE) {
                                Element r3 = (Element) n3;
                                Boolean st = (Boolean.valueOf(r3.getAttribute("value"))).booleanValue();
                                
                                for (int l = 0; l < r3.getElementsByTagName("SingleValue").getLength(); l++) {
                                    Node n4 = r3.getElementsByTagName("SingleValue").item(l);
                                    if (n4.getNodeType() == n4.ELEMENT_NODE) {
                                        Element r4 = (Element) n4;
                                        String inp = r4.getAttribute("value");
                                        Value tempValue = new SingleValue(inp, st);
                                        myAnswer.addValue(tempValue);
                                    }
                                    
                                }
                                
                                for (int l = 0; l < r3.getElementsByTagName("MultipleValue").getLength(); l++) {
                                    Node n4 = r3.getElementsByTagName("MultipleValue").item(l);
                                    List<String> params = new ArrayList();
                                    if (n4.getNodeType() == n4.ELEMENT_NODE) {
                                        Element r4 = (Element) n4;
                                        String inp = r4.getAttribute("value");
                                        
                                        int count = inp.split(",").length;
                                        String[] param = inp.split(",");
                                        for (int m = 0; m < count; m++) {
                                            params.add(param[m]);
                                        }
                                    }
                                    
                                    Value tempValue = new MultipleValue(params, st);
                                    myAnswer.addValue(tempValue);
                                }
                            }
                        }
                    }
                    Question question = new Question(id, myQuestion, myAnswer);
                    RuleRepository ruleRepository = new RuleRepository();
                    ruleRepository.addQuestion(question);
                }
            }
        }
        return ruleRepository;
    }
}
