package merc_functionlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Generic_functions {

	
	public void SetUp() throws IOException{
		
	//Initializing the Properties object
		Properties projConfig = new Properties();
		FileInputStream fs_projConfig = new FileInputStream(System.getProperty("user.dir")+"\\src\\projectConfiguration.properties");
		projConfig.load(fs_projConfig);
		
	
	}

	protected WebDriver LaunchApplication(WebDriver driver, String strUrl) 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get(strUrl);
		return driver;
	}

	
	public void report_results(String report_msg){
		System.out.println(report_msg);
	}

}
