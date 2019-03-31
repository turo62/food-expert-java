package com.codecool;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


abstract class XMLParser {
    protected Document d;
    
    void loadXmlDocument(String xmlPath) {
        try {
            InputStream is = new FileInputStream(xmlPath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(is);
            Element root = d.getDocumentElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Document getDocument() {
        return this.d;
    }
    
}
