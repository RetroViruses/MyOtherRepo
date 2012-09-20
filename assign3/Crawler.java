import java.util.ArrayList;

public abstract class Crawler {

	// List of links the crawler has already visited
	private ArrayList<String> linksVisited;
	//stores word to be searched
	private String searchThis;
	//the default maximum depth and maximum links/page
	private int maxDepth = 3;
	private int maxLinks = 3;
	//creates a crawlresultlist object to store pages
	private CrawlResultList crawlResL = new CrawlResultList();
	//stores the sequence number of a page
	private int seqNumLast = 0;
	//tells the program when to stop crawling
	protected boolean stopCrawl = false;
	//is true when the program is crawling
	protected boolean isCrawl = false;

	/**
	 * constructor used to stop unnecessary crashes
	 */
	public Crawler() {
		this.linksVisited = new ArrayList<String>();
		searchThis = "";
	}

	/**
	 * Constructor that initializes a new crawler.
	 * 
	 * @param keyword
	 *            The keyword for which the crawler will search
	 */
	public Crawler(String keyword, CrawlResultList crl) {
		crawlResL = crl;
		seqNumLast = 0;
		this.linksVisited = new ArrayList<String>();
		searchThis = keyword;
		stopCrawl = false;
		isCrawl = false;
	}

	/**
	 * Returns a Boolean value indicating if the crawler has visited the
	 * specified web site.
	 * 
	 * @param address
	 *            Address of the web site to test
	 * @return True, if the crawler has visited the site; false, otherwise
	 */
	public boolean hasVisitedLink(String address) {
		return this.linksVisited.contains(address);
	}

	/**
	 * Adds the specified address to the list of pages the crawler has already
	 * visited
	 * 
	 * @param address
	 *            Address of the page the crawler has visited
	 */
	public void addVisitedLink(String address) {
		this.linksVisited.add(address);
	}
	
	/**
	 * getter that returns maximum depth
	 * @return maximum depth of the page
	 */
	public int getMaxDepth() {
		return maxDepth;
	}

	/**
	 * getter that returns maximum links
	 * @return maximum links of the page
	 */
	public int getMaxLinks() {
		return maxLinks;
	}

	/**
	 * returns the keyword
	 * @return the current keyword
	 */
	public String getKeyword() {
		return searchThis;
	}

	/**
	 * setter that changes maximum depth
	 * @param newDepth new maximum depth of the page
	 */
	public void setMaxDepth(int newDepth) {
		maxDepth = newDepth;
	}

	/**
	 * changes the max number of links/page
	 * @param newNumLinks new max number of links from the page stored
	 */
	public void setMaxLinks(int newNumLinks) {
		maxLinks = newNumLinks;
	}

	/**
	 * changes the keyword
	 * 
	 * @param newKey
	 *            the new keyword
	 */
	public void setKeyword(String newKey) {
		searchThis = newKey;
	}

	/**
	 * an abstract of the search method used in Breadth and Depth crawler
	 * @param searchAddress the address to start searching from
	 */
	public abstract void search(String searchAddress);

	/**
	 * prints the page that the keyword was found on
	 * 
	 * @param thisPage
	 *            the page the keyword was found on
	 */
	protected void printMatch(Page thisPage) {
		System.out.println("Keyword " + searchThis + " was found on " + thisPage.getAddress());
	}

	/**
	 * prints a message indicating the next page the crawler will visit
	 * 
	 * @param nextPage
	 *            page about to be visited
	 */
	protected static void printVisiting(Page nextPage) {
		System.out.println("About to visit " + nextPage.getAddress());
	}
	/**
	 * adds a page to CrawlResultList when successfully downloaded
	 * @param newCrawled the page downloaded
	 * @param pageMatch whether the keyword is on that page
	 */
	protected void addCrawledPage(Page newCrawled, boolean pageMatch) {
		CrawlResult resultingCrawl = new CrawlResult(newCrawled, seqNumLast, pageMatch);
		crawlResL.add(resultingCrawl);
	}

	/**
	 * adds a page to CrawlResultList when incorrectly downloaded
	 * @param newCrawled the page downloaded
	 * @param failString string saying the download failed
	 */
	public void addFailedPage(Page newCrawled, String failString) {
		CrawlResult resFailCrawl = new CrawlResult(newCrawled, seqNumLast, failString);
		crawlResL.add(resFailCrawl);
	}

	/**
	 * says if it is crawling
	 * @return
	 */
	public boolean isCrawling() {
		return isCrawl;
	}

	/**
	 * sets the crawling value to true or false
	 * @param changeCrawl
	 */
	protected void setCrawling(boolean changeCrawl) {
		isCrawl = changeCrawl;
	}

	/**
	 * stops the crawling
	 */
	public void stop() {
		stopCrawl = true;
	}

	/**
	 * adds one to the sequence number
	 */
	protected void crawlingNextPage() {
		seqNumLast = seqNumLast + 1;
	}
}
