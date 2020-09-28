package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException

	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Mayur\\Selenium\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		System.out.println(browsername);

		if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Mayur\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else {
			System.setProperty("webdriver.gecko.driver", "C:\\Mayur\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public String getScreenShot(String testcasename, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testcasename + ".png";
		FileHandler.copy(source, new File(destinationFile));
		return destinationFile;

	}
}
