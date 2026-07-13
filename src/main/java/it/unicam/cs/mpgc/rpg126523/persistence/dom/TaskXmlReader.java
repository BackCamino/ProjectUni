package it.unicam.cs.mpgc.rpg126523.persistence.dom;

import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskDefault;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskUniversity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskXmlReader {
    private final String filePath ;
    Document document;
    public TaskXmlReader(String filePath) {
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
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        NodeList taskNodes = document.getElementsByTagName("task");
        for (int i = 0; i < taskNodes.getLength(); i++) {
            tasks.add(readTask((Element) taskNodes.item(i)));
        }
        return tasks;
    }

    private Task readTask(Element element) {
        String type = element.getAttribute("type");
        String name = element.getElementsByTagName("name").item(0).getTextContent().trim();
        String description = element.getElementsByTagName("description").item(0).getTextContent().trim();
        int duration = Integer.parseInt(element.getElementsByTagName("duration").item(0).getTextContent().trim());

        Element consequences = (Element) element.getElementsByTagName("consequences").item(0);
        int deltaEnergy = readDelta(consequences, "energy");
        int deltaStress = readDelta(consequences, "stress");

        if ("university".equalsIgnoreCase(type)) {
            int idCourse = Integer.parseInt(element.getElementsByTagName("idCourse").item(0).getTextContent().trim());
            int deltaKnowledge = readDelta(consequences, "knowledge");
            return new TaskUniversity(name, description, duration, deltaEnergy, deltaStress, idCourse, deltaKnowledge);
        }
        return new TaskDefault(description, name, duration, deltaEnergy, deltaStress);
    }

    private int readDelta(Element consequences, String tag) {
        NodeList list = consequences.getElementsByTagName(tag);
        if (list.getLength() == 0) return 0;
        Element el = (Element) list.item(0);
        int value = Integer.parseInt(el.getTextContent().trim());
        return "decrease".equalsIgnoreCase(el.getAttribute("type")) ? -value : value;
    }


}
