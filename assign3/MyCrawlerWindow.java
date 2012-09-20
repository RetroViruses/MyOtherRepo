import javax.swing.UIManager;

public class MyCrawlerWindow extends CrawlerWindow {

	/**
	 * constructor
	 */
	public MyCrawlerWindow() {
		this.initComponents();
	}

	/**
	 * if the search button is clicked, and is crawling, stops
	 * if clicked when not crawling, starts crawling
	 * @param evt
	 */
	private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (searchTermField.getText() == null || seedURLField.getText() == null) {
			System.out.println("Information not entered, please try again");
		} 
		else {
			if (super.isCrawling() == true) {
				this.stopCrawler();
			} 
			else if (super.isCrawling() == false) {
				this.startCrawler();
			}
		}
	}

	/**
	 * resets all variables
	 * @param evt
	 */
	private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
		searchTermField.setText(null);
		seedURLField.setText(null);
		crawlTypeBFSOption.setSelected(true);
		maxDepthSpinner.setValue((Integer) crawler.getMaxDepth());
		maxLinksPerPageSpinner.setValue((Integer) crawler.getMaxLinks());
	}

	/**
	 * starts crawling
	 */
	private void startCrawler() {

		//clears the results, changes search button to stop, disables all other features
		super.clearResults();
		super.searchButton.setText("Stop");
		setComponentsEnabled(false);
		//attempts the code, if fails, aborts the code
		try {
			//creates a crawler of selected type
			if (crawlTypeBFSOption.isSelected()) {
				super.crawler = new BreadthCrawler(searchTermField.getText(), super.getResultList());
			}
			else {
				super.crawler = new DepthCrawler(searchTermField.getText(), super.getResultList());
			}
			//sets max depth and links, starts crawling
			super.crawler.setMaxDepth((Integer) maxDepthSpinner.getValue());
			super.crawler.setMaxLinks((Integer) maxLinksPerPageSpinner.getValue());
			super.startCrawlerThread(seedURLField.getText());

		} catch (Exception e) {
			super.stopCrawlerThread();
		}
	}

	/**
	 * stops the crawler, enables all changeable functions
	 */
	public void stopCrawler() {
		super.searchButton.setText("Search");
		setComponentsEnabled(true);
		crawler.setCrawling(false);
	}

	/**
	 * disables/enables (based on enabled's value) the GUI
	 * @param enabled
	 */
	public void setComponentsEnabled(boolean enabled) {
		super.searchTermLabel.setEnabled(enabled);
		super.maxDepthLabel.setEnabled(enabled);
		super.maxLinksPerPageLabel.setEnabled(enabled);
		super.seedURLField.setEnabled(enabled);
		super.crawlTypeBFSOption.setEnabled(enabled);
		super.crawlTypeDFSOption.setEnabled(enabled);
		super.maxLinksPerPageSpinner.setEnabled(enabled);
		super.maxDepthSpinner.setEnabled(enabled);
		super.resetButton.setEnabled(enabled);
		super.searchTermField.setEnabled(enabled);
		super.seedURLField.setEnabled(enabled);

	}

	/**
	 * initializes the components
	 */
	private void initComponents() {

		searchTermField.setText(null);
		seedURLField.setText(null);
		crawlTypeBFSOption.setSelected(true);
		maxDepthSpinner.setValue((Integer) 3);
		maxLinksPerPageSpinner.setValue((Integer) 3);

		searchButton.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchButtonActionPerformed(evt);
			}
		});

		resetButton.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetButtonActionPerformed(evt);
			}
		});

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			// Ignore the exception -- not fatal
		}
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MyCrawlerWindow().setVisible(true);
			}
		});

	}
}
