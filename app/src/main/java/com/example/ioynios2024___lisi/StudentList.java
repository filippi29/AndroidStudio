package com.example.ioynios2024___lisi;

import android.content.res.AssetManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class StudentList {

    ArrayList<Student> stdList = new ArrayList<Student>();    //δημιουργία ArrayList τύπου student
    ArrayList<String>  studentNames = new ArrayList<String>();

    //kataskevastis
    public StudentList(AssetManager assets){              //constructor
        try{
            InputStream is = assets.open("records2024.xml");   //ονομα αρχειου xml

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("student");   //<student>

            for (int i = 0; i<nList.getLength(); i++){
                Node node = nList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    NodeList nameNode = ((Element)node).getElementsByTagName("name").item(0).getChildNodes();
                    String name = nameNode.item(0).getNodeValue();
                    //System.out.println("Student name: " +name);        //Debug print

                    studentNames.add(name);    //lista MONO ME TA ONOMATA
                    NodeList modelsNode = ((Element)node).getElementsByTagName("grades").item(0).getChildNodes();  //<grades>
                    String grades = modelsNode.item(0).getNodeValue();    //grades
                    //System.out.println("Grades: " +grades);       //Debug print

                    stdList.add(new Student(name, grades));


                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //kano getter gia ta onomata na ta parw sthn main na ta valo sto spinner
    public ArrayList<String> getStudentNames() {
        return studentNames;
    }

    //gia to erotima 3
    public String getAverage(String n){
        for(int i=0; i<stdList.size(); i++){
            if(stdList.get(i).getName().equals((n))){
                    return stdList.get(i).findAverage();
            }
        }
        return "";
    }

}
