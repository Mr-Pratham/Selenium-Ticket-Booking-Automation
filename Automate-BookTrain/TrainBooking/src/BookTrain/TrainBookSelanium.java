package BookTrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TrainBookSelanium {
	WebDriver driver;

	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\KIIT\\Desktop\\Automate-BookTrain\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/railways/");

		// Print the URL and Title of the Page
		String title = driver.getTitle();
		System.out.println("Title of the web-page: " + title);
		String url = driver.getCurrentUrl();
		System.out.println("URL of the web-page : " + url);

		// click on element using xpath
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
		// click on element using id

		Thread.sleep(1000);
		// Enter Delhi in the To box
		driver.findElement(
				By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"))
				.sendKeys("Delhi");
		// delay
		Thread.sleep(2000);

		// find the length of all the elements find using selector in the DROP DOWN
		int length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
		// System.out.println("Length of the list is: " + length);

		// define a loop to iterate through the list
		for (int i = 0; i < length; i++) {
			// find the element using index
			String element = driver.findElements(By.cssSelector(
					"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
					.get(i).getText();
			System.out.println("From : " + element);
			// check if the element is equal to the search term
			if (element.equals("Delhi")) {
				// click on the element "DELHI"
				driver.findElements(By.cssSelector(
						"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
						.get(i).click();
				break;
			}
		}

		// Selecting Destination
		// click on typing box using xpath
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/label/span")).click();
		// click on element using id

		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"))
				.sendKeys("Lucknow");
		// wait until element is not visible
		Thread.sleep(2000);

		// find the length of all the elements find using selector in the DROP DOWN
		length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
		// System.out.println("Length of the list is: " + length);

		// define a loop to iterate through the DROP DOWN LIST
		for (int i = 0; i < length; i++) {
			// find the element using index
			String element = driver.findElements(By.cssSelector(
					"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
					.get(i).getText();
			System.out.println("To : " + element);
			// check if the element is equal to the search term
			if (element.equals("Lucknow")) {
				// click on the element "LUCKNOW"
				driver.findElements(By.cssSelector(
						"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
						.get(i).click();
				break;
			}
		}

		// Selecting Date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[2]"))
				.click();

		// Selecting Class
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]")).click();
		length = driver.findElements(By.cssSelector("ul.travelForPopup > li")).size();
		// System.out.println("Length of the list is: " + length);

		// LOOP through the drop down list to find the required element
		for (int i = 0; i < length; i++) {
			String element = driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).getText();
			// System.out.println("Class is: " + element);
			if (element.equals("Third AC")) {
				driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).click();
				System.out.println("Class selected: " + element);
				break;
			}
		}

		// Clicking Search button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/p/a")).click();
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TrainBookSelanium obj = new TrainBookSelanium();
		obj.launchBrowser();
	}
}