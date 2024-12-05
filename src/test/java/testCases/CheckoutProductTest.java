package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base_class;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class CheckoutProductTest extends Base_class {

	LoginPage lp;
	HomePage hp;
	CheckoutPage cp;

	@Test(priority=1)
	public void ProductOrder() {

		lp = new LoginPage(driver);
		lp.login();
		hp = new HomePage(driver);
		hp.ProductaddtoCart();
		cp = new CheckoutPage(driver);
		cp.clickCheckoutBtn();
		cp.fillInfo();
		cp.clickContinue();
		cp.clickfinish();
		String oderconfirm = "Thank you for your order";
		Assert.assertEquals(oderconfirm, cp.orderConfirmMsg());
	}
	
	@Test(priority=0)
	
	public void VerifyPageTitle() {
		lp = new LoginPage(driver);
		lp.login();
		hp = new HomePage(driver);
		hp.ProductaddtoCart();
		cp = new CheckoutPage(driver);
		cp.clickCheckoutBtn();
		String pageTitle="Checkout: Your Information";
		Assert.assertEquals(pageTitle, cp.pageTitle());
	}
	
	@Test(priority=2)
	public void navigatebacktoCart() {
		lp = new LoginPage(driver);
		lp.login();
		hp = new HomePage(driver);
		hp.ProductaddtoCart();
		cp = new CheckoutPage(driver);
		cp.clickCheckoutBtn();
		cp.backtoCart();
	}

}
