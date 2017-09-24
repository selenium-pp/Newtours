package merc_objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercPurchase {
	
	WebDriver driver;
	public MercPurchase(WebDriver driver){
		this.driver = driver;
	}
	
	By f_nme 		= By.name("passFirst0");
	By l_nme 		= By.name("passLast0");
	By crd_num 		= By.name("creditnumber");
	By tt 			= By.name("ticketLess");
	By sec_p		= By.name("buyFlights");
	By f_book		= By.xpath("//img[@src='/images/masts/mast_book.gif']");
	By conf			= By.xpath("//img[@src='/images/masts/mast_confirmation.gif']");
	By signout		= By.xpath("//img[@src='/images/forms/Logout.gif']");

	public WebElement first_name(){
		return driver.findElement(f_nme);
	}
	public WebElement last_name(){
		return driver.findElement(l_nme);
	}
	public WebElement creditcard_no(){
		return driver.findElement(crd_num);
	}
	public WebElement ticketless(){
		return driver.findElement(tt);
	}
	public WebElement secure_purchase(){
		return driver.findElement(sec_p);
	}
	public WebElement bookflight_image(){
		return driver.findElement(f_book);
	}
	public WebElement confirmation(){
		return driver.findElement(conf);
	}
	public WebElement logout(){
		return driver.findElement(signout);
	}


}
