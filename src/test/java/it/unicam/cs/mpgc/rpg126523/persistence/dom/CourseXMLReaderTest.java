package it.unicam.cs.mpgc.rpg126523.persistence.dom;

import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseXMLReaderTest {

    CourseXMLReader reader;
    @BeforeEach
    void setUp() {

        reader= new CourseXMLReader( "/xml/courses.xml");
    }

    @Test
    void readXML() {
        List<Course> courses= reader.loadCourses();
        courses.forEach(System.out::println);

    }
}