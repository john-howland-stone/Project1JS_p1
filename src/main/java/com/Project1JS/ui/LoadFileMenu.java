package com.Project1JS.ui;

import com.Project1JS.util.XMLTransaction;
import com.Project1JS.model.XMLWriteQuery;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for handling loading XML Files into the current transaction.
 * The root element of the XML file is the table name and <Object> elements contain the data as self closing elements.
 * Due to XML limitations numbers cannot be loaded this way.
 * ex:
 * <TableName>
 *     <Object>
 *         <Value1/>
 *         <Value2/>
 *     </Object>
 * </TableName>
 */

public class LoadFileMenu {
    /**
     * Shows the file loading UI
     * @param scan scanner used for input
     */
    public void showMenu(Scanner scan) {
        String answer;
        do{
            System.out.println("enter file path, 'q' to return to previous menu");
            answer = scan.nextLine();
                if (answer.equals("q")) {
                    break;
                }
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            Document doc;
            File inputFile;

            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                System.out.println("Unknown Error");
                continue;
            }

            inputFile = new File(answer);

            if (!inputFile.canRead()) {
                System.out.println("Invaild File");
                continue;
            }

            try {
                doc = builder.parse(inputFile);
            } catch (org.xml.sax.SAXException e) {
                System.out.println("Malformed XML File");
                continue;
            } catch (IOException e) {
                System.out.println("Error Reading from file");
                continue;
            }
            String tablename = doc.getDocumentElement().getNodeName();
            NodeList nList = doc.getElementsByTagName("object");
            for (int i = 0; i < nList.getLength(); i++) {
                ArrayList<String> queryvalues = new ArrayList<>();
                NodeList childList = nList.item(i).getChildNodes();
                for (int j = 0; j < childList.getLength(); j++) {
                    String s = childList.item(j).getNodeName();
                    if (!s.equals("#text")) {
                        queryvalues.add(s);
                    }
                }
                XMLTransaction.getInstance().add(new XMLWriteQuery(tablename,queryvalues));
            }
            System.out.println("Added file to current transaction");
        } while(true);
    }
}
