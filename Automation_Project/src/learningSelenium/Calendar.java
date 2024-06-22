package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Calendar 
{
	private WebDriver driver;
	String baseUrl1="https://rahulshettyacademy.com/AutomationPractice/";
	String baseUrl2="https://www.spicejet.com/";
	String baseUrl3="https://www.makemytrip.com/";
	
	
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public void openPage() throws InterruptedException
	{
		driver.get(baseUrl2);
		driver.manage().window().maximize();
		System.out.println("Successfully opened the browser page");
	}
	
	public void calendarOperations()
	{
		
			
		}
		
		
		
		


		

			
	public static void main(String[] args) throws InterruptedException 
	{
		CheckBoxCommands obj=new CheckBoxCommands();
			obj.setUp();
			obj.openPage();
			obj.checkBoxCommands();
			
			


}

}
