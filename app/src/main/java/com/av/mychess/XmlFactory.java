package com.av.mychess;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlFactory {
    public static final String BOARD_FILE_EXTENSION = ".board", GAME = "game", BOARD = "board", X = "x", Y = "y", PIECE = "piece", NAME = "name", COLOR = "color", BLACK = "black", WHITE = "white";

    public static Document loadXmlFromPath(String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            FileInputStream fis = new FileInputStream(path);
            InputSource inputSource = new InputSource(fis);

            return builder.parse(inputSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null in case of an error
    }

    public static void writeXmlToFile(Document xmlDoc, String filePath) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Configure the transformer to format the XML nicely
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            // Create a File object for the specified file path
            File outputFile = new File(filePath);

            // Create an OutputStream to write the XML content to the file
            OutputStream os = new FileOutputStream(outputFile);

            // Create a StreamResult to specify where the XML will be written
            StreamResult streamResult = new StreamResult(os);

            // Use the transformer to write the XML document to the file
            transformer.transform(new DOMSource(xmlDoc), streamResult);

            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Document getChessBoardAsXml() {
        //todo
        return null;
    }
}
