package org.stepdefinition;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SigninSteps {
static WebDriver driver;
@Given("The user should be in argos page")
public void the_user_should_be_in_argos_page() {
   WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
   driver.get("https://www.argos.co.uk/");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   WebElement cook = driver.findElement(By.id("consent_prompt_submit"));
   cook.click();
}

@When("The user enter the correct  {string}   and invalid {string}")
public void the_user_enter_the_correct_and_invalid(String email, String pass) {
	 WebElement accc = driver.findElement(By.xpath("(//a[@class='_20hv0'])[1]"));
		accc.click();
	WebElement emailadd = driver.findElement(By.id("email-address"));
	emailadd.sendKeys(email);
	WebElement password = driver.findElement(By.name("currentPassword"));
	password.sendKeys(pass);
   
}

@When("The uaer has to click the sign in securely button")
public void the_uaer_has_to_click_the_sign_in_securely_button() {
   WebElement sign = driver.findElement(By.className("button"));
   sign.click();
}

@Then("The user should navigate to the invalid page")
public void the_user_should_navigate_to_the_invalid_page() {
	WebDriverWait r= new WebDriverWait(driver,30);
	WebElement inval = driver.findElement(By.xpath("//span[@class='alert__message']"));
    String text = inval.getText();
    System.out.println(text);
	
	
}


}
