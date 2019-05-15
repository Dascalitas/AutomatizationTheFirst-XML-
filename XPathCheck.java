package com.dascalitas;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathCheck {
    public static void main(String[] args) throws Exception {

        String fileName = "company.xml";
        Document document = getDocument(fileName);

        String xpathExpression = "";

        xpathExpression = "//@memId";
        System.out.printf("%-32s - %b%n","check if ID node exist", checkIfNodeExists(document, xpathExpression));

        xpathExpression = "//firstName";
        System.out.printf("%-32s - %b%n","check if first name node exist", checkIfNodeExists(document, xpathExpression));

        xpathExpression = "//lastName";
        System.out.printf("%-32s - %b%n","check if last name node exist", checkIfNodeExists(document, xpathExpression));

        xpathExpression = "//birthDate";
        System.out.printf("%-32s - %b%n","check if birth date node exist", checkIfNodeExists(document, xpathExpression));

        xpathExpression = "//skills";
        System.out.printf("%-32s - %b%n","check if skills node exist", checkIfNodeExists(document, xpathExpression));

        xpathExpression = "//managerId";
        System.out.printf("%-32s - %b%n","check if id of mentor node exist", checkIfNodeExists(document, xpathExpression));

        System.out.println("_____________________________________________________\n");

        xpathExpression = "//firstName";
        System.out.printf("%-43s - %b%n", "check if first name node has a child node", hasChildElements(document, xpathExpression));

        xpathExpression = "//lastName";
        System.out.printf("%-43s - %b%n", "check if last name node has a child node", hasChildElements(document, xpathExpression));

        xpathExpression = "//birthDate";
        System.out.printf("%-43s - %b%n", "check if birth date node has a child node", hasChildElements(document, xpathExpression));

        xpathExpression = "//skills";
        System.out.printf("%-43s - %b%n", "check if skills node has a child node", hasChildElements(document, xpathExpression));

        xpathExpression = "//managerId";
        System.out.printf("%-43s - %b%n", "check if ID of mentor node has a child node", hasChildElements(document, xpathExpression));
        }

    private static boolean checkIfNodeExists(Document document, String xpathExpression) throws Exception
    {
        boolean matches = false;

        XPathFactory xpathFactory = XPathFactory.newInstance();

        XPath xpath = xpathFactory.newXPath();

        try {
            XPathExpression expr = xpath.compile(xpathExpression);

            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            if(nodes != null  && nodes.getLength() > 0) {
                matches = true;
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return matches;
    }

    private static Document getDocument(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        return doc;
    }

    private static boolean hasChildElements(Document document, String xpathExpression) throws Exception
    {
        boolean child = false;

        XPathFactory xpathFactory = XPathFactory.newInstance();

        XPath xpath = xpathFactory.newXPath();

        try {
            XPathExpression expr = xpath.compile(xpathExpression);

            NodeList children = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            if (children.getLength() > 0 && children.item(0).hasChildNodes()) {
                    child = true;
                }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return child;
    }
}

