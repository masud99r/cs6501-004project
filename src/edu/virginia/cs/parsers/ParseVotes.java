/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.parsers;

import edu.virginia.cs.descriptors.Votes;
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
public class ParseVotes {

    private SAXParserFactory factory;
    private SAXParser saxParser;

    public ParseVotes() {
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
            VoteHandler voteHandler = new VoteHandler("./data/parsedData/votes.txt");
            saxParser.parse(inputFile, voteHandler);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class VoteHandler extends DefaultHandler {

    private Votes vote;
    private FileWriter fwriter;

    public VoteHandler(String filename) {
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
        if (qName.equalsIgnoreCase("votes")) {
            System.out.println("Parsing Started!!!");
        } else if (qName.equalsIgnoreCase("row")) {
            vote = new Votes();
            String id = attributes.getValue("Id");
            if (id != null) {
                vote.setId(Integer.parseInt(id));
            }
            String postId = attributes.getValue("PostId");
            if (postId != null) {
                vote.setPostId(Integer.parseInt(postId));
            }
            String creationDate = attributes.getValue("CreationDate");
            if (creationDate != null) {
                vote.setCreationDate(creationDate);
            }
            String voteTypeId = attributes.getValue("VoteTypeId");
            if (voteTypeId != null) {
                vote.setVoteTypeId(Integer.parseInt(voteTypeId));
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
                fwriter.write(vote.getId() + "\t" + vote.getPostId() + "\t" + vote.getVoteTypeId()+ "\t" 
                        + vote.getCreationDate()+ "\n");
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
