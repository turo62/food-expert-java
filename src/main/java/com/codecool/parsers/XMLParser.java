package com.codecool.parsers;

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
            this.d = db.parse(is);
            this.d.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Document getDocument() {
        return this.d;
    }
    
}
