
package learningSelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SomeMoreXpathCommands
{
	//public WebDriver driver;
	
		private WebDriver driver;
		String baseUrl1="https://rahulshettyacademy.com/locatorspractice/";
		String baseUrl2="https://demo.guru99.com/test/selenium-xpath.html";
		
		WebElement username;
		String name="rahul";
		
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
			
			
		}
		public void successfulLoginwithRegEx() throws InterruptedException
		{
			username=driver.findElement(By.cssSelector("#inputUsername"));
			username.sendKeys(name);
			WebElement password= driver.findElement(By.cssSelector("input[type*=\"pass\"]"));
			password.sendKeys("rahulshettyacademy");
//			WebElement checkbox1=driver.findElement(By.id("chkboxOne"));
//			checkbox1.click();
			driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
			
			Thread.sleep(5000);
			
			System.out.println(driver.findElement(By.tagName("p")).getText());
			Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
			System.out.println("Login Test is passed");
			
			//Validating the greeting message
			System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello "+name+",");
			System.out.println("Validation Test is passed");
		}
		public void successfulLogout()
		{
			driver.findElement(By.xpath("//*[text()='Log Out']")).click();
			System.out.println("Logout Test is passed");
		}
		
//Parsing the string with Java methods to get the password dynamically from the page//		
		
		public void getPassword() throws InterruptedException
		{
			 driver.findElement(By.linkText("Forgot your password?")).click();
			 Thread.sleep(5000);
			 driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
			
			 String passwordtext= driver.findElement(By.cssSelector("p.infoMsg")).getText();
			
			//Please use temporary password 'rahulshettyacademy' to Login.
			
			String[] passwordArray1=passwordtext.split("'");
			
			//0th Index of passwordArray1-Please use temporary password
			//1st Index of passwordArray1-'rahulshettyacademy' to Login
			
//			//Way 1//
//			String[] passwordArray2=passwordArray1[1].split("'");
//			
//			//0th Index of passwordArray2 -rahulshettyacademy
//			//1st Index of passwordArray2- to Login
//			
//			String password=passwordArray2[0];
//			
			//Way 2//
			String password=passwordArray1[1].split("'") [0];
			System.out.println("Extracted password is" +" " +password);
		
			
			
			
			
			
		}
		
		
		
		public static void main(String[] args) throws InterruptedException 
		{
			SomeMoreXpathCommands obj=new SomeMoreXpathCommands();
				obj.setUp();
				obj.openPage();
				//obj.successfulLoginwithRegEx();
				//obj.successfulLogout();
				obj.getPassword();
			//	obj.closePage();


	}
	}
