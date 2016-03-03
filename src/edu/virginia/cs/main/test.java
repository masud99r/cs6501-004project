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
        String str = "&lt;p&gt;Well, here's how we do it on Stack Overflow.&lt;/p&gt;&#xA;&#xA;&lt;pre class=&quot;lang-csharp prettyprint-override&quot;&gt;&lt;code&gt;var ts = new TimeSpan(DateTime.UtcNow.Ticks - dt.Ticks);&#xA;double delta = Math.Abs(ts.TotalSeconds);&#xA;&#xA;if (delta &amp;lt; 60)&#xA;{&#xA;  return ts.Seconds == 1 ? &quot;one second ago&quot; : ts.Seconds + &quot; seconds ago&quot;;&#xA;}&#xA;if (delta &amp;lt; 120)&#xA;{&#xA;  return &quot;a minute ago&quot;;&#xA;}&#xA;if (delta &amp;lt; 2700) // 45 * 60&#xA;{&#xA;  return ts.Minutes + &quot; minutes ago&quot;;&#xA;}&#xA;if (delta &amp;lt; 5400) // 90 * 60&#xA;{&#xA;  return &quot;an hour ago&quot;;&#xA;}&#xA;if (delta &amp;lt; 86400) // 24 * 60 * 60&#xA;{&#xA;  return ts.Hours + &quot; hours ago&quot;;&#xA;}&#xA;if (delta &amp;lt; 172800) // 48 * 60 * 60&#xA;{&#xA;  return &quot;yesterday&quot;;&#xA;}&#xA;if (delta &amp;lt; 2592000) // 30 * 24 * 60 * 60&#xA;{&#xA;  return ts.Days + &quot; days ago&quot;;&#xA;}&#xA;if (delta &amp;lt; 31104000) // 12 * 30 * 24 * 60 * 60&#xA;{&#xA;  int months = Convert.ToInt32(Math.Floor((double)ts.Days / 30));&#xA;  return months &amp;lt;= 1 ? &quot;one month ago&quot; : months + &quot; months ago&quot;;&#xA;}&#xA;int years = Convert.ToInt32(Math.Floor((double)ts.Days / 365));&#xA;return years &amp;lt;= 1 ? &quot;one year ago&quot; : years + &quot; years ago&quot;;&#xA;&lt;/code&gt;&lt;/pre&gt;&#xA;&#xA;&lt;p&gt;Suggestions? Comments? Ways to improve this algorithm?&lt;/p&gt;&#xA;";
        System.out.println(html2text(str));
    }

    public static String html2text(String html) {
        Document doc = Jsoup.parse(Jsoup.parse(html).text());
        String str = "";
        for (Element temp : doc.select("p")) {
            str += temp.text() + " ";
        }
        System.out.println(str.trim());
        String text = doc.select("code").first().text();
        return text;
    }

}
