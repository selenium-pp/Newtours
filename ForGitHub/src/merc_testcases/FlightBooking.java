package merc_testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import merc_objectrepository.MercPurchase;
import merc_objectrepository.MercuryReservation;
import merc_objectrepository.MercuryWelcome;

import merc_functionlib.*;

public class FlightBooking extends Generic_functions{

	@Test
	public void userlogin() throws InterruptedException, IOException{
		String strStatus = "Pass";// Initialize a status variable to control the flow of script
		
		WebDriver driver = null;
		
		//SetUp();
		Properties projConfig = new Properties();
		FileInputStream fs_projConfig = new FileInputStream(System.getProperty("user.dir")+"\\src\\projectConfiguration.properties");
		projConfig.load(fs_projConfig);

		//Launch Browser and open the ticket booking application
		driver = LaunchApplication(driver, projConfig.getProperty("strUrl"));

		MercuryWelcome WelcomePage = new MercuryWelcome(driver);
		WelcomePage.user_name().sendKeys(projConfig.getProperty("username"));
		WelcomePage.password().sendKeys(projConfig.getProperty("password"));
		WelcomePage.signin_btn().click();
		
		//If login successful, select the flights
		MercuryReservation ReservationPage = new MercuryReservation(driver);
		if (ReservationPage.Flight_finder().isDisplayed() && strStatus.equals("Pass"))
		{
			report_results("Pass :: Login Successful");

			ReservationPage.one_way().click();
			//mr.passenger_count().selectByValue("1");
			
			ReservationPage.departing_from().selectByValue(projConfig.getProperty("source"));
			ReservationPage.departing_on_month().selectByVisibleText(projConfig.getProperty("depart_month"));
			ReservationPage.departing_on_day().selectByValue(projConfig.getProperty("depart_day"));
			
			ReservationPage.arriving_in().selectByValue(projConfig.getProperty("destination"));
			
			ReservationPage.first_class().click();
			
			ReservationPage.Find_Flights().click();
			
			if (ReservationPage.selectflight_image().isDisplayed() && strStatus.equals("Pass"))
			{
				report_results("Pass :: Entered details correct. Please select the flight");
				ReservationPage.Reserve_Flights().click();
			}
			else
				{
				report_results("Fail :: Please verify your details ");			
				}

		}
		else
		{
			strStatus = "Fail";
			report_results("Fail :: User is not able to Login. Incorrect credentials"); 
		}

		
		//Enter User Details and Make Payment
		MercPurchase PurchasePage = new MercPurchase(driver);
		if (PurchasePage.bookflight_image().isDisplayed() && strStatus.equals("Pass"))
			{
			report_results("Pass :: Entered details correct. Please select the flight");
			
			PurchasePage.first_name().sendKeys(projConfig.getProperty("first_name"));
			PurchasePage.last_name().sendKeys(projConfig.getProperty("last_name"));
			PurchasePage.creditcard_no().sendKeys(projConfig.getProperty("Creditcard_no"));
			PurchasePage.ticketless().click();
			PurchasePage.secure_purchase().click();
			
			if (PurchasePage.confirmation().isDisplayed())
				{
					report_results("Pass :: Flights booking succesful");
					Thread.sleep(5000);
					PurchasePage.logout().click();
				}
			else
				{
					report_results("Fail :: Flights booking failed. Please check the script for more details"); 
				}
			
			}
		else
			{
			report_results("Fail :: Please verify your details ");			
			}
				
		driver.close();// Close the Browser
		
	}


}
