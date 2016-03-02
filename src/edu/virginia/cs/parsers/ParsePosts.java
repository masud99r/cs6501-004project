/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.parsers;

import edu.virginia.cs.descriptors.Posts;
import edu.virginia.cs.descriptors.Users;
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
public class ParsePosts {

    private SAXParserFactory factory;
    private SAXParser saxParser;

    public ParsePosts() {
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
            PostHandler postHandler = new PostHandler("./data/parsedData/posts.txt");
            saxParser.parse(inputFile, postHandler);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class PostHandler extends DefaultHandler {

    private ArrayList<Posts> postList;
    private Posts post;
    private FileWriter fwriter;

    public PostHandler(String filename) {
        postList = new ArrayList<>();
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
        if (qName.equalsIgnoreCase("posts")) {
            System.out.println("Parsing Started!!!");
        } else if (qName.equalsIgnoreCase("row")) {
            post = new Posts();
            String postId = attributes.getValue("Id");
            if (postId != null) {
                post.setId(Integer.parseInt(postId));
            }
            String postTypeId = attributes.getValue("PostTypeId");
            if (postTypeId != null) {
                post.setPostTypeId(Integer.parseInt(postTypeId));
            }
            String parentId = attributes.getValue("ParentId");
            if (parentId != null) {
                post.setParentId(Integer.parseInt(parentId));
            }
            String anwerId = attributes.getValue("AcceptedAnswerId");
            if (anwerId != null) {
                post.setAcceptedAnswerId(Integer.parseInt(anwerId));
            }
            String creationDate = attributes.getValue("CreationDate");
            if (creationDate != null) {
                post.setCreationDate(creationDate);
            }
            String score = attributes.getValue("Score");
            if (score != null) {
                post.setScore(Integer.parseInt(score));
            }
            String viewCount = attributes.getValue("ViewCount");
            if (viewCount != null) {
                post.setViewCount(Integer.parseInt(viewCount));
            }
            String body = attributes.getValue("Body");
            if (body != null) {
                post.setBody(body);
            }
            String ownerId = attributes.getValue("OwnerUserId");
            if (ownerId != null) {
                post.setOwnerUserId(Integer.parseInt(ownerId));
            }
            String title = attributes.getValue("Title");
            if (title != null) {
                post.setTitle(html2text(title));
            }
            String tags = attributes.getValue("Tags");
            if (tags != null) {
                post.setTags(tags);
            }
            String answerCount = attributes.getValue("AnswerCount");
            if (answerCount != null) {
                post.setAnswerCount(Integer.parseInt(answerCount));
            }
            String commentCount = attributes.getValue("CommentCount");
            if (commentCount != null) {
                post.setCommentCount(Integer.parseInt(commentCount));
            }
            String favoriteCount = attributes.getValue("FavoriteCount");
            if (favoriteCount != null) {
                post.setFavoriteCount(Integer.parseInt(favoriteCount));
            }
            postList.add(post);
        } else {
            System.err.println("Unknown tag in the file!");
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("posts")) {
            System.out.println("Parsing Completed!!!");
            try {
                fwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (qName.equalsIgnoreCase("row")) {
            try {
                fwriter.write(post.getId() + "\t" + post.getPostTypeId() + "\t" + post.getParentId() + "\t" + post.getAcceptedAnswerId()
                        + "\t" + post.getCreationDate() + "\t" + post.getScore() + "\t" + post.getViewCount()
                        + "\t" + post.getBody() + "\t" + post.getOwnerUserId() + "\t" + post.getTitle() + "\t" + post.getTags()
                        + "\t" + post.getAnswerCount() + "\t" + post.getCommentCount() + "\t" + post.getFavoriteCount() + "\n");
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
