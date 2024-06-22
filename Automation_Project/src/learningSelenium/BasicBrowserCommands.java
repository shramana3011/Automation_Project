package learningSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicBrowserCommands 
{
	private WebDriver driver;
	String baseUrl="https://www.google.co.in/";
	
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	
	public void openPage()
	{
		//driver.get(baseUrl);
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		System.out.println("Successfully opened the google chrome browser");

	}
	public void getPageDetails()
	{
		
		//String title=driver.getTitle();
		System.out.println("The title of the driver is :" + driver.getTitle());
		System.out.println("The length of the title is :" + driver.getTitle().length());
		
		String currentUrl=driver.getCurrentUrl();
		System.out.println("The current url of the browser is :" + currentUrl);
		
		if(currentUrl.equals(baseUrl))
		{
			System.out.println("Verification Successful - The correct Url is opened.");
		}
		else
		{
			System.out.println("Verification Failed - The incorrect Url is opened.");
		}
		
		//String pageSource=driver.getPageSource();
		//System.out.println("The page source of the browser is :" +driver.getPageSource());
		//System.out.println("The length of the page source of the browser is :" +driver.getPageSource().length());
		
	}
	
	public void closePage()
	{
		//driver.close();//	
		driver.quit();
		System.out.println("Successfully closed the google chrome browser");
	}
	
	public static void main(String[] args) 
	{
		BasicBrowserCommands obj=new BasicBrowserCommands();
		obj.setup();
		obj.openPage();
		obj.getPageDetails();
		obj.closePage();
	}

	
}
