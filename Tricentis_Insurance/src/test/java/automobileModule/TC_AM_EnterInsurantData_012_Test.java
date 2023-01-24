package automobileModule;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.AMInsurantData;
import pom.TricentisHomePage;

public class TC_AM_EnterInsurantData_012_Test extends BaseClass {
	@Test
	public void TC_AM_EnterInsurantData_012() {// To check Male label radio button is displayed
		Reporter.log("TC_AM_EnterVehicleData_012_Test", true);
		String expectedLabel = DataReader.getTestData("TC_AM_EnterVehicleData_012", "EXPECTED DATA");
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMInsurantData enterInsurantData = new AMInsurantData(driver);
		enterInsurantData.getEnterInsurantDataPage().click();
		explicitwait.until(ExpectedConditions.visibilityOf(enterInsurantData.getGenderLabelRadioButton()));
		Assert.assertEquals(enterInsurantData.getMaleLabelRadioButton().getText(),expectedLabel,"Male Label of radio button is mismatched");
		Reporter.log("Male label of radio button is displayed successfully");
	}
}
