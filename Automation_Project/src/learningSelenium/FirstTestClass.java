//Just to check if the setup is ready//

package learningSelenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestClass 
{
	

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com//");
        System.out.println("Webpage opened successfully");

	}

}
