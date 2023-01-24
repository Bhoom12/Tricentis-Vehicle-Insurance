package automobileModule;

import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;


public class TC_AM_EnterVehicleData_008_Test extends BaseClass {
	
	@Test
	public void TC_AM_EnterVehicleData_008() {//To check when user click on engine performance textfield proper help msg shld be displayed
		Reporter.log("TC_AM_EnterVehicleData_008_Test",true);
		String expectedData=DataReader.getTestData("TC_AM_EnterVehicleData_008","EXPECTED DATA");
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		enterVehicleData.getEnginePerformanceTextField().click();
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getMsgOfEnginePerformance()));
		Assert.assertEquals(enterVehicleData.getMsgOfEnginePerformance().getText(), expectedData,"EnginePerformance message is mismatched");
		Reporter.log(enterVehicleData.getMsgOfEnginePerformance().getText()+" message displayed properly",true);
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getIconEnginePerformanceLabel()));
		Assert.assertEquals(enterVehicleData.getIconEnginePerformanceLabel().getCssValue("background-position"),DataReader.fromPropertyFile("asteriskPosition"),"Engine Performance asterisk icon is not displayed");
		Reporter.log("when user click on engine performance textfield proper help msg "+enterVehicleData.getMsgOfEnginePerformance().getText() +" is displayed properly");	
	}
}
