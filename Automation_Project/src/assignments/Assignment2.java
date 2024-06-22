package assignments;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Assignment2 
{
	public WebDriver driver;
	String baseUrl="https://rahulshettyacademy.com/angularpractice/";
	
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	
	public void openPage()
	{
		driver.get(baseUrl);
		driver.manage().window().maximize();
		System.out.println("Successfully opened the google page");
	}
	
	public void practiceCode()
	{
		//Entering name
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Shramana Roy");
		
		//Entering email
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("shramanaroy7@gmail.com");
		
		//Entering password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password@123");
		
		System.out.println("All the input fields are filled");
		
		
		//Checking the checkbox
		
		WebElement checkbox=driver.findElement(By.xpath("//label[@for=\"exampleCheck1\"]"));
		boolean isChecked=checkbox.isSelected();
		
		if(isChecked == false)
		{
			checkbox.click();
			System.out.println("Checkbox is checked successfully");
		}
		
		//Selecting value from dropdown
		Select dropdown=new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropdown.selectByIndex(1);
		System.out.println("Selected option from the dropdown which is:"+ dropdown.getFirstSelectedOption().getText());
	
		
		//Checking the radiobutton
		
		WebElement radiobutton=driver.findElement(By.id("inlineRadio1"));
		boolean isSelected=checkbox.isSelected();
		
		if(isSelected == false)
		{
			radiobutton.click();
			System.out.println("Radio button is clicked successfully");
		}
		
		//Selecting date
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("15-06-2024");
		System.out.println("Date is entered successfully");
		
		//Clicking on 'Submit'button
		driver.findElement(By.className("btn-success")).click();
		
		//Printing the success message in console
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		
		}
		
		
		
		


		

			
	public static void main(String[] args) throws InterruptedException 
	{
		Assignment2 obj=new Assignment2();
		obj.setup();
		obj.openPage();
		obj.practiceCode();

			
			


}

}
