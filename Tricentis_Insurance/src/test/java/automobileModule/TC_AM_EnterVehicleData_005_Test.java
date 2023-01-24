package automobileModule;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;


public class TC_AM_EnterVehicleData_005_Test extends BaseClass  {
	//To check error message is displayed when user click on Make dropdown
	@Test
	public void TC_AM_EnterVehicleData_005() {
		Reporter.log("TC_AM_EnterVehicleData_005_Test", true);
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		String expectedData=DataReader.getTestData("TC_AM_EnterVehicleData_005","EXPECTED DATA");
		enterVehicleData.getMakeDropdown().click();
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getMsgOfMakeDropdown()));
		Assert.assertEquals(enterVehicleData.getMsgOfMakeDropdown().getText(), expectedData,"Make dropdown message is mismatched");
		Reporter.log(enterVehicleData.getMsgOfMakeDropdown().getText()+" message displayed properly",true);
		Assert.assertEquals(enterVehicleData.getIconmMakeDropdown().getCssValue("background-position"),DataReader.fromPropertyFile("asteriskPosition"),"Asterisk symbol is not displayed properly");
		Reporter.log("when user click on Make dropdown "+enterVehicleData.getMsgOfMakeDropdown().getText() +" error message is displayed");
		
}
}
