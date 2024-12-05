package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	
	private	By menuBtn = By.id("react-burger-menu-btn");
	private	By cartBtn = By.id("shopping_cart_container");
	private	By logo = By.className("app_logo");
	private	By filterBtn = By.className("product_sort_container");
	private	By logout = By.xpath("//a[@id='logout_sidebar_link']");
	private	By filterbyName = By.xpath("//span[@class='select_container']/select/option[1]");
	private	By filterbyPrice = By.xpath("//span[@class='select_container']/select/option[3]");
	private	By selectProduct = By.xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']");
	private	By addtocart = By.xpath("//button[@id='add-to-cart']");
	private	By productcartBtn = By.xpath("//a[@class='shopping_cart_link']");
	private	By cartpageTitle = By.xpath("//span[@class='title']");
	private	By productTitle = By.xpath("//div[@class='inventory_item_name']");
	private	By productPrice = By.xpath("//div[@class='inventory_item_price']");
	private	By checkOutBtn = By.xpath("//button[@id='checkout']");
	private	By AllproductPrice = By.xpath("//div[@class='inventory_list']/div/div/div[2]/div");
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String logoText() {
		return driver.findElement(logo).getText();
	}
	
	public void logout() {
		driver.findElement(logout).click();
	}
	
	public void cart() {
		driver.findElement(cartBtn).click();
	}
	
	public void filter() throws InterruptedException {
		driver.findElement(filterBtn).click();
		Thread.sleep(2000);
		driver.findElement(filterbyName).click();
		Thread.sleep(2000);
		driver.findElement(filterbyPrice).click();
		Thread.sleep(2000);
	}
	
	public void menu() {
		driver.findElement(menuBtn).click();
	}
	
	public void ProductaddtoCart() {
		
		driver.findElement(selectProduct).click();
		driver.findElement(addtocart).click();
		driver.findElement(productcartBtn).click();
		
		
		
	}
	
	public String cartPageTitle() {
		
		 return driver.findElement(cartpageTitle).getText();
		
	}

	public String cartproductPrice() {
		return driver.findElement(productPrice).getText();
	}
	
	

	public List<String> AllPrice() {
	    // Locate the price elements
	    List<WebElement> prices = driver.findElements(AllproductPrice);

	    // Extract and return the prices as a list of strings
	    return prices.stream()
	                 .map(WebElement::getText)
	                 .collect(Collectors.toList());
	}

	
	
	
}
