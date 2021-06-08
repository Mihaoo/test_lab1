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

class XMLCreate {
    public static void main(String argv[]) {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();


            Element films = doc.createElement("masini");
            doc.appendChild(films);


            Element Category = doc.createElement("caroserie");
            films.appendChild(Category);


            Attr idCategory = doc.createAttribute("idCaroserie");
            idCategory.setValue("001");
            Category.setAttributeNode(idCategory);


            Attr Categoryname = doc.createAttribute("numeCaroserie");
            Categoryname.setValue("sedan");
            Category.setAttributeNode(Categoryname);


            Element film1 = doc.createElement("masina");
            Category.appendChild(film1);


            Attr filmid = doc.createAttribute("idMasina");
            filmid.setValue("0001");
            film1.setAttributeNode(filmid);


            Element Regizor = doc.createElement("Marca");
            Regizor.appendChild(doc.createTextNode("BMW"));
            film1.appendChild(Regizor);

            Element Name = doc.createElement("Model");
            Name.appendChild(doc.createTextNode("M5"));
            film1.appendChild(Name);


            Element Publication = doc.createElement("An");
            Publication.appendChild(doc.createTextNode("2020"));
            film1.appendChild(Publication);

            Element availability = doc.createElement("disponibilitate");
            availability.appendChild(doc.createTextNode("true"));
            film1.appendChild(availability);


            Element Casts = doc.createElement("completatii");
            film1.appendChild(Casts);

            Element Cast1 = doc.createElement("completatie");
            Cast1.appendChild(doc.createTextNode("Basic"));
            Casts.appendChild(Cast1);

            Element Cast2 = doc.createElement("completatie");
            Cast2.appendChild(doc.createTextNode("Lux"));
            Casts.appendChild(Cast2);

            Element Cast3 = doc.createElement("completatie");
            Cast3.appendChild(doc.createTextNode("dyamond"));
            Casts.appendChild(Cast3);




            Element film2 = doc.createElement("masina");
            Category.appendChild(film2);


            Attr filmid2 = doc.createAttribute("idMasina");
            filmid2.setValue("0002");
            film2.setAttributeNode(filmid2);


            Element Regizor2 = doc.createElement("Marca");
            Regizor2.appendChild(doc.createTextNode("Mercedes"));
            film2.appendChild(Regizor2);


            Element Name2 = doc.createElement("Model");
            Name2.appendChild(doc.createTextNode("S Class"));
            film2.appendChild(Name2);


            Element Publication2 = doc.createElement("An");
            Publication2.appendChild(doc.createTextNode("2021"));
            film2.appendChild(Publication2);

            Element availability2 = doc.createElement("disponibilitate");
            availability2.appendChild(doc.createTextNode("true"));
            film2.appendChild(availability2);


            Element Casts2 = doc.createElement("completatii");
            film2.appendChild(Casts2);


            Element Cast12 = doc.createElement("completatie");
            Cast12.appendChild(doc.createTextNode("Basic"));
            Casts2.appendChild(Cast12);

            Element Cast22 = doc.createElement("completatie");
            Cast22.appendChild(doc.createTextNode("Basic+"));
            Casts2.appendChild(Cast22);

            Element Cast32 = doc.createElement("completatie");
            Cast32.appendChild(doc.createTextNode("Luxury"));
            Casts2.appendChild(Cast32);




            Element Category2 = doc.createElement("caroserie");
            films.appendChild(Category2);

            Attr idCategory2 = doc.createAttribute("idCaroserie");
            idCategory2.setValue("002");
            Category2.setAttributeNode(idCategory2);

            Attr Categoryname2 = doc.createAttribute("numeCaroserie");
            Categoryname2.setValue("SUV");
            Category2.setAttributeNode(Categoryname2);

            Element film3 = doc.createElement("masina");
            Category2.appendChild(film3);

            Attr filmid3 = doc.createAttribute("idMasina");
            filmid3.setValue("0003");
            film3.setAttributeNode(filmid3);

            Element Regizor3 = doc.createElement("Marca");
            Regizor3.appendChild(doc.createTextNode("BMW"));
            film3.appendChild(Regizor3);


            Element Name3 = doc.createElement("Model");
            Name3.appendChild(doc.createTextNode("X6 M"));
            film3.appendChild(Name3);


            Element Publication3 = doc.createElement("An");
            Publication3.appendChild(doc.createTextNode("2019"));
            film3.appendChild(Publication3);


            Element availability3 = doc.createElement("disponibilitate");
            availability3.appendChild(doc.createTextNode("true"));
            film3.appendChild(availability3);

            Element Casts3 = doc.createElement("completatii");
            film3.appendChild(Casts3);

            Element Cast31 = doc.createElement("completatie");
            Cast31.appendChild(doc.createTextNode("Basic"));
            Casts3.appendChild(Cast31);

            Element Cast322 = doc.createElement("completatie");
            Cast322.appendChild(doc.createTextNode("Medium"));
            Casts3.appendChild(Cast322);

            Element Cast323 = doc.createElement("completatie");
            Cast323.appendChild(doc.createTextNode("Lux+"));
            Casts3.appendChild(Cast323);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("masini.xml"));
            transformer.transform(source, result);


            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}