package automobileModule;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.AMVehicleData;
import pom.TricentisHomePage;

public class TC_AM_EnterVehicleData_006_Test extends BaseClass {
	// To check when user select default option of Make dropdown error msg is displayed
	@Test
	public void TC_AM_EnterVehicleData_006() {
		Reporter.log("TC_AM_EnterVehicleData_006_Test", true);
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		String expectedData = DataReader.getTestData("TC_AM_EnterVehicleData_006", "EXPECTED DATA");
		Select select = new Select(enterVehicleData.getMakeDropdown());
		List<WebElement> makeOptions = select.getOptions();
		select.selectByValue("default");
		Assert.assertEquals(select.getFirstSelectedOption().getText().toString(), makeOptions.get(0).getText(),
				"Dropdown selected default option is mismatched");
		Reporter.log(select.getFirstSelectedOption().getText().toString(), true);
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getMsgOfMakeDropdown()));
		Assert.assertEquals(enterVehicleData.getMsgOfMakeDropdown().getText(), expectedData,
				"Make dropdown error message is mismatched");
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getIconmMakeDropdown()));
		Assert.assertEquals(enterVehicleData.getIconmMakeDropdown().getCssValue("background-position"),
				DataReader.fromPropertyFile("asteriskPosition"),
				"Negative data" + makeOptions.get(1).getText() + "is not acepted");
		Reporter.log("when user select default option of Make dropdown error msg is displayed properly as "+enterVehicleData.getMsgOfMakeDropdown().getText() +" and astrisk symbol is displayed");			
	}
}
