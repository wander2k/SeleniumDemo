
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class EClockingIn {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		// String Firefoxdriverpath = "./exe/geckodriver.exe";
		// System.setProperty("webdriver.gecko.driver", Firefoxdriverpath);
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "./exe/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		baseUrl = "https://www.google.co.jp/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testEClockingIn() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys("サッカー");
	    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath("//a[contains(text(),'ニュース')]")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'ニュース')]")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
