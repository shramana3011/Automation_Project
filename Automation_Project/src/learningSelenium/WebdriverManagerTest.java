//Just to check if the webdrivermanager setup is ready//

package learningSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverManagerTest 
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
		driver.get(baseUrl);
		System.out.println("Successfully opened the google page");
	}
	
	public static void main(String[] args)
	{
		WebdriverManagerTest obj=new WebdriverManagerTest();
		obj.setup();
		obj.openPage();
			
	}
	

}
