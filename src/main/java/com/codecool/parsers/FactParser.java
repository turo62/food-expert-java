package com.codecool.parsers;

import com.codecool.containers.Fact;
import com.codecool.containers.FactRepository;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {
    protected Element root;
    protected XMLParser myParser;
    private FactRepository factRepository;
    private NodeList nL;
    
    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.factRepository = new FactRepository();
        this.nL = d.getElementsByTagName("Fact");
    }
    
    public FactRepository getFactRepository() {
        Fact fact;
    
        for (int i = 0; i < nL.getLength(); i++) {
            Node n1 = nL.item(i);
            Element e1 = (Element) n1;
        
            String id = e1.getAttribute("id");
            Element e4 = (Element) e1.getElementsByTagName("Description").item(0);
            String description = e4.getAttribute("value");
    
            fact = new Fact(id, description);
        
            Element e2 = (Element) e1.getElementsByTagName("Evals").item(0);
            NodeList nL1 = e2.getElementsByTagName("Eval");
        
            for (int j = 0; j < nL1.getLength(); j++) {
                Element e3 = (Element) nL1.item(j);
                String id1 = e3.getAttribute("id");
                String value = e3.getTextContent();
                fact.setFactValueById(id1, Boolean.valueOf(value));
            }
    
            factRepository.addFact(fact);
        }
        return this.factRepository;
    }
}
