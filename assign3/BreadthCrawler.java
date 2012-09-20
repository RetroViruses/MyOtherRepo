import java.util.ArrayList;
import java.util.Iterator;

public class BreadthCrawler extends Crawler {

	/**
	 * constructor
	 * @param key keyword to search for
	 * @param crl2 crawl result list to save to
	 */
	public BreadthCrawler(String key, CrawlResultList crl2) {
		super(key, crl2);
	}

	public void search(String startAddress) {
		//creates the queue to store infomation to
		CircularArrayQueue<Page> queue = new CircularArrayQueue();
		//creates the page to start searching from
		Page startPage = new Page(startAddress);
		//shows number of links searched since the page was downloaded
		int linkedPageCount = 0;
		
		//enqueues the page, creates a new temporary page
		queue.enqueue(startPage);
		Page linkedPage;
		//starts crawling
		super.setCrawling(true);
		
		//as long as there are things in the queue, and it is still crawling
		while (!queue.isEmpty() && super.isCrawl) {
			
			//dequeues a page to visit, states as such
			Page tempPage = (Page) queue.dequeue();
			super.crawlingNextPage();
			super.printVisiting(tempPage);
			//attempts to search a page
			try {
				WebHelper.downloadPage(tempPage);
			} catch (Exception e) {
				super.addFailedPage(tempPage, "Searching this page has failed");
			}
			
			//creates an iterator, records that it visited the downloaded page, resets the page counter
			Iterator<Page> it = tempPage.linkedPageIterator();
			super.addVisitedLink(tempPage.getAddress());
			linkedPageCount = 0;
			
			//if the page has the keyword, states as such, otherwise, just records the page
			if (tempPage.containsText(super.getKeyword())) {
				super.printMatch(tempPage);
				super.addCrawledPage(tempPage, true);
			} else {
				super.addCrawledPage(tempPage, false);
			}
			
			//if the page is not too deep from original page, and the number of links on the page
			//is not too high, and the iterator has more links, continue
			if (tempPage.getDepth() < super.getMaxDepth()) {
				while (linkedPageCount < super.getMaxLinks() && it.hasNext()) {
					// Get the next Page object from the iterator and store it
					// in linkedPage
					linkedPage = it.next();
					linkedPageCount = linkedPageCount + 1;
					if (!super.hasVisitedLink(linkedPage.getAddress())) {
						queue.enqueue(linkedPage);
					}
				}
			}
		}
		//stops the crawling
		super.setCrawling(false);
	}
}
