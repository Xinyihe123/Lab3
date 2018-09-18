import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

 public class Web {
     public static int wordCounting (final String url){
         String text =  urlToString(url);
         int number = 0;
         for (int i = 0; i < text.length() - 1; i++) {
            if (text.substring(i, i + 1).equals(" ")) {
                number += 1;
            }
         }
         return number;
     }
     /**
      * Retrieve contents from a URL and return them as a string.
      *
      * @param url url to retrieve contents from
      * @return the contents from the url as a string, or an empty string on error
      */
     public static String urlToString(final String url) {
         Scanner urlScanner;
         try {
             urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
         } catch (IOException e) {
             return "";
         }
         String contents = urlScanner.useDelimiter("\\A").next();
         urlScanner.close();
         return contents;
     }
 }

