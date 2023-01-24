package automobileModule;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;


public class TC_AM_EnterVehicleData_001_Test extends BaseClass {
	
	@Test
	public void TC_AM_EnterVehicleData_001() {//To check Make(dropdown) label is displayed and spelled properly
		String expectedLabel = DataReader.getTestData("TC_AM_EnterVehicleData_001", "EXPECTED DATA");
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		Assert.assertEquals(enterVehicleData.getMakeDropdownLabel().isDisplayed(), true, "Make label is not displayed");
		Reporter.log("Make label is displayed",true);
		String makeLabel = enterVehicleData.getMakeDropdownLabel().getText();
		Assert.assertEquals(makeLabel, expectedLabel, "Make Label is mismatched");
		Reporter.log("Make Label is matched", true);
	}
}
