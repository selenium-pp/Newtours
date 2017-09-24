package merc_objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercuryWelcome {
	
	WebDriver driver;
	public MercuryWelcome(WebDriver driver)	{
		this.driver = driver;
	}
	
	By username = By.name("userName");
	By password = By.name("password");
	By sign_in = By.name("login");
	
	public WebElement user_name()	{		return driver.findElement(username);	}
	public WebElement password()	{		return driver.findElement(password);	}
	public WebElement signin_btn()	{ 		return driver.findElement(sign_in);		}

}
