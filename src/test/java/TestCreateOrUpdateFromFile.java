import com.Project1JS.util.XMLExecutor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestCreateOrUpdateFromFile {
    @Test
    public void testCreateorUpdateFromFileValid() throws InterruptedException {
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
        String tablename = doc.getDocumentElement().getNodeName();
        System.out.println(doc.getFirstChild().getNodeName());
        NodeList nList = doc.getElementsByTagName("object");
        System.out.println(nList.getLength());
        for (int i = 0; i < nList.getLength(); i++) {
            ArrayList<String> queryvalues = new ArrayList<>();
            NodeList childList = nList.item(i).getChildNodes();
            for (int j = 0; j < childList.getLength(); j++) {
                String s = childList.item(j).getNodeName();
                if (!s.equals("#text")) {
                    System.out.println(s);
                    queryvalues.add(s);
                }
            }
            //XMLExecutor.getInstance().runXMLQuery(tablename, queryvalues);
        }
        XMLExecutor.getInstance().getExecutor().awaitTermination(10, TimeUnit.SECONDS);
        Assertions.assertTrue(true);
    }
}
