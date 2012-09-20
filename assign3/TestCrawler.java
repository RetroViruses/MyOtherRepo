import java.util.Iterator;

//used to test code before GUI was finished
public class TestCrawler {

	public static void main(String[] args) {

		Page newPage = new Page("http://www.csd.uwo.ca/~jcamer7/CS1027/Asn3/asn3StartPage.html");
		CrawlResultList crl1 = new CrawlResultList();
		DepthCrawler searchy = new DepthCrawler("algorithms", crl1);
		try {
			searchy.search("http://www.csd.uwo.ca/~jcamer7/CS1027/Asn3/asn3StartPage.html");
		} catch (Exception e) {

		}
	}
}
