package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class Base_class {

	public static WebDriver driver;
	public static Properties props;

	@BeforeTest
	public void readconfig() throws IOException {

		props = new Properties();
		FileReader reader = new FileReader(
				"C:\\Users\\skd12\\eclipse-workspace\\Orange_Hrm\\configuration\\config.properties");
		props.load(reader);

	}

	@BeforeMethod
	public void lunchApp() throws IOException {

		WebDriverManager.chromedriver().setup();
		String browserName = props.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}

		driver.get(props.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

	}

	

	

	@AfterMethod

	public void tearDown(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
				String screenshotName = result.getName() + ".png";
				File destFile = new File("screenshots/" + screenshotName);
				Files.copy(srcFile.toPath(), destFile.toPath());
				Allure.attachment("Failed_Test", FileUtils.openInputStream(srcFile));
			
		}
		driver.quit();
	}


}
