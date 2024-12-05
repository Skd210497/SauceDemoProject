package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base_class;

public class LoginPage extends Base_class{
	
	WebDriver driver;
	private	By Username = By.name("user-name");
	private	By Password = By.name("password");
	private	By loginbtn = By.name("login-button");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		driver.findElement(Username).sendKeys(props.getProperty("username"));
		driver.findElement(Password).sendKeys(props.getProperty("password"));
		driver.findElement(loginbtn).click();
		
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	
	

}
