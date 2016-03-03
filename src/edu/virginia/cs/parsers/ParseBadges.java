/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.parsers;

import edu.virginia.cs.descriptors.Badges;
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
public class ParseBadges {

    private SAXParserFactory factory;
    private SAXParser saxParser;

    public ParseBadges() {
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
            BadgeHandler badgeHandler = new BadgeHandler("./data/parsedData/badges.txt");
            saxParser.parse(inputFile, badgeHandler);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class BadgeHandler extends DefaultHandler {

    private Badges badge;
    private FileWriter fwriter;

    public BadgeHandler(String filename) {
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
        if (qName.equalsIgnoreCase("badges")) {
            System.out.println("Parsing Started!!!");
        } else if (qName.equalsIgnoreCase("row")) {
            badge = new Badges();
            String userId = attributes.getValue("UserId");
            if (userId != null) {
                badge.setUserId(Integer.parseInt(userId));
            }
            String name = attributes.getValue("Name");
            if (name != null) {
                badge.setName(name);
            }
            String date = attributes.getValue("Date");
            if (date != null) {
                badge.setDate(date);
            }
        } else {
            System.err.println("Unknown tag in the file!");
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("badges")) {
            System.out.println("Parsing Completed!!!");
            try {
                fwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (qName.equalsIgnoreCase("row")) {
            try {
                fwriter.write(badge.getUserId() + "\t" + badge.getName() + "\t" + badge.getDate() + "\n");
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
