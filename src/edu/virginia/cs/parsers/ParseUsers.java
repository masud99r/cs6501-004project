/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.parsers;

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
import edu.virginia.cs.descriptors.Users;

/**
 *
 * @author Wasi
 */
public class ParseUsers {

    private SAXParserFactory factory;
    private SAXParser saxParser;

    public ParseUsers() {
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
            UserHandler userHandler = new UserHandler("./data/parsedData/users.txt");
            saxParser.parse(inputFile, userHandler);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class UserHandler extends DefaultHandler {

    private Users user;
    private FileWriter fwriter;

    public UserHandler(String filename) {
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
        if (qName.equalsIgnoreCase("users")) {
            System.out.println("Parsing Started!!!");
        } else if (qName.equalsIgnoreCase("row")) {
            user = new Users();
            String userId = attributes.getValue("Id");
            if (userId != null) {
                user.setUserId(Integer.parseInt(userId));
            }
            String reputation = attributes.getValue("Reputation");
            if (reputation != null) {
                user.setReputation(Integer.parseInt(reputation));
            }
            String creationDate = attributes.getValue("CreationDate");
            if (creationDate != null) {
                user.setCreationDate(creationDate);
            }
            String displayName = attributes.getValue("DisplayName");
            if (displayName != null) {
                user.setDisplayName(html2text(displayName));
            }
            String emailHash = attributes.getValue("EmailHash");
            if (emailHash != null) {
                user.setEmailHash(emailHash);
            }
            String lastAccessDate = attributes.getValue("LastAccessDate");
            if (lastAccessDate != null) {
                user.setLastAccessDate(lastAccessDate);
            }
            String websiteUrl = attributes.getValue("WebsiteUrl");
            if (websiteUrl != null) {
                user.setWebsiteUrl(websiteUrl);
            }
            String location = attributes.getValue("Location");
            if (location != null) {
                user.setLocation(location);
            }
            String age = attributes.getValue("Age");
            if (age != null) {
                user.setAge(Integer.parseInt(age));
            }
            String aboutMe = attributes.getValue("AboutMe");
            if (aboutMe != null) {
                user.setAboutMe(html2text(aboutMe));
            }
            String views = attributes.getValue("Views");
            if (views != null) {
                user.setViews(Integer.parseInt(views));
            }
            String upVotes = attributes.getValue("UpVotes");
            if (upVotes != null) {
                user.setUpVotes(Integer.parseInt(upVotes));
            }
            String downVotes = attributes.getValue("DownVotes");
            if (downVotes != null) {
                user.setDownVotes(Integer.parseInt(downVotes));
            }
            String accountId = attributes.getValue("AccountId");
            if (accountId != null) {
                user.setAccountId(Integer.parseInt(accountId));
            }
        } else {
            System.err.println("Unknown tag in the file!");
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("users")) {
            System.out.println("Parsing Completed!!!");
            try {
                fwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (qName.equalsIgnoreCase("row")) {
            try {
                fwriter.write(user.getUserId() + "\t" + user.getReputation() + "\t" + user.getDisplayName() + "\t" + user.getWebsiteUrl()
                        + "\t" + user.getViews() + "\t" + user.getUpVotes() + "\t" + user.getDownVotes() + "\n");
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
