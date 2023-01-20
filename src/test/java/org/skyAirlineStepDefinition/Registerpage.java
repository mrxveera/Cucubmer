package org.skyAirlineStepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Registerpage {

	static WebDriver driver;

	@Given("The user should be in sky ariline page")
	public void the_user_should_be_in_sky_ariline_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.skyairline.com/english");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='pa-deny-btn']")).click();
	}

	@Given("click the register page")
	public void click_the_register_page() {
		WebElement re = driver.findElement(By.xpath("//div[@class='user-info hidden-md-and-down']"));
		re.click();
		driver.findElement(By.xpath("//p[@class='register']")).click();
	}

	@When("The user enter the First name and Last name and Email and Password and re-enter password")
	public void the_user_enter_the_First_name_and_Last_name_and_Email_and_Password_and_re_enter_password(
			io.cucumber.datatable.DataTable data) {
		List<Map<String, String>> list = data.asMaps();
		Map<String, String> mp = list.get(2);
		String user = mp.get("Firstname");
		System.out.println(user);

		driver.findElement(By.name("firstName")).sendKeys(list.get(2).get("Firstname"));
		System.out.println(list.get(2).get("Firstname"));
		driver.findElement(By.name("lastName")).sendKeys(list.get(2).get("Lastname"));
		System.out.println(list.get(2).get("Lastname"));
		driver.findElement(By.name("username")).sendKeys(list.get(2).get("mail"));
		System.out.println(list.get(2).get("mail"));
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys(list.get(2).get("password"));
		System.out.println(list.get(2).get("password"));
		driver.findElement(By.name("confirmPassword")).sendKeys(list.get(2).get("re-password"));
		System.out.println(list.get(2).get("re-password"));

	}

	@Then("The user should click the register button and to navigate home")
	public void the_user_should_click_the_register_button_and_to_navigate_home() {
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		driver.close();
	}
}
