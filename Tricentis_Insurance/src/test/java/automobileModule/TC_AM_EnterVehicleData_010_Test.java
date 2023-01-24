package automobileModule;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;

public class TC_AM_EnterVehicleData_010_Test extends BaseClass {
	@DataProvider
	public static String[]data() {
		return DataReader.getTestDataForDataProvider("TC_AM_EnterVehicleData_010", "TESTDATA");
	}

	@Test(dataProvider = "data")
	public void TC_AM_EnterVehicleData_010(String n) {
		Reporter.log("TC_AM_EnterVehicleData_010_Test",true);
		String expectedData=DataReader.getTestData("TC_AM_EnterVehicleData_010","EXPECTED DATA");
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		//int data=(int) Double.parseDouble(n);
		//String passingData=Integer.toString(data);
		enterVehicleData.getEnginePerformanceTextField().clear();
		enterVehicleData.getEnginePerformanceTextField().sendKeys(n);
	//	WebDriverWait explicitwait = new WebDriverWait(driver, 15);
		
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getErrorMsgEnginePerformance()));
		Assert.assertEquals(enterVehicleData.getErrorMsgEnginePerformance().getText(), expectedData,"EnginePerformance error message is mismatched");
		Reporter.log(enterVehicleData.getErrorMsgEnginePerformance().getText()+" error message displayed properly",true);
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getIconEnginePerformanceLabel()));
		Assert.assertEquals(enterVehicleData.getIconEnginePerformanceLabel().getCssValue("background-position"),DataReader.fromPropertyFile("asteriskPosition"),"Negative data"+n +"is not acepted");
		Reporter.log("Negative data" + expectedData + "is not accepted and proper error msg"+enterVehicleData.getErrorMsgEnginePerformance().getText()+"is displayed successfully and asterisk symbol is displayed",true);
		
	
		
		

	}
}
