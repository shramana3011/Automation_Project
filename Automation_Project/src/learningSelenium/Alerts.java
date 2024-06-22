package learningSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	private WebDriver driver;
	String baseUrl = "https://demoqa.com/alerts";

	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public void openPage() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(6000);
		driver.manage().window().maximize();

		System.out.println("Webpage opened successfully");
	}

	public void workWithSimpleAlerts() throws InterruptedException {
		// Simple Alert
		driver.findElement(By.id("alertButton")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println("Switched to simple alert successfully");
		Thread.sleep(7000);
		simpleAlert.accept();
		System.out.println("Simple Alert accepted successfully");

	}

	public void workWithConfirmAlerts() throws InterruptedException {
		// Confirm Alert
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println("Switched to confirm alert successfully");
		Thread.sleep(7000);
		String alertText = confirmAlert.getText();
		System.out.println("Alert text is:" + alertText);
		confirmAlert.accept();
		// confirmAlert.dismiss();
		System.out.println("Confirm Alert accepted successfully");

	}

	public void workWithPromptAlerts() throws InterruptedException {
		// Prompt Alert
		driver.findElement(By.id("promtButton")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("Switched to prompt alert successfully");
		Thread.sleep(7000);
		String alertText = promptAlert.getText();
		System.out.println("Alert text is:" + alertText);
		promptAlert.sendKeys("Test User");
		Thread.sleep(5000);
		promptAlert.accept();
		// confirmAlert.dismiss();
		System.out.println("Prompt Alert accepted successfully");

	}

	public static void main(String[] args) throws InterruptedException {
		Alerts obj = new Alerts();
		obj.setUp();
		obj.openPage();
		// obj.workWithSimpleAlerts();
		obj.workWithConfirmAlerts();
		// obj.workWithPromptAlerts();
	}

}
