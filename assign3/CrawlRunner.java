public class CrawlRunner implements Runnable {

    private CrawlerWindow window;
    private Crawler crawler;
    private String startURL;

    /**
     * constructs the crawlrunner
     * @param window
     * @param crawler
     * @param startURL
     */
    public CrawlRunner(CrawlerWindow window, Crawler crawler, String startURL) {
        this.window = window;
        this.crawler = crawler;
        this.startURL = startURL;
    }

    /**
     * runs the search
     */
    public void run() {
        crawler.search(this.startURL);
        window.stopCrawler();
    }


}
