package com.dascalitas;

import org.w3c.dom.Document;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMParser {

    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Name organisation :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("member");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("member ID number : "
                            + eElement.getAttribute("memId"));
                    System.out.println("First Name : "
                            + eElement
                            .getElementsByTagName("firstName")
                            .item(0)
                            .getTextContent());
                    System.out.println("Last Name : "
                            + eElement
                            .getElementsByTagName("lastName")
                            .item(0)
                            .getTextContent());
                    System.out.println("date of birth : "
                            + eElement
                            .getElementsByTagName("birthDate")
                            .item(0)
                            .getTextContent());
                    System.out.println("position in Famiglia : "
                            + eElement
                            .getElementsByTagName("position")
                            .item(0)
                            .getTextContent());

                    for (int skill = 0; skill < eElement.getElementsByTagName("skill").getLength() ; skill ++) {
                        System.out.println(eElement.getElementsByTagName("skill").item(skill).getTextContent());
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
