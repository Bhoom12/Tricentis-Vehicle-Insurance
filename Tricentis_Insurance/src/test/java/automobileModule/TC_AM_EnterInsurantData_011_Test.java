package automobileModule;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.AMInsurantData;
import pom.AMVehicleData;
import pom.TricentisHomePage;
/***
 * 
 * @author Bhomika
 *
 */

public class TC_AM_EnterInsurantData_011_Test extends BaseClass {
	@Test
	public void TC_AM_EnterInsurantData_011() {// To check Gender radio button label is displayed
		Reporter.log("TC_AM_EnterVehicleData_011_Test", true);
		String expectedLabel = DataReader.getTestData("TC_AM_EnterVehicleData_011", "EXPECTED DATA");
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMInsurantData enterInsurantData = new AMInsurantData(driver);
		enterInsurantData.getEnterInsurantDataPage().click();
		explicitwait.until(ExpectedConditions.visibilityOf(enterInsurantData.getGenderLabelRadioButton()));
		Assert.assertEquals(driver.getTitle(), DataReader.fromPropertyFile("expectedInsurantPageTitle"),
				"Automobile Enter Insurant page is not displayed successfully");
		Reporter.log("Automobile Enter Insurant page is not displayed successfully", true);
		String genderLabel = enterInsurantData.getGenderLabelRadioButton().getText();
		Assert.assertEquals(genderLabel, expectedLabel, "Gender radio button label is mismatched");
		Reporter.log("Gender radio button label is matched", true);
	}
}
