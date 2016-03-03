/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.index;

import edu.virginia.cs.utility.SpecialAnalyzer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author Wasi
 */
public class CommentIndexer {

    /**
     * Creates the initial index files on disk
     *
     * @param indexPath
     * @return
     * @throws IOException
     */
    private static IndexWriter setupIndex(String indexPath) throws IOException {
        Analyzer analyzer = new SpecialAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46,
                analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        config.setRAMBufferSizeMB(2048.0);

        FSDirectory dir;
        IndexWriter writer = null;
        dir = FSDirectory.open(new File(indexPath));
        writer = new IndexWriter(dir, config);

        return writer;
    }

    /**
     * @param indexPath Where to create the index
     * @param prefix The prefix of all the paths in the fileList
     * @param fileList Each line is a path to a document
     * @throws IOException
     */
    public static void index(String indexPath, String prefix, String fileList)
            throws IOException {
        System.out.println("Creating Lucene index...");
        FieldType _contentFieldType = new FieldType();
        _contentFieldType.setIndexed(true);
        _contentFieldType.setStored(true);

        FieldType _FieldType = new FieldType();
        _FieldType.setIndexed(false);
        _FieldType.setStored(true);

        IndexWriter writer = setupIndex(indexPath);
        BufferedReader br = new BufferedReader(
                new FileReader(prefix + fileList));
        String line = null;
        int indexed = 0;
        while ((line = br.readLine()) != null) {
            String[] splits = line.split("\t");
            Document doc = new Document();
            doc.add(new Field("id", splits[0], _contentFieldType));
            doc.add(new Field("postId", splits[1], _FieldType));
            doc.add(new Field("score", splits[2], _FieldType));
            doc.add(new Field("text", splits[3], _FieldType));
            doc.add(new Field("creationDate", splits[4], _FieldType));
            doc.add(new Field("userId", splits[5], _FieldType));
            writer.addDocument(doc);

            ++indexed;
            if (indexed % 100 == 0) {
                System.out.println(" -> indexed " + indexed + " docs...");
            }
        }
        System.out.println(" -> indexed " + indexed + " total docs.");

        br.close();
        writer.close();
    }
}
