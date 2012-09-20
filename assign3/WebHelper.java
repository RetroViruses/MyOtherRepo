import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.text.html.HTMLEditorKit;

/**
 * Used to download a web page.
 * @author Jeff Shantz <x@y> where x = jshantz4, y = csd.uwo.ca
 */
public class WebHelper {
    
    /**
     * Downloads the specified page, populating the Page object with the text
     * and links contained on the web page.
     * @param page The Page to download
     * @throws Exception If the download or parsing of the page fails
     */
    public static void downloadPage(Page page) throws Exception {

        // Create a URL from the page address and clear the page contents
        URL u = new URL(page.getAddress());
        page.clear();

        // Get a parser and setup the callbacks to the PageParser class
        ParserGetter kit = new ParserGetter();
        HTMLEditorKit.Parser parser = kit.getParser();
        HTMLEditorKit.ParserCallback callback = new PageParser(page);

        // Open the URL, download its contents, and parse the page
        InputStream in = u.openStream();
        InputStreamReader r = new InputStreamReader(in);
        parser.parse(r, callback, true);       
    }   
}