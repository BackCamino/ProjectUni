package it.unicam.cs.mpgc.rpg126523.persistence.dom;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class CourseXMLReader {
    private File xmlFile;
    Document document;

    public CourseXMLReader(File xmlFile) {
        this.xmlFile = xmlFile;
    }
    public void init() {
   
    }
}
