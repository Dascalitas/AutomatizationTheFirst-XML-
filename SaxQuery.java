package com.dascalitas;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxQuery {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            QueryHandler userhandler = new QueryHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class QueryHandler extends DefaultHandler {

    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bBirthDate = false;
    boolean bPosition = false;
    boolean bSkill = false;
    String memId = null;
    String query = "011";

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("member")) {
            memId = attributes.getValue("memId");
        }
        if((query).equals(memId) && qName.equalsIgnoreCase("member")) {
            System.out.println("He is :" + qName);
        }
        if (qName.equalsIgnoreCase("firstName")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("lastName")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("birthDate")) {
            bBirthDate = true;
        }
        else if (qName.equalsIgnoreCase("position")) {
            bPosition = true;
        } else if (qName.equalsIgnoreCase("skill")) {
            bSkill = true;
        }
    }

    @Override
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("member")) {

            if((query).equals(memId)
                    && qName.equalsIgnoreCase("member"))
                System.out.println("He also is :" + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (bFirstName && (query).equals(memId)) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName && (query).equals(memId)) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bBirthDate && (query).equals(memId)) {
            System.out.println("Birth Date: " + new String(ch, start, length));
            bBirthDate = false;
        } else if (bPosition && (query).equals(memId)) {
            System.out.println("Position: " + new String(ch, start, length));
            bPosition = false;
        } else if (bSkill && (query).equals(memId)) {
            System.out.println("Skill: " + new String(ch, start, length));
            bSkill = false;
        }
    }
}