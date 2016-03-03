/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.parsers;

import edu.virginia.cs.descriptors.Comments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.jsoup.Jsoup;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Wasi
 */
public class ParseComments {

    private SAXParserFactory factory;
    private SAXParser saxParser;

    public ParseComments() {
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
            CommentHandler commentHandler = new CommentHandler("./data/parsedData/comments.txt");
            saxParser.parse(inputFile, commentHandler);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class CommentHandler extends DefaultHandler {

    private Comments comment;
    private FileWriter fwriter;

    public CommentHandler(String filename) {
        try {
            fwriter = new FileWriter(filename);
        } catch (IOException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    @Override
    public void startElement(String uri,
            String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("comments")) {
            System.out.println("Parsing Started!!!");
        } else if (qName.equalsIgnoreCase("row")) {
            comment = new Comments();
            String id = attributes.getValue("Id");
            if (id != null) {
                comment.setId(Integer.parseInt(id));
            }
            String postId = attributes.getValue("PostId");
            if (postId != null) {
                comment.setPostId(Integer.parseInt(postId));
            }
            String score = attributes.getValue("Score");
            if (score != null) {
                comment.setScore(Integer.parseInt(score));
            }
            String text = attributes.getValue(html2text("Text"));
            if (text != null) {
                comment.setText(text);
            }
            String creationDate = attributes.getValue("CreationDate");
            if (creationDate != null) {
                comment.setCreationDate(creationDate);
            }
            String userId = attributes.getValue("UserId");
            if (userId != null) {
                comment.setUserId(Integer.parseInt(userId));
            }
        } else {
            System.err.println("Unknown tag in the file!");
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("comments")) {
            System.out.println("Parsing Completed!!!");
            try {
                fwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (qName.equalsIgnoreCase("row")) {
            try {
                fwriter.write(comment.getId() + "\t" + comment.getPostId() + "\t" + comment.getScore() + "\t"
                        + comment.getText() + "\t" + comment.getCreationDate() + "\t" + comment.getUserId() + "\n");
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
