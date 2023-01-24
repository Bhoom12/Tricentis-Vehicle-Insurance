package automobileModule;

import java.util.List;


import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;

public class TC_AM_EnterVehicleData_002_Test extends BaseClass {
	// To check Make dropdown options are displayed and spelled properly
	@Test
	public void TC_AM_EnterVehicleData_002() {
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		String expectedMakeDropdownOptions = DataReader.getTestData("TC_AM_EnterVehicleData_002", "EXPECTED DATA");
		String d[] = expectedMakeDropdownOptions.split(",");
		Assert.assertEquals(enterVehicleData.getMakeDropdown().isDisplayed(), true, "Make dropdown is not displayed");
		Select select = new Select(enterVehicleData.getMakeDropdown());
		List<WebElement> makeOptions = select.getOptions();
		Assert.assertEquals(makeOptions.size(), d.length, "Dropdown number of options mismatched");
		for (int i = 0; i < makeOptions.size(); i++) {
			Assert.assertEquals(makeOptions.get(i).getText(), d[i], "Make dropdown " + d[i] + " option mismatched");
		}
		Reporter.log("Make dropdown options are matched with the requriment", true);

	}

}
