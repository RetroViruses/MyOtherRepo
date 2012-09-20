import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a parsed HTML page, containing a list of all links contained on
 * the page, along with the non-HTML text of the page.
 * @author Jeff Shantz <x@y> where x = jshantz4, y = csd.uwo.ca
 */
public class Page {

    /***************************************************************************
     * CONSTANT DECLARATIONS
     **************************************************************************/

    // The initial depth of a page
    private final int INITIAL_DEPTH = 0;

    // The amount by which we increase depth on each linked page
    private final int DEPTH_INCREMENT = 1;

    /***************************************************************************
     * INSTANCE VARIABLES
     **************************************************************************/

    // The address of the page
    private String pageAddress;

    // A list of all links contained on the page
    protected ArrayList<Page> linkedPages;

    // Non-HTML page text
    private String text;

    // The search depth of the page
    protected int depth;

    /***************************************************************************
     * CONSTRUCTORS
     **************************************************************************/

    /**
     * Initializes a new Page with the specified address
     * @param address The page address
     */
    public Page(String address) {

        this.linkedPages = new ArrayList<Page>();
        this.pageAddress = address;
        this.text = "";
        this.depth = INITIAL_DEPTH;
    }

    /***************************************************************************
     * PUBLIC METHODS
     **************************************************************************/

    /**
     * Clears the text and links stored in the Page.
     */
    public void clear() {
        this.linkedPages.clear();
        this.text = "";
    }

    /**
     * Used during page parsing to add a new link to the Page.   Only fully-
     * qualified links (those beginning with http://) will be processed.
     * @param address The address of the linked page
     */
    public void addLink(String address) throws Exception {

        // We will handle only fully-qualified links
        if (!address.toLowerCase().startsWith("http://")) {
            return;
        }

        // Create a URL and page from the address, and set its depth
        URL url = new URL(address);
        Page linkedPage = new Page(url.toExternalForm());
        linkedPage.setDepth(this.depth + DEPTH_INCREMENT);

        // Add the page to the list of linked pages
        this.linkedPages.add(linkedPage);
    }

    /**
     * Returns an iterator over the links in the page
     * @return An iterator over the links in the page
     */
    public Iterator<Page> linkedPageIterator() {
        return this.linkedPages.iterator();
    }

    /**
     * Returns the address of the page represented by the Page object
     * @return The page address
     */
    public String getAddress() {
        return this.pageAddress;
    }

    /**
     * Returns the text of the page
     * @return The page text
     */
    public String getText() {
        return this.text;
    }

    /**
     * Returns a Boolean value indicating whether or not the page text contains
     * the specified search string
     * @param text The text for which to search
     * @return True, if the page contains the specified text; false, otherwise
     */
    public boolean containsText(String text) {
        return this.text.contains(text.toLowerCase());
    }

    /**
     * Returns the search depth of the page
     * @return The search depth of the page
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     * Sets the search depth of the page
     * @param depth The search depth of the page
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Appends a line to the page text
     * @param text A line of text to append to the page text
     */
    public void appendText(String text) {
        this.text += text.toLowerCase();
    }

    /**
     * Returns a boolean value indicating if two Pages are equal.  For our
     * purposes, two Pages are considered equal if their addresses match.
     * @param other The object to compare for equality
     * @return True, if the objects are equal; false, otherwise
     */
    @Override
    public boolean equals(Object other) {

        // If the other object is a Page
        if (other instanceof Page) {
            // And its address is equal, then the Pages are equal
            Page p = (Page) other;
            return this.getAddress().equals(p.getAddress());
        } else {
            return false;
        }

    }
}