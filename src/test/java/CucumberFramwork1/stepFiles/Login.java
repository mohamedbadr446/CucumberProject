package CucumberFramwork1.stepFiles;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import CucumberFramwork1.excel.ExcelUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	private WebDriver driver;
	private ExcelUtils doc;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\CucumberFramwork1\\src\\test\\java\\CucumberFramwork1\\resources\\chromedriver.exe");
		doc=new ExcelUtils();
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(6, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver=null;
	}
	
	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
	    this.driver.get("https://stackoverflow.com/");
	} 

	@And("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		Thread.sleep(2000);
		this.driver.findElement(By.xpath("/html/body/header/div/ol[2]/li[2]/a[1]")).click();
	}

	@And("^User enters avalide username$")
	public void user_enters_avalide_username() throws Throwable {
		Thread.sleep(2000);
//		this.driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("mohamedbadreamine@gmail.com");
		this.driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(doc.getData(1, 0));
	}

	@And("^User enters avalide password$")
	public void user_enters_avalide_password() throws Throwable {
		Thread.sleep(2000);
//		this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Gargantua97");
		this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(doc.getData(1, 1));
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		Thread.sleep(2000);
		this.driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
	
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
		WebElement askQuetionButton = driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/div/a"));
		Assert. assertEquals(true, askQuetionButton.isDisplayed());
	}


}
