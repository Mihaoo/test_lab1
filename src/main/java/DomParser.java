
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("masini.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
               NodeList nList = doc.getElementsByTagName("masina");


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);



                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("id : "
                            + eElement.getAttribute("idMasina"));
                    System.out.println("Marca : "
                            + eElement
                            .getElementsByTagName("Marca")
                            .item(0)
                            .getTextContent());
                    System.out.println("Model : "
                            + eElement
                            .getElementsByTagName("Model")
                            .item(0)
                            .getTextContent());
                    System.out.println("An : "
                            + eElement
                            .getElementsByTagName("An")
                            .item(0)
                            .getTextContent());
                    System.out.println("disponibilitate : "
                            + eElement
                            .getElementsByTagName("disponibilitate")
                            .item(0)
                            .getTextContent());
                    if(eElement.getElementsByTagName("completatii").getLength()>0){
                        System.out.println("completatie : "
                                +eElement.getElementsByTagName("completatie")
                                .item(0)
                                .getTextContent());
                    }System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
