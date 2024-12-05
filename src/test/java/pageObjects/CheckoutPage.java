package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	WebDriver driver;
	
private	By firstname = By.id("first-name");
private	By lastname = By.id("last-name");
private	By zipcode = By.id("postal-code");
private	By cancelBtn = By.id("cancel");
private	By continueBtn = By.id("continue");
private	By pagetitle = By.xpath("//span[@class='title']");
private	By finishBtn = By.id("finish");
private	By confirmMsg = By.xpath("//h2[normalize-space()='Thank you for your order!']");
private	By backtoHome = By.id("back-to-products");
private	By checkoutBtn = By.id("checkout");

	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillInfo() {
		driver.findElement(firstname).sendKeys("Selene");
		driver.findElement(lastname).sendKeys("Gomez");
		driver.findElement(zipcode).sendKeys("75148");
		
	}
	
	public String pageTitle() {
		return driver.findElement(pagetitle).getText();
	}
	
	public void backtoCart() {
		driver.findElement(cancelBtn).click();
	}
	
	public void clickContinue() {
		driver.findElement(continueBtn).click();
	}
	
	public void clickfinish() {
		driver.findElement(finishBtn).click();
	}
	
	public String orderConfirmMsg() {
		return driver.findElement(confirmMsg).getText();
	}
	
	public void backtoProduct() {
		driver.findElement(backtoHome).click();
	}
	public void clickCheckoutBtn() {
		driver.findElement(checkoutBtn).click();
	}
	

}
