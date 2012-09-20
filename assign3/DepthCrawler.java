import java.util.ArrayList;
import java.util.Iterator;

public class DepthCrawler extends Crawler {

	/**
	 * constructor
	 * @param key keyword to search for
	 * @param crl2 crawl result list to save to
	 */
	public DepthCrawler(String key, CrawlResultList crl2) {
		super(key, crl2);
	}

	public void search(String startAddress) {
		//creates the stack to store the info to
		LinkedStack<Page> stack = new LinkedStack<Page>();
		//creates the page to start searching from
		Page startPage = new Page(startAddress);
		//shows number of links searched since the page was downloaded
		int linkedPageCount = 0;
		
		//enqueues the page, creates a new temporary page
		stack.push(startPage);
		Page linkedPage;
		
		//starts crawling
		super.setCrawling(true);
		
		//as long as there are things in the stack, continue crawling
		while (!stack.isEmpty() && super.isCrawl) {

			//remove a page from the stack, says it is visiting that page
			Page tempPage = (Page) stack.pop();
			super.crawlingNextPage();
			super.printVisiting(tempPage);
			
			//downloads the page
			try {
				WebHelper.downloadPage(tempPage);
			} catch (Exception e) {
				super.addFailedPage(tempPage, "Searching this page has failed");
			}

			//iterator created, adds link to visited, resets link counter
			Iterator<Page> it = tempPage.linkedPageIterator();
			super.addVisitedLink(tempPage.getAddress());
			linkedPageCount = 0;
			
			//if the keyword is in the page, say as such
			if (tempPage.containsText(super.getKeyword())) {
				super.printMatch(tempPage);
				super.addCrawledPage(tempPage, true);
			} else {
				super.addCrawledPage(tempPage, false);
			}
			
			//if the depth is not to deep, there are not to many links, and the iterator is not done
			if (tempPage.getDepth() < super.getMaxDepth()) {
				while (linkedPageCount < super.getMaxLinks() && it.hasNext()) {
					// Get the next Page object from the iterator and store it
					// in linkedPage
					linkedPage = it.next();
					if (!super.hasVisitedLink(linkedPage.getAddress())) {
						stack.push(linkedPage);
						linkedPageCount = linkedPageCount + 1;
					}
				}
			}
		}
		//stops crawling
		super.setCrawling(false);
	}
}
