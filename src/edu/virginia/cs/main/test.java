/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Wasi
 */
public class test {

    public static void main(String[] args) {
        String str = "&lt;p&gt;I've had no trouble using the BSD sockets API in C++, in GNU/Linux. Here's the sample program I used:&lt;/p&gt;&#xD;&#xA;&#xD;&#xA;&lt;pre&gt;&lt;code&gt;#include &amp;lt;sys/socket.h&amp;gt;&lt;br&gt;&lt;br&gt;int&lt;br&gt;main()&lt;br&gt;{&lt;br&gt;    return AF_INET;&lt;br&gt;}&lt;br&gt;&lt;/code&gt;&lt;/pre&gt;&#xD;&#xA;&#xD;&#xA;&lt;p&gt;So my take on this is that z/OS is probably the complicating factor here, however, because I've never used z/OS before, much less programmed in it, I can't say this definitively. :-P&lt;/p&gt;";
        System.out.println(html2text(str));
    }

    public static String html2text(String html) {
        Document doc = Jsoup.parse(Jsoup.parse(html).text());
        for (Element temp : doc.select("p")) {
            System.out.println(temp.text());
        }
        String text = doc.select("code").first().text();
        return text;
    }

}
