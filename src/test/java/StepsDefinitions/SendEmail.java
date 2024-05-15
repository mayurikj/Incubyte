package StepsDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendEmail {
	WebDriver driver = null;
	@Given("browser is open")
	public void user_logged_in() throws InterruptedException {
		
		System.getProperty("webdriver.chrome.driver", "C:/Users/vikas/Downloads/driver/chromedriver.exe");
		System.out.println("User is logged into Gmail application");
		 driver = new ChromeDriver();
		Thread.sleep(2000);	
	}
	
	@And("user navigates to gmail application")
	public void user_navigates_to_gmail() {
			System.out.println("User is on Gmail application");	
			driver.navigate().to("https://gmail.com");
	}
	
	@And("user enter gmail credentials")
	public void user_enters_gmail_credentials() throws InterruptedException {
		System.out.println("Inside Step - user email ID");		
		driver.findElement(By.id("identifierId")).sendKeys("mayurijangam98@gmail.com");
		Thread.sleep(2000);
		System.out.println("Inside Step - click on Next");	
		//driver.findElement(By.xpath("//*[@id=identifierNext]/div/button/span")).click();
		driver.findElement(By.id("identifierId")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		System.out.println("Inside Step - Enter Password");
		driver.findElement(By.cssSelector("whsOnd zHQkBf")).sendKeys("stronger@9");
		driver.findElement(By.id("identifierId")).sendKeys(Keys.RETURN);	
		
		
	}
	@When("user add (.*), (.*) and(.*)")
	public void user_enter_subject_mail(String emailrecipient, String subject, String body) throws InterruptedException {
		System.out.println("user add recipient mail, subject and body");
		driver.findElement(By.cssSelector("T-I T-I-KE L3")).click();
		Thread.sleep(2000);
		System.out.println("User add recipient mail");
		driver.findElement(By.id(":tx")).sendKeys(emailrecipient);
		Thread.sleep(2000);	
		System.out.println("User add subject:Incubyte ");
		driver.findElement(By.id(":qb")).sendKeys(subject);
		Thread.sleep(2000);
		System.out.println("User add subject body: Automation QA test for Incubyte");
		driver.findElement(By.id(":rl")).sendKeys(body);
		Thread.sleep(2000);
		System.out.println("User click on Send mail button");
		driver.findElement(By.id(":q1")).click();
		
	}
	
	@Then("email should be sent successfully")
	public void email_should_be_sent_successfully() throws InterruptedException {
	    
		System.out.println("email should be sent successfully");
		WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Message sent')]"));
		
		if (element.isDisplayed()) {
            
            System.out.println("Test case passed: Message sent is visible on webpage");
        } else {
            System.out.println("Test case failed: Message sent is not visible on webpage");
        }
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
