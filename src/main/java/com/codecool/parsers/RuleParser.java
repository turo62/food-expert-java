package com.codecool.parsers;

import com.codecool.containers.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

public class RuleParser extends XMLParser {
    protected Element root;
    protected XMLParser myParser;
    private RuleRepository ruleRepository;
    private NodeList nL;
    
    public RuleParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.ruleRepository = new RuleRepository();
        this.nL = d.getElementsByTagName("Rule");
        addRuleToRepository();
    }
    
    private void addRuleToRepository() {
        
        for (int i = 0; i < nL.getLength(); i++) {
            Node n = nL.item(i);
            if (n.getNodeType() == n.ELEMENT_NODE) {
                Element r = (Element) n;
                String id = r.getAttribute("id");
                String myQuestion = r.getElementsByTagName("Question").item(0).getTextContent();
                Answer myAnswer = new Answer();
                Value tempValue = null;
    
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
                                        List<String> input = new ArrayList<>();
                                        Element r4 = (Element) n4;
                                        String inp = r4.getAttribute("value");
                                        input.add(inp);
                                        tempValue = new SingleValue(input, st);
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
    
                                    tempValue = new MultipleValue(params, st);
                                }
                                myAnswer.addValue(tempValue);
    
                            }
                        }
                    }
                }
                Question question = new Question(id, myQuestion, myAnswer);
    
                ruleRepository.addQuestion(question);
            }
        }
    }
    
    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }
}
