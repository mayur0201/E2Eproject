package Project;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobject.Landingpage;
import pageobject.LoginPage;
import resources.base;

public class HomePageTest extends base {
    
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName()); 
	
	
@BeforeTest
	
	public void initial() throws IOException
	
	{
		driver = initializeDriver();
		
		
	}
	
	
	


	@Test(dataProvider = "getdata")
	
	public void basetest(String username , String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Landingpage lp =new Landingpage(driver);
		//lp.getPopUp().click();
		LoginPage lg=lp.getlogin();
		
		//LoginPage lg =new LoginPage(driver);
		lg.getUsername().sendKeys(username);
		log.info(username);
		lg.getPassword().sendKeys(password);
		log.info(password);
		lg.getLogin().click();
		
		
		
	}
	
@AfterTest
	
	public void terdown()
	
	{
		driver.close();
	}
	
@DataProvider
    
    public Object[][] getdata()
    {
    	Object[][] data = new Object[2][2];
    	
    	data[0][0]= "Firstuser@abc.com";
    	data[0][1]="First pswd";
    	
    	data[1][0]="Seconduser@abc.com";
    	data[1][1]="Second Pswd";
    	
    	
    	
    	return data;
    }
    

	
}
