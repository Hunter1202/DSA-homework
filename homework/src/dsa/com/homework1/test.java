package dsa.com.homework1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        try {
//            Document document = builder.parse(
//                    new FileInputStream("C:\\Users\\Truc\\Desktop\\CA\\employees.xml"));
//            System.out.println(document);
            String xml = "C:\\Users\\Truc\\Desktop\\CA\\employees.xml";
            Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));

        } catch (SAXException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        String xml = "C:\\Users\\Truc\\Desktop\\CA\\employees.xml";
        Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "/Employees/Employee[@emplid='3333']/email";

//read a string value
        String email = xPath.compile(expression).evaluate(xmlDocument);

//read an xml node using xpath
        Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);

//read a nodelist using xpath
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

        String expression1 = "/Employees/Employee/firstname";
        System.out.println(expression1);
        NodeList nodeList1 = (NodeList) xPath.compile(expression1).evaluate(xmlDocument, XPathConstants.NODESET);
        for (int i = 0; i < nodeList1.getLength(); i++) {
            System.out.println(nodeList1.item(i).getFirstChild().getNodeValue());
        }
    }
}
