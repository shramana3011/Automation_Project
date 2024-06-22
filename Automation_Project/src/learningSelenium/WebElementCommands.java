//Basic webelement commands//


package learningSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementCommands
{
	private WebDriver driver;
	String baseUrl="https://rahulshettyacademy.com/locatorspractice/";
	WebElement username;
	WebElement password;
	WebElement signIn;
	
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public void openPage()
	{
		driver.get(baseUrl);
		System.out.println("Successfully opened the browser page");
		driver.manage().window().maximize();
	}
	public void findElement()
	{
		username=driver.findElement(By.id("inputUsername"));
        username.sendKeys("Shramana Roy");
        password=driver.findElement(By.name("inputPassword"));
        password.sendKeys("Shramana Roy");
     //   signIn=driver.findElement(By.className("submit signInBtn"));
     //   signIn.click();
     //   System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        
        
        
	}
	public void getTextBoxDetails()
	{
		
        //textbox.clear();//
       //String text=textbox.getText();//
      // System.out.println("The text typed in the text box is :" + text);  //Not working
       System.out.println("The text typed in the text box is :" + username.getAttribute("value"));
       
       System.out.println("The tagname of the textbox is :" +username.getTagName());
        
       System.out.println("The cSSValue of the textbox is :" + username.getCssValue("font-size"));
       
       System.out.println("The size of the textbox is :" + username.getSize());
       
       System.out.println("The location of the textbox is :" + username.getLocation());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         

	}
	public void findElementsbyTagname()
	{
		List<WebElement> allInputElements = driver.findElements(By.tagName("input"));
		if(allInputElements.size() != 0)
		{
			System.out.println(allInputElements.size() +  "Elements found with tagmane as input");
			
			for(WebElement inputElement : allInputElements)
			{
				   System.out.println(inputElement.getAttribute("placeholder"));

			}
		}
		
	
	}
	public static void main(String[] args) 
	{
			WebElementCommands obj=new WebElementCommands();
			obj.setUp();
			obj.openPage();
			obj.findElement();
			obj.getTextBoxDetails();
			obj.findElementsbyTagname();
		//	obj.closePage();


}
}



