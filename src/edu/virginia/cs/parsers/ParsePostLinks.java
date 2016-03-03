/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.parsers;

import edu.virginia.cs.descriptors.PostLinks;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Wasi
 */
public class ParsePostLinks {

    private SAXParserFactory factory;
    private SAXParser saxParser;

    public ParsePostLinks() {
        try {
            factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFile(String filename) {
        try {
            File inputFile = new File(filename);
            PostLinksHandler postLinksHandler = new PostLinksHandler("./data/parsedData/postLinks.txt");
            saxParser.parse(inputFile, postLinksHandler);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class PostLinksHandler extends DefaultHandler {

    private PostLinks postLinks;
    private FileWriter fwriter;

    public PostLinksHandler(String filename) {
        try {
            fwriter = new FileWriter(filename);
        } catch (IOException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void startElement(String uri,
            String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("postlinks")) {
            System.out.println("Parsing Started!!!");
        } else if (qName.equalsIgnoreCase("row")) {
            postLinks = new PostLinks();
            String id = attributes.getValue("Id");
            if (id != null) {
                postLinks.setId(Integer.parseInt(id));
            }
            String creationDate = attributes.getValue("CreationDate");
            if (creationDate != null) {
                postLinks.setCreationDate(creationDate);
            }
            String postId = attributes.getValue("PostId");
            if (postId != null) {
                postLinks.setPostId(Integer.parseInt(postId));
            }
            String relatedPostId = attributes.getValue("RelatedPostId");
            if (relatedPostId != null) {
                postLinks.setRelatedPostId(Integer.parseInt(relatedPostId));
            }
            String postLinkTypeId = attributes.getValue("PostLinkTypeId");
            if (postLinkTypeId != null) {
                postLinks.setPostLinkTypeId(Integer.parseInt(postLinkTypeId));
            }
        } else {
            System.err.println("Unknown tag in the file!");
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("postlinks")) {
            System.out.println("Parsing Completed!!!");
            try {
                fwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (qName.equalsIgnoreCase("row")) {
            try {
                fwriter.write(postLinks.getId() + "\t" + postLinks.getCreationDate() + "\t" + postLinks.getPostId()
                        + "\t" + postLinks.getRelatedPostId() + "\t" + postLinks.getPostLinkTypeId() + "\n");
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void characters(char ch[],
            int start, int length) throws SAXException {
    }
}
