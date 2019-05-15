package com.dascalitas;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class QueryXmlFile {

    public static void main(String argv[]) {

        String ID = "032";
        try {
         getInfo(ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getInfo(String ID) throws IOException, SAXException, ParserConfigurationException {
        File inputFile = new File("company.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.print("Root element: ");
        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("member");
        System.out.println("----------------------------");


        while (Integer.valueOf(ID) >= 0) {
            Node nNode = nList.item(Integer.valueOf(ID));
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.print("Name : ");
                System.out.println(eElement.getElementsByTagName("firstName").item(0).getTextContent() +
                        " " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.print("His ID : ");
                System.out.println(eElement.getAttribute("memId"));
                System.out.print("His mentor : ");
                System.out.println(eElement.getElementsByTagName("managerId").item(0).getTextContent());
                int num = Integer.valueOf(eElement.getElementsByTagName("managerId").item(0).getTextContent()) - 1;
                ID = String.format("%03d", num);
                System.out.println(ID);
           }
        }
        return ID;
    }
    }