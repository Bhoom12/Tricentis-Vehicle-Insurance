package basePackage;

import java.io.File;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

//import excelReader.ExcelDataReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver = null;
	public static WebDriverWait explicitwait =null;
	

	//@Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	public void browserSetUp(@Optional("Firefox") String browserName) throws IOException {

		if (browserName.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Msedge")) {
			 WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Opera")) {
			 WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else {
			Reporter.log("pass vaild driver");
		}
		Reporter.log("Empty browser is launched", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		explicitwait = new WebDriverWait(driver, 15);
		driver.get(DataReader.fromPropertyFile("url"));
		
		Assert.assertEquals(driver.getTitle(), DataReader.fromPropertyFile("expectedMainPageTitle"),
				"Application Main page is not displayed successfully");
		Reporter.log("Application Main page is displayed successfully", true);
	}

	
	@AfterClass(alwaysRun = true)
	public void browserTearDown() {
		driver.quit();
		Reporter.log("Closed the browser session successfully", true);
	}

}
