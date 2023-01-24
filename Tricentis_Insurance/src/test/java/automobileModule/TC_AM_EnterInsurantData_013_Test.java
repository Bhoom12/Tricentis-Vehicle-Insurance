package automobileModule;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.AMInsurantData;
import pom.TricentisHomePage;

public class TC_AM_EnterInsurantData_013_Test extends BaseClass{
	@Test
	public void TC_AM_EnterInsurantData_013(){// To check Female label radio button is displayed
		Reporter.log("TC_AM_EnterVehicleData_013_Test", true);
		String expectedLabel = DataReader.getTestData("TC_AM_EnterVehicleData_013", "EXPECTED DATA");
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMInsurantData enterInsurantData = new AMInsurantData(driver);
		enterInsurantData.getEnterInsurantDataPage().click();
		explicitwait.until(ExpectedConditions.visibilityOf(enterInsurantData.getFemaleLabelRadioButton()));
		System.out.println(enterInsurantData.getFemaleLabelRadioButton().getText());
		Assert.assertEquals(enterInsurantData.getFemaleLabelRadioButton().getText(),expectedLabel,"Female Label of radio button is mismatched");
		enterInsurantData.getFemaleLabelRadioButton().click();
		Reporter.log("Female label of radio button is displayed successfully");
	}
}
