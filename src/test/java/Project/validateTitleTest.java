package Project;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobject.Landingpage;
import pageobject.LoginPage;
import resources.base;

public class validateTitleTest extends base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void initial() throws IOException
	
	{
		driver = initializeDriver();
		log.info("Driver Initialize");
		driver.get(prop.getProperty("url"));
		log.info("Site Reached");
	}
	
	

	@Test
	
	public void basetest() throws IOException
	{
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Landingpage lp =new Landingpage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Text is equals");
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	
	@AfterTest
	
	public void terdown()
	
	{
		driver.close();
	}
	
}
