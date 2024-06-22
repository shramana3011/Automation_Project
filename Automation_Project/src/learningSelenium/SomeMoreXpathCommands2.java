
package learningSelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;


public class SomeMoreXpathCommands2
{
	//public WebDriver driver;
	
		private WebDriver driver;
		String baseUrl1="https://rahulshettyacademy.com/AutomationPractice/";
		
		
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
		public void findElementwithinSiblings()
		{
			//first try to traverse from parent to child just for practice purpose
////			
//			driver.findElement(By.xpath("//html/body/header/div[1]/button[2]")).click(); // absolute xpath with '//' starting from the topmost parent
////			driver.findElement(By.xpath("/html/body/header/div[1]/button[2]")).click(); // absolute xpath with '/' starting from the topmost parent
////		
//			driver.findElement(By.xpath("//header/div[1]/button[2]")).click(); // relative xpath with '//' starting from the most recent parent
//
//			System.out.println("Successfully clicked on 'Practice' button");
			
			// We will traverse from 'Practice' to 'Login'
			System.out.println(driver.findElement(By.xpath("//header/div[1]/button[1]/following-sibling::button[1]")).getText());
			System.out.println("Successfully clicked on 'Login' button");
		}

		public void findElementwithParent()
		{
			driver.findElement(By.xpath("//header/div/button[1]/parent::div"));
			System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[2]")).getText());
			System.out.println("The text message on the top is getting printed successfully in the console");
			
		}
			
			
	
		
		
		
		
		public static void main(String[] args) throws InterruptedException 
		{
			SomeMoreXpathCommands2 obj=new SomeMoreXpathCommands2();
				obj.setUp();
				obj.openPage();
				//obj.findElementwithinSiblings();
				obj.findElementwithParent();
			//	obj.closePage();


	}
	}
