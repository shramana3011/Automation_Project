package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CheckBoxCommands 
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
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		System.out.println("Successfully opened the browser page");
	}
	
	public void checkBoxCommands()
	{
		// Any one syntax of below is correct
		
		//System.out.println(driver.findElement(By.cssSelector("input[value=\"option1\"]")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("label[for='bmw']")).isSelected());

		
		WebElement checkbox=driver.findElement(By.xpath("//input[@value='option1']"));
		

		boolean isDisplayed=checkbox.isDisplayed();
		if (isDisplayed==true)
		{
			boolean isSelected=checkbox.isSelected();
			System.out.println("The status of the checkbox selection is" + " " + isSelected);
			
			if(isSelected==false)
			{
				checkbox.click();
				System.out.println("Now the checkbox is selected");
			}
			
		// Counting the number of checkboxes in the page.
			
			System.out.println(driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());
		
			
		}
				
	}
	

			
	public static void main(String[] args) throws InterruptedException 
	{
		CheckBoxCommands obj=new CheckBoxCommands();
			obj.setUp();
			obj.openPage();
			obj.checkBoxCommands();
			
			


}

}
