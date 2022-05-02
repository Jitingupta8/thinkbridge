package test.thinkbridge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Question2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\eetu ka deewana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jt-dev.azurewebsites.net/#/SignUp");
		driver.findElement(By.cssSelector("[id='language']")).click();
		Thread.sleep(3000);
		//Validating the languages exists or not 
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-select-choices-group"));
		for (WebElement option : options) {
			option.getText().equalsIgnoreCase("English");
			option.getText().equalsIgnoreCase("Dutch");
			flag = true;
		}
		if (flag == true) 
			System.out.println("Language matched " + flag);
		else 
			System.out.println("Language not matched " + flag);
		//Entering values in the form
		driver.findElement(By.cssSelector("[name='name']")).sendKeys("Jitin");
		driver.findElement(By.cssSelector("[name='orgName']")).sendKeys("jitin");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("jitin8853@gmail.com");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("span.black-color.ng-binding"))).click().build()
				.perform();
		driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(7000);
		System.out.println(driver.findElement(By.xpath("//form/div/span")).getText());

	}

}
