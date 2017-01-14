package xml_reader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;

import folder_class.info;
public class xml_reader {
 
	//private String file_name;
	public static ArrayList<info> reader(String path)
	{
		ArrayList<info> list = new ArrayList<info>();
try {

	File fXmlFile = new File(path);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("staff");

	//System.out.println("----------------------------");
	//ArrayList<info> list = new ArrayList<info>();
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		//System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			info emp = new info();
			emp.setFirst_name(eElement.getElementsByTagName("firstname").item(0).getTextContent());
			emp.setLast_nme(eElement.getElementsByTagName("lastname").item(0).getTextContent());
			emp.setNick_name(eElement.getElementsByTagName("nickname").item(0).getTextContent());
			emp.setId(Integer.parseInt(eElement.getAttribute("id")));
			emp.setSalary(Integer.parseInt(eElement.getElementsByTagName("salary").item(0).getTextContent()));
			//System.out.println("Staff id : " + eElement.getAttribute("id"));
			//System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
			list.add(emp);
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
	return list;
	}
}