package learningSelenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserNavigationCommands 
{
	private WebDriver driver;
	
	String baseUrl1="https://rahulshettyacademy.com/AutomationPractice/";
	String baseUrl2="https://www.google.com";
	
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public void openPage()
	{
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		System.out.println("Successfully opened the browser page");

	}
	public void timeOut()
	{
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.SECONDS) ;
	}
	public void pageOperation()
	{
		driver.get(baseUrl1);
		driver.navigate().to(baseUrl2);
		
		driver.navigate().back();
		timeOut();
		
		driver.navigate().forward();
		timeOut();
		
		driver.navigate().refresh();
		timeOut();

	}
	
	public void closePage()
	{
		timeOut();
		driver.close();//	
		//driver.quit();
		System.out.println("Successfully closed the webpage");
		}

	public static void main(String[] args) 
	{
			BrowserNavigationCommands obj=new BrowserNavigationCommands();
			obj.setUp();
			obj.openPage();
			obj.pageOperation();
			obj.closePage();
	}

}
