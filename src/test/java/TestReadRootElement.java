import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class TestReadRootElement {
    //@Test
    public void testReadRootElement() {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        File inputFile = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        inputFile = new File("input.xml");

        try {
            doc = builder.parse(inputFile);
        } catch (org.xml.sax.SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Assertions.assertEquals("heroes",doc.getDocumentElement().getNodeName());
    }
}
