package automobileModule;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;

public class TC_AM_EnterVehicleData_007_Test extends BaseClass {
	//To check Engine Performance textbox Label is displayed
	@Test
	public void TC_AM_EnterVehicleData_007() {
		Reporter.log("TC_AM_EnterVehicleData_007_Test",true);
		String expectedData=DataReader.getTestData("TC_AM_EnterVehicleData_007","EXPECTED DATA");
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		Assert.assertEquals(enterVehicleData.getEnginePerformanceLabel().getText(), expectedData,"Engine Performance textbox Label is mismatched");
		Reporter.log("Engine Performance textbox Label is matched",true);
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getIconEnginePerformanceLabel()));
		Assert.assertEquals(enterVehicleData.getIconEnginePerformanceLabel().getCssValue("background-position"),DataReader.fromPropertyFile("asteriskPosition"),"Engine Performance asterisk icon is not displayed");
		Reporter.log("Engine Performance textbox Label is displayed as "+enterVehicleData.getEnginePerformanceLabel().getText() +" successfully");	
	}
}
