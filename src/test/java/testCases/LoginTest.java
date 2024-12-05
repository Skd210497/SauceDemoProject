package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.Base_class;
import pageObjects.LoginPage;
import utility.LoginDataProvider;

public class LoginTest extends Base_class {

	LoginPage lp;

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class,priority=0)
	public void loginTest(String username, String password) {

		Reporter.log("login test");
		LoginPage lp = new LoginPage(driver);
		lp.login();
		Reporter.log("Check the title of the page");
		Assert.assertEquals("Swag Labs", lp.getTitle());

	}

}
