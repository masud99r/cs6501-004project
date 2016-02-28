/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.main;

import edu.virginia.cs.parsers.ParseUsers;
import edu.virginia.cs.index.UserIndexer;
import java.io.IOException;
import edu.virginia.cs.descriptors.Users;

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
        parseUserData();
    }

    public static void parseUserData() throws IOException {
        ParseUsers parser = new ParseUsers();
//        parser.readFile("./data/stackoverflowDump/Users.xml");
        UserIndexer.index("lucene-stackoverflow-index/users-index", "./data/parsedData/", "users.txt"); // building index for users
    }
}
