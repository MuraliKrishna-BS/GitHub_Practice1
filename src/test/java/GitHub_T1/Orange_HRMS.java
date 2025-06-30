package GitHub_T1;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 class PropertiesSetyp{
	
	 public ChromeDriver Driver;
	 public Properties p ;
		
		@BeforeClass
		public void PSetup()  throws IOException {
			
		 	ChromeOptions op = new ChromeOptions();
			op.addArguments("--Start-Maximized");
			op.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			 Driver=new ChromeDriver(op);
			Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			FileReader f= new FileReader(".\\src\\test\\java\\GitHub1\\Config.properties");
			 p = new Properties();
			p.load(f);
		}
	 
	
}
public class Orange_HRMS extends PropertiesSetyp {
	
	
	@Test (priority = 1)
	public void LunchURL() throws IOException {
		
		String URL = p.getProperty("url");
		Driver.get(URL);
		
	}
	
	@Test(dependsOnMethods ="LunchURL", priority = 2)
	public void Login() {
		
		String Username = p.getProperty("username");
		String Password = p.getProperty("password");
		
		Driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys(Username);;
		Driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(Password);
		Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	}

}
