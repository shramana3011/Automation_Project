package endtoendproject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import learningSelenium.WebElementCommands;

public class ECommerceApp 
{
	private WebDriver driver;
	String baseUrl1="https://rahulshettyacademy.com/seleniumPractise/#/";
	int j=0;
	
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
		Thread.sleep(5000);
	}
	//by.xpath(//button[text()='ADD TO CART'])
	//by.css(h4.product-name);
	
	// It is not working
	public void orderItems()
	{
		
		String vegetables[]={"Cucumber","Brocolli","Brinjal"};
		List <WebElement> products= driver.findElements(By.tagName("h4"));
		
		for(int i=0;i<products.size();i++)
		{
			//format it to get actual vegetable name	
	
			String name[]=products.get(i).getText().split("-");
			
			//name[0]='Cucumber - 1 Kg'
			//name[1]='1 Kg'
			String formattedname=name[0].trim();//Remove the extra space
			
				
			//Check if the extracted text in the above defined array
			//Convert array to arrayList for easy search
				
				List items=Arrays.asList(vegetables);
				if(items.contains("formattedname"))
				{
					j++;
		
					driver.findElements(By.xpath("//div[@class='product-action']/button']")).get(i).click();
					if(j==3) 
					{
						break;
					}
		}
	}
}
	
	public static void main(String[] args) throws InterruptedException 
	{
		ECommerceApp obj=new ECommerceApp();
			obj.setUp();
			obj.openPage();
			obj.orderItems();
		


}
}