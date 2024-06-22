package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DropDownCommands 
{
	private WebDriver driver;
	String baseUrl1="https://demoqa.com/select-menu";
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
	
	public void staticsingleDropdownCommands()
	{
		//Selecting the dropdown element by xpath
		Select dropdown=new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
		
	//	Select dropdown=new Select(driver.findElement(By.id("oldSelectMenu")));
		
		//Printing the options of the dropdown Get list of web elements
		
		List<WebElement> optionsList = dropdown.getOptions();
		
		//Looping through the options and printing dropdown options
		
		System.out.println("The dropdown options are:");
		for (WebElement ol:optionsList)
		{
			System.out.println(ol.getText());
		}
		
		//Selecting the option by index//
		dropdown.selectByIndex(2);
		System.out.println("Selected the correct option from the dropdown which is:"+ dropdown.getFirstSelectedOption().getText());
	
		
		//Selecting the option by value//
		dropdown.selectByValue("4");		//Index value starts from 0
		System.out.println("Selected the correct option from the dropdown which is " + dropdown.getFirstSelectedOption().getText());
		
		//Selecting the option by visibletext//
		dropdown.selectByVisibleText("White");		//Index value starts from 0
		System.out.println("Selected the correct option from the dropdown which is " + dropdown.getFirstSelectedOption().getText());
	}
	
	public void dynamicDropdown() throws InterruptedException
	{
		driver.findElement(By.className("css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73")).click();
		driver.findElement(By.xpath("//input[@value=\'Agra (AGR)\']")).click();
		Thread .sleep(2000);
		driver.findElement(By.xpath("//input[@value=\'Delhi (DEL)\'])[2]")).click();
		
		
		
	}
	public void autoSuggestiveDropdown() throws InterruptedException
	{
		WebElement from= driver.findElement(By.xpath("//input[@placeholder=\'From\']"));
		from.sendKeys("Bengaluru");
		Thread.sleep(1000);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);


		

	}
	
	public void multiSelectDropdown()
	{
		//Finding and clicking on the textbox first
		//driver.findElement(By.xpath("(//div[@class=\" css-yk16xz-control\"])[3]")).click();
		
		//Selecting the multi-select element by locating its id
		Select select = new Select(driver.findElement(By.id("cars")));
		
		 //Get the list of all the options
		System.out.println("The dropdown options are -");
		
		List <WebElement> options= select.getOptions();
		
		for (WebElement option : options)
		{
			System.out.println(option.getText());
		}
		 //Using isMultiple() method to verify if the element is multi-select, if yes go onto next steps else eit
        if(select.isMultiple()){

            //Selecting option as 'Opel'-- ByIndex
            System.out.println("Select option Opel by Index");
            select.selectByIndex(2);

            //Selecting the option as 'Saab'-- ByValue
            System.out.println("Select option saab by Value");
            select.selectByValue("saab");

            // Selecting the option by text
            System.out.println("Select option Audi by Text");
            select.selectByVisibleText("Audi");
            
            
            //Get the list of selected options
            System.out.println("The selected values in the dropdown options are -");

            List<WebElement> selectedOptions = select.getAllSelectedOptions();

            for(WebElement selectedOption: selectedOptions)
                System.out.println(selectedOption.getText());


            // Deselect the value "Audi" by Index
            System.out.println("DeSelect option Audi by Index");
            select.deselectByIndex(3);

            //Deselect the value "Opel" by visible text
            System.out.println("Select option Opel by Text");
            select.deselectByVisibleText("Opel");
            
          //Validate that both the values are deselected
            System.out.println("The selected values after deselect in the dropdown options are -");
            List<WebElement> selectedOptionsAfterDeselect = select.getAllSelectedOptions();

            for(WebElement selectedOptionAfterDeselect: selectedOptionsAfterDeselect)
                System.out.println(selectedOptionAfterDeselect.getText());

            //Step#8- Deselect all values
            select.deselectAll();

            System.out.println("Hi");
        }
		
	}
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		DropDownCommands obj=new DropDownCommands();
			obj.setUp();
			obj.openPage();
		//	obj.staticsingleDropdownCommands();
		//	obj.dynamicDropdown();
		//	obj.autoSuggestiveDropdown();
			obj.multiSelectDropdown();
			
			


}

}
