
public class CrawlResult {
	//stores the page that is being crawled
	protected Page pageCrawled;
	//string that says if the crawl has failed
	protected String crawlFail;
	//if the keyword matches a word on the page, turns true
	protected boolean searchMatch = false;
	//stores the position of searching of the page
	protected int seqNum = 0;
	
	/**
	 * constructor when no error occurs
	 * @param crawledPage
	 * @param sequenceNum
	 * @param matchedSearch
	 */
	public CrawlResult(Page crawledPage, int sequenceNum, boolean matchedSearch){
		pageCrawled = crawledPage;
		seqNum=sequenceNum;
		searchMatch = matchedSearch;
	}
	
	/**
	 * constructor when an error occurs
	 * @param crawledPage
	 * @param sequenceNum
	 * @param errorMessage
	 */
	public CrawlResult(Page crawledPage, int sequenceNum, String errorMessage){
		pageCrawled = crawledPage;
		seqNum=sequenceNum;
		crawlFail=errorMessage;
	}
	
	/**
	 * returns the crawled page
	 * @return the crawled page
	 */
	public Page getPage(){
		return pageCrawled;
	}
	
	/**
	 * returns the stored error message
	 * @return
	 */
	public String getErrorMessage(){
		return crawlFail;
	}
	
	/**
	 * returns the sequence number
	 * @return
	 */
	public int getSequence(){
		return seqNum;
	}
	
	/**
	 * returns if the page matched the keyword
	 * @return
	 */
	public boolean isMatch(){
		return searchMatch;
	}
	
	/**
	 * returns true if the crawl was successful, false otherwise
	 * @return
	 */
	public boolean crawlSuccess(){
		if (crawlFail==null){
			return true;
		}
		else{
			return false;
		}
	}
}
