package automobileModule;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;

public class TC_AM_EnterVehicleData_009 extends BaseClass {
	//To check Engine Performance textfield accepts positive test datas 
	
	@DataProvider
	public static String[] data() {
		return DataReader.getTestDataForDataProvider("TC_AM_EnterVehicleData_009to_013", "TESTDATA");
	}

	@Test(dataProvider = "data")
	public void TC_AM_EnterVehicleData_009to_013(String n) {

		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		int data = (int) Double.parseDouble(n);
		String passingData = Integer.toString(data);
		enterVehicleData.getEnginePerformanceTextField().clear();
		enterVehicleData.getEnginePerformanceTextField().sendKeys(passingData);
		explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getIconEnginePerformanceLabel()));
		Assert.assertEquals(enterVehicleData.getIconEnginePerformanceLabel().getCssValue("background-position"),
				DataReader.fromPropertyFile("tickBackPosition"), "Positive data" + passingData + "is not acepted");
	}
}