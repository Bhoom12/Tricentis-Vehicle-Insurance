package pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import basePackage.BaseClass;

import basePackage.DataReader;
import pom.AMVehicleData;

public class TricentisHomePage extends BaseClass{
	public WebElement getAutomobileNavBar() {
		return automobileNavBar;
	}


	public TricentisHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//@FindBy(id = "nav_automobile")
	@FindBy(id = "nav_automobile")
	private WebElement automobileNavBar;


	public static void navigateToAutomobile() {
		driver.findElement(By.id("nav_automobile")).click();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		WebDriverWait explicitwait = new WebDriverWait(driver, 15);
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getAutomobileInsurancePageConfirm()));
		Assert.assertEquals(driver.getTitle(), DataReader.fromPropertyFile("expectedAutomobilePageTitle"), "Automobile page is not displayed successfully");
		Reporter.log("Automobile module page is displayed successfully",true);
	}


	
	
	
}
