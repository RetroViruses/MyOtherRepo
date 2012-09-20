import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import java.util.Iterator;
/**
 * Parses out the text and links of a downloaded web page.
 * @author Jeff Shantz <x@y> where x = jshantz4, y = csd.uwo.ca
 */
public class PageParser extends HTMLEditorKit.ParserCallback {

    /***************************************************************************
     * INSTANCE VARIABLES
     **************************************************************************/

    // The Page being parsed
    protected Page page;

    /***************************************************************************
     * CONSTRUCTORS
     **************************************************************************/

    /**
     * Initializes a new PageParser with a given Page
     * @param page The Page to parse
     */
    public PageParser(Page page) {
        this.page = page;
    }

    /***************************************************************************
     * PUBLIC METHODS
     **************************************************************************/

    /**
     * Callback method that is invoked when text is found in a page.  Adds the
     * text to the Page object.
     * @param data The text found in the page
     * @param pos The position at which the text was found
     */
    @Override
    public void handleText(char[] data, int pos) {

        page.appendText(String.valueOf(data));
    }

    /**
     * Callback method that is invoked when a starting HTML tag is encountered.
     * This method considers only opening <a> tags and adds the links they
     * contain to the list of links in the Page object.
     * @param tag The opening tag found
     * @param attributes A set of attributes found in the tag
     * @param position The position at which the start tag was found
     */
    @Override
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {

        // If the tag is an anchor
        if (tag == HTML.Tag.A) {

            // Get its href value (the address)
            HTML.Attribute href = HTML.getAttributeKey("href");
            Object link = attributes.getAttribute(href);

            // If it has an href value
            if (link != null) {
                
                // Add the link to the Page object
                try {
                    page.addLink(link.toString());
                }
                catch (Exception ex) {
                    // If parsing fails, ignore the link
                }
            }
        }
    }
}

/**
 * Provides a convenient way of creating an HTML parser.
 * @author Jeff Shantz <x@y> where x = jshantz4, y = csd.uwo.ca
 */
class ParserGetter extends HTMLEditorKit {

    /**
     * Returns an HTML parser.
     * @return A parser suitable for parsing an HTML page
     */
    @Override
    public HTMLEditorKit.Parser getParser() {
        return super.getParser();
    }
}