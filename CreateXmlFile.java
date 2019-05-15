package com.dascalitas;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateXmlFile {

    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("mafia");
            doc.appendChild(rootElement);

            // supercars element
            Element department = doc.createElement("department");
            rootElement.appendChild(department);

            // setting attribute to element
            Attr attr = doc.createAttribute("name");
            attr.setValue("Gangster");
            department.setAttributeNode(attr);

            Attr attrib = doc.createAttribute("depId");
            attrib.setValue("4");
            department.setAttributeNode(attrib);

            // member element
            Element guy = doc.createElement("member");
            Attr attrType = doc.createAttribute("memId");
            attrType.setValue("035");
            guy.setAttributeNode(attrType);
            Element fName = doc.createElement("firstName");
            fName.appendChild(doc.createTextNode("Antonio"));
            guy.appendChild(fName);
            Element lName = doc.createElement("lastName");
            lName.appendChild(doc.createTextNode("Scorsseze"));
            guy.appendChild(lName);
            Element birthD = doc.createElement("birthDate");
            birthD.appendChild(doc.createTextNode("17.12.1897"));
            guy.appendChild(birthD);
            Element pos = doc.createElement("position");
            pos.appendChild(doc.createTextNode("Gungster"));
            guy.appendChild(pos);
            Element skills = doc.createElement("skills");
            guy.appendChild(skills);
            Element skill1 = doc.createElement("skill");
            skill1.appendChild(doc.createTextNode("works in circus"));
            skills.appendChild(skill1);
            Element skill2 = doc.createElement("skill");
            skill2.appendChild(doc.createTextNode("real crazy"));
            skills.appendChild(skill2);
            Element skill3 = doc.createElement("skill");
            skill3.appendChild(doc.createTextNode("smoke Parliament"));
            skills.appendChild(skill3);

            department.appendChild(guy);

            Element man = doc.createElement("member");
            Attr attrType1 = doc.createAttribute("memId");
            attrType1.setValue("036");
            man.setAttributeNode(attrType1);
            Element fName1 = doc.createElement("firstName");
            fName1.appendChild(doc.createTextNode("Fernando"));
            man.appendChild(fName1);
            Element lName1 = doc.createElement("lastName");
            lName1.appendChild(doc.createTextNode("Maratono"));
            man.appendChild(lName1);
            Element birthD1 = doc.createElement("birthDate");
            birthD1.appendChild(doc.createTextNode("17.10.1888"));
            man.appendChild(birthD1);
            Element pos1 = doc.createElement("position");
            pos1.appendChild(doc.createTextNode("Gungster"));
            man.appendChild(pos1);
            Element skills1 = doc.createElement("skills");
            man.appendChild(skills1);
            Element skill4 = doc.createElement("skill");
            skill4.appendChild(doc.createTextNode("police captain"));
            skills1.appendChild(skill4);
            Element skill5 = doc.createElement("skill");
            skill5.appendChild(doc.createTextNode("murder"));
            skills1.appendChild(skill5);
            Element skill6 = doc.createElement("skill");
            skill6.appendChild(doc.createTextNode("love coffee"));
            skills1.appendChild(skill6);

            department.appendChild(man);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("mafia.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
