package jr.jarrobots.website;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    DocumentBuilder builder;
    Document doc;

    public FileReader() throws SAXException, ParserConfigurationException, IOException {
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = builder.parse(new File("/Users/jarek/IdeaProjects/xml/src/main/resources/quest.xml"));
        doc.getDocumentElement().normalize();
    }
    public ArrayList<Question> getQuestions(int i) {
        ArrayList<Question> QuestionList = new ArrayList<>();
        int n;
        String group, segment;
        Node first = doc.getElementsByTagName("questions").item(i);
        group = first.getAttributes().getNamedItem("section").getTextContent();
        segment = first.getAttributes().getNamedItem("segment").getTextContent();
        NodeList nodeList = first.getChildNodes();
        n = nodeList.getLength();
        Node current;
        for (int i=0; i<n; i++) {
            current = nodeList.item(1);
            if (current.getNodeType() == Node.ELEMENT_NODE) {
                Question q = new Question(group,current.getTextContent(),segment);
                QuestionList.add(q);
            }
        }
        return QuestionList;
    }
}