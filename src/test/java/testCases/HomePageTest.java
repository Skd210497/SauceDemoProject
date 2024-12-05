package testCases;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.Base_class;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTest extends Base_class{
	LoginPage lp;
	HomePage hp;
	
	
  @Test(priority=1)
  public void Verify_Logo() {
	  Reporter.log("Vrify home page Logo");
	  lp = new LoginPage(driver);
	  lp.login();
	   hp = new HomePage(driver);
		  Assert.assertEquals("Swag Labs", hp.logoText());
	  
  }
  
  @Test(priority=2)
  public void VerifyCartBtn() {
	  Reporter.log("User loged in");
	  lp = new LoginPage(driver);
	  lp.login();
	  Reporter.log("Log in sucessfull");
	  hp = new HomePage(driver);
	  Reporter.log("Click on cart Button");
	  hp.cart();
	  Reporter.log("User sucessfully clicked the cart Button");
	  
  }
  
  @Test(priority=3)
  public void VrifyMenuBtn() {
	  lp = new LoginPage(driver);
	  lp.login();
	  hp = new HomePage(driver);
	  hp.menu();
  }
  
  @Test(priority=4)
  public void Logout() {
	  lp = new LoginPage(driver);
	  lp.login();
	  hp = new HomePage(driver);
	  hp.menu();
	  hp.logout();
  }
  
  @Test(priority=5)
  public void  VerifyFilter() throws InterruptedException {
	  lp = new LoginPage(driver);
	  lp.login();
	  hp = new HomePage(driver);
	  hp.filter();
	  
	  
  }
  
  @Test(priority=6)
  public void VerifyCartdetails() throws InterruptedException {
	  String expTitle="Your Cart";
	  String expPrice="$15.99";
	  lp = new LoginPage(driver);
	  lp.login();
	  hp = new HomePage(driver);
	  hp.filter();
	  hp.ProductaddtoCart();
	  Assert.assertEquals(expTitle, hp.cartPageTitle());
	  Assert.assertEquals(expPrice,hp.cartproductPrice());
	  System.out.println(hp.cartproductPrice());
  }
  


  @Test(priority=7)
  public void testAllPrices() throws InterruptedException {
	  lp = new LoginPage(driver);
	  lp.login();
	  hp = new HomePage(driver);
	  Thread.sleep(6000);
	 List<String> beforesort= hp.AllPrice();
	 Thread.sleep(5000);
	  hp.filter();
	  Thread.sleep(5000);
	  List<String> Aftersort= hp.AllPrice();
	  Thread.sleep(5000);
	  List<Double> beforeSortPrices = beforesort.stream() .map(price -> price.replace("$", "").trim()) .map(Double::parseDouble) .collect(Collectors.toList()); List<Double> afterSortPrices = Aftersort.stream() .map(price -> price.replace("$", "").trim()) .map(Double::parseDouble) .collect(Collectors.toList()); // Check if beforeSortPrices is in ascending order List<Double> sortedBeforePrices = new ArrayList<>(beforeSortPrices); Collections.sort(sortedBeforePrices); Assert.assertEquals(beforeSortPrices, sortedBeforePrices, "Prices before sorting are not in ascending order."); // Check if afterSortPrices is in ascending order List<Double> sortedAfterPrices = new ArrayList<>(afterSortPrices); Collections.sort(sortedAfterPrices); Assert.assertEquals(afterSortPrices, sortedAfterPrices, "Prices after sorting are not in ascending order."); }
	  System.out.println(beforeSortPrices);
	  System.out.println(afterSortPrices);
	  

  }
  
  
}
