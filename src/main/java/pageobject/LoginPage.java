package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	
	
	private By email=By.id("user_email");
	private By password=By.id("user_password");
	private By login = By.name("commit");

	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getUsername()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()

	{

	return driver.findElement(password);

	}
    
	public WebElement getLogin()

	{

	return driver.findElement(login);

	}

	
}

