package it.unicam.cs.mpgc.rpg126523.persistence.dom;

import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import it.unicam.cs.mpgc.rpg126523.model.exam.Exam;
import it.unicam.cs.mpgc.rpg126523.model.exam.GeneralExam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CourseXMLReader {
    private String filePath ;
    Document document;

    public CourseXMLReader(String filePath) {
        this.filePath = filePath;
        initDocument();
    }
    public void initDocument() {
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new NullPointerException("Il percorso file non è stato trovato." + filePath);
        }
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        NodeList courseNodes = document.getElementsByTagName("course");
        for (int i = 0; i < courseNodes.getLength(); i++) {
            courses.add(readCourse((Element) courseNodes.item(i)));
        }

        return courses;
    }

    private Course readCourse(Element element) {
        int id = Integer.parseInt(element.getAttribute("id"));
        String name = element.getElementsByTagName("name").item(0).getTextContent();
        int cfu = Integer.parseInt(element.getElementsByTagName("cfu").item(0).getTextContent());
        Exam exam = readExam((Element) element.getElementsByTagName("exam").item(0));
        return new Course(id,name,cfu,exam);

    }

    private Exam readExam(Element element) {
        int requiredKnowledge= Integer.parseInt(element.getElementsByTagName("requiredKnowledge").item(0).getTextContent());
        String type = element.getElementsByTagName("type").item(0).getTextContent();
        if(("general").equals(type))
             return new GeneralExam(requiredKnowledge,type);
        throw new IllegalArgumentException("tipo di esame non riconosciuto");
    }

}
