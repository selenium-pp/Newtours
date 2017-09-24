package merc_objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MercuryReservation {

	WebDriver driver;
	public MercuryReservation(WebDriver driver){
		this.driver = driver;
	}
	
	By ff 			= By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
	By o_way 		= By.xpath("//*[@value='oneway']");
	By psngr 		= By.name("passCount");
	By frm 	 		= By.name("fromPort");
	By st_mnth 		= By.name("fromMonth");
	By st_day 		= By.name("fromDay");
	By to_prt		= By.name("toPort");
	By ft_class		= By.xpath("//*[@value='First']");
	By flt_fnd		= By.name("findFlights");
	By flt_rsv		= By.name("reserveFlights");
	By f_select		= By.xpath("//img[@src='/images/masts/mast_selectflight.gif']");


	// Radio Button Objects
	public WebElement one_way(){
		return driver.findElement(o_way);
	}
	public WebElement first_class(){
		return driver.findElement(ft_class);
	}

	//WebButton objects
	public WebElement Find_Flights(){
		return driver.findElement(flt_fnd);
	}	
	public WebElement Reserve_Flights(){
		return driver.findElement(flt_rsv);
	}	
	public WebElement Flight_finder(){
		return driver.findElement(ff);
	}	
	public WebElement selectflight_image(){
		return driver.findElement(f_select);
	}
	
	
	// Select dropdown Objects
	public Select passenger_count(){
		Select s1 = new Select(driver.findElement(psngr));
		return s1;
	}
	public Select departing_from(){
		Select s2 = new Select(driver.findElement(frm));
		return s2;
	}
	public Select departing_on_month(){
		Select s3 = new Select(driver.findElement(st_mnth));
		return s3;
	}
	public Select departing_on_day(){
		Select s4 = new Select(driver.findElement(st_day));
		return s4;
	}
	public Select arriving_in(){
		Select s5 = new Select(driver.findElement(to_prt));
		return s5;
	}

}
