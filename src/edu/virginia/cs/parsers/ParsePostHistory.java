/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.parsers;

import edu.virginia.cs.descriptors.PostHistory;
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
public class ParsePostHistory {

    private SAXParserFactory factory;
    private SAXParser saxParser;

    public ParsePostHistory() {
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
            PostHistoryHandler postHistoryHandler = new PostHistoryHandler("./data/parsedData/postHistory.txt");
            saxParser.parse(inputFile, postHistoryHandler);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class PostHistoryHandler extends DefaultHandler {

    private PostHistory postHistory;
    private FileWriter fwriter;

    public PostHistoryHandler(String filename) {
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
        if (qName.equalsIgnoreCase("posthistory")) {
            System.out.println("Parsing Started!!!");
        } else if (qName.equalsIgnoreCase("row")) {
            postHistory = new PostHistory();
            String id = attributes.getValue("Id");
            if (id != null) {
                postHistory.setId(Integer.parseInt(id));
            }
            String postHistoryTypeId = attributes.getValue("PostHistoryTypeId");
            if (postHistoryTypeId != null) {
                postHistory.setPostHistoryTypeId(Integer.parseInt(postHistoryTypeId));
            }
            String postId = attributes.getValue("PostId");
            if (postId != null) {
                postHistory.setPostId(Integer.parseInt(postId));
            }
            String creationDate = attributes.getValue("CreationDate");
            if (creationDate != null) {
                postHistory.setCreationDate(creationDate);
            }
            String userId = attributes.getValue("UserId");
            if (userId != null) {
                postHistory.setUserId(Integer.parseInt(userId));
            }
            String comment = attributes.getValue("Comment");
            if (comment != null) {
                postHistory.setComment(comment);
            }
            String closeReasonId = attributes.getValue("CloseReasonId");
            if (closeReasonId != null) {
                postHistory.setCloseReasonId(Integer.parseInt(closeReasonId));
            }
        } else {
            System.err.println("Unknown tag in the file!");
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("votes")) {
            System.out.println("Parsing Completed!!!");
            try {
                fwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (qName.equalsIgnoreCase("row")) {
            try {
                fwriter.write(postHistory.getId() + "\t" + postHistory.getPostHistoryTypeId() + "\t"
                        + postHistory.getPostId() + "\t" + postHistory.getCreationDate() + postHistory.getUserId()
                        + "\t" + postHistory.getComment() + postHistory.getCloseReasonId() + "\n");
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
