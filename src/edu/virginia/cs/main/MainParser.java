/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.main;

import edu.virginia.cs.index.BadgeIndexer;
import edu.virginia.cs.index.CommentIndexer;
import edu.virginia.cs.index.PostHistoryIndexer;
import edu.virginia.cs.index.PostIndexer;
import edu.virginia.cs.index.PostLinkIndexer;
import edu.virginia.cs.index.TagIndexer;
import edu.virginia.cs.parsers.ParseUsers;
import edu.virginia.cs.index.UserIndexer;
import edu.virginia.cs.index.VoteIndexer;
import edu.virginia.cs.parsers.ParseBadges;
import edu.virginia.cs.parsers.ParseComments;
import edu.virginia.cs.parsers.ParsePostHistory;
import edu.virginia.cs.parsers.ParsePostLinks;
import edu.virginia.cs.parsers.ParsePosts;
import edu.virginia.cs.parsers.ParseTags;
import edu.virginia.cs.parsers.ParseVotes;
import java.io.IOException;

/**
 *
 * @author Wasi
 */
public class MainParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        if (args.length == 0) {
            System.out.println("Can't parse. No arguments found!");
        } else {
            if (args[0].equalsIgnoreCase("users")) {
                parseUserData();
            } else if (args[0].equalsIgnoreCase("tags")) {
                parseTagData();
            } else if (args[0].equalsIgnoreCase("badges")) {
                parseBadgeData();
            } else if (args[0].equalsIgnoreCase("comments")) {
                parseCommentData();
            } else if (args[0].equalsIgnoreCase("posts")) {
                parsePostData();
            } else if (args[0].equalsIgnoreCase("postlinks")) {
                parsePostLinkData();
            } else if (args[0].equalsIgnoreCase("posthistory")) {
                parsePostHistoryData();
            } else if (args[0].equalsIgnoreCase("votes")) {
                parseVoteData();
            } else {
                System.out.println("Unknown filename for parsing!");
            }
        }
    }

    public static void parseUserData() throws IOException {
        ParseUsers parser = new ParseUsers();
        parser.readFile("data/stackoverflowDump/Users.xml");
        UserIndexer.index("lucene-stackoverflow-index/users-index", "data/parsedData/", "users.txt"); // building index for users
    }

    public static void parseTagData() throws IOException {
        ParseTags parser = new ParseTags();
        parser.readFile("data/stackoverflowDump/Tags.xml");
        TagIndexer.index("lucene-stackoverflow-index/tags-index", "data/parsedData/", "tags.txt"); // building index for users
    }

    public static void parseBadgeData() throws IOException {
        ParseBadges parser = new ParseBadges();
        parser.readFile("data/stackoverflowDump/Badges.xml");
        BadgeIndexer.index("lucene-stackoverflow-index/badges-index", "data/parsedData/", "badges.txt"); // building index for users
    }

    public static void parseCommentData() throws IOException {
        ParseComments parser = new ParseComments();
        parser.readFile("data/stackoverflowDump/Comments.xml");
        CommentIndexer.index("lucene-stackoverflow-index/comment-index", "data/parsedData/", "comments.txt"); // building index for users
    }

    public static void parsePostData() throws IOException {
        ParsePosts parser = new ParsePosts();
        parser.readFile("data/stackoverflowDump/Posts.xml");
        PostIndexer.index("lucene-stackoverflow-index/post-index", "data/parsedData/", "posts.txt"); // building index for users
    }

    public static void parsePostLinkData() throws IOException {
        ParsePostLinks parser = new ParsePostLinks();
        parser.readFile("data/stackoverflowDump/PostLinks.xml");
        PostLinkIndexer.index("lucene-stackoverflow-index/post-link-index", "data/parsedData/", "post_links.txt"); // building index for users
    }

    public static void parsePostHistoryData() throws IOException {
        ParsePostHistory parser = new ParsePostHistory();
        parser.readFile("data/stackoverflowDump/PostHistory.xml");
        PostHistoryIndexer.index("lucene-stackoverflow-index/post-history-index", "data/parsedData/", "post_history.txt"); // building index for users
    }

    public static void parseVoteData() throws IOException {
        ParseVotes parser = new ParseVotes();
        parser.readFile("data/stackoverflowDump/Votes.xml");
        VoteIndexer.index("lucene-stackoverflow-index/vote-index", "data/parsedData/", "votes.txt"); // building index for users
    }
}
