package com.socket;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import javax.swing.table.DefaultTableModel;

public class History {
    
    public String filePath;
    
    
    public History(String filePath){
        this.filePath = filePath;
    }
    
   
    public void FillTable(HistoryFrame frame){
      
        DefaultTableModel model = (DefaultTableModel) frame.jTable1.getModel();
    
        try{
            
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("message");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    model.addRow(new Object[]{getTagValue("sender", eElement), getTagValue("content", eElement), getTagValue("recipient", eElement), getTagValue("time", eElement)});
                }
            }
        }
        catch(Exception ex){
            System.out.println("Filling Exception");
        }
    }
    
    public static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
	return nValue.getNodeValue();
  }
}
