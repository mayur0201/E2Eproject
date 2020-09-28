package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By login=By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a");
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
    private By title = By.xpath("//div/h2[text()='Featured Courses']");
	private By popup=By.xpath("//button[text()='NO THANKS']");
	
	
	
	public LoginPage getlogin()
	{
		driver.findElement(login).click();
		 LoginPage lp=new LoginPage(driver);
		 return lp;
	}
	public WebElement getNavigationBar()

	{

	return driver.findElement(NavBar);

	}

	public int getPopUpSize()

	{

	return driver.findElements(popup).size();

	}

	public WebElement getPopUp()

	{

	return driver.findElement(popup);

	}
	public WebElement getTitle() {
		// TODO Auto-generated method stub
		return driver.findElement(title);
	}
	
}

