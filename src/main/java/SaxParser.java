
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class SaxParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("masini.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bNickName = false;
    boolean bMarks = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("masina")) {
            String rollNo = attributes.getValue("idMasina");
            System.out.println("idMasina : " + rollNo);
        } else if (qName.equalsIgnoreCase("Marca")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("Model")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("An")) {
            bNickName = true;
        }
        else if (qName.equalsIgnoreCase("disponibilitate")) {
            bMarks = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("masina")) {
            System.out.println("End Element :" + qName);
            System.out.println();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bFirstName) {
            System.out.println("Marca: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Model: " + new String(ch, start, length));
            bLastName = false;
        } else if (bNickName) {
            System.out.println("An: " + new String(ch, start, length));
            bNickName = false;
        } else if (bMarks) {
            System.out.println("disponibilitate: " + new String(ch, start, length));
            bMarks = false;
        }
    }
}
