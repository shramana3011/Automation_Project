package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathCommands
{
	//public WebDriver driver;
	
	private WebDriver driver;
	String baseUrl1="https://rahulshettyacademy.com/locatorspractice/";
	String baseUrl2="https://demo.guru99.com/test/selenium-xpath.html";
	
	WebElement username;
	//WebElement forgotPassword;

	
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
		
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement forgotPassword= driver.findElement(By.linkText("Forgot your password?"));
//		forgotPassword.click();
//		System.out.println("Successfully clicked on forgot password link");
//		
//		Thread.sleep(1500);
		
	}
	public void findElementByBasicXPath()
	{
		username=driver.findElement(By.xpath("//input[@id='inputUsername']"));
		username.sendKeys("Shramana Roy");
		System.out.println("Basic Relative xPath Test Passed");

	}
	
	public void findElementByContainsXPath()
	{
		username=driver.findElement(By.xpath("//input[contains(@placeholder,'User')]"));
		username.sendKeys("Shramana Roy");
		System.out.println("Contains Test Passed");
		

	}
	
	public void findElementByORAND()
	{
		//if one condition passed, it will work
		
//		username=driver.findElement(By.xpath("//input[contains(@placeholder,'User') or @id='inputUse']"));
//		username.sendKeys("Shramana Roy");
//		System.out.println("OR Test Passed"); 
		
		//if both the conditions passed, then only it will work
		
		username=driver.findElement(By.xpath("//input[contains(@placeholder,'User') and @id='inputUse']"));
		username.sendKeys("Shramana Roy");
		System.out.println("AND Test Passed"); 
		
	

	}
	public void findElementByStartswith()
	{
		
		username=driver.findElement(By.xpath("//label[starts-with(@id,'message')]"));
		username.sendKeys("Shramana Roy");
		System.out.println("Starts-With Test Passed"); 
	
	}
	
	public void findElementByText()
	{
		
		username=driver.findElement(By.xpath("//td[text()='UserID']"));
		username.sendKeys("Shramana Roy");
		System.out.println("Starts-With Test Passed"); 
	
	}
	public void findElementByParenttoChild()
	{
		
		//username=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/form/input[1]"));
		
		username=driver.findElement(By.xpath("//form/input[3]")); // Using only tag name
		
		// In forgot password screen can navigate to "Go To Login" button like this
		
		//div[@class="forgot-pwd-btn-conainer"]/button[1] // Using both tag name and parent to child traverse
		
		username.sendKeys("7582485695");
		System.out.println("ParenttoChild Test Passed");
		
		WebElement reset=driver.findElement(By.cssSelector(".reset-pwd-btn"));
		reset.click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
	}
		
	public void successfulLoginwithRegEx()
	{
		username=driver.findElement(By.cssSelector("#inputUsername"));
		username.sendKeys("rahul");
		WebElement password= driver.findElement(By.cssSelector("input[type*=\"pass\"]"));
		password.sendKeys("rahulshettyacademy");
		WebElement checkbox1=driver.findElement(By.id("chkboxOne"));
		checkbox1.click();
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
				
	}
	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		XpathCommands obj=new XpathCommands();
			obj.setUp();
			obj.openPage();
			//obj.findElementByBasicXPath();
			//obj.findElementByContainsXPath();
			//obj.findElementByORAND();
			//obj.findElementByStartswith();
		//	obj.findElementByText();
		//	obj.findElementByParenttoChild();
			obj.successfulLoginwithRegEx();
		//	obj.closePage();


}
}



