package project;

/**
 * Hello world!
 *
 */
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class App 
{
    public static void main( String[] args )
    {

        Document doc;
        Document doc2;
        try {
            doc = Jsoup.connect("https://www.sechenov.ru/").get();
      String  link = doc.getElementsByClass("main-news-item").first().getElementsByTag("a").attr("href");

      link="https://www.sechenov.ru"+link;
         doc2=Jsoup.connect(link).get();
        String text=doc2.getElementsByClass("news-detail-txt").first().getElementsByTag("p").text();
        String imagelink=doc2.getElementsByClass("news-detail-txt").first().getElementsByTag("p").first().getElementsByTag("img").attr("src");
            System.out.println(imagelink);
        System.out.println(text);
            Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.txt"), "utf-8"));
            writer.write(text);
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
