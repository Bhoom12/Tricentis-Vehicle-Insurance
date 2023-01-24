package automobileModule;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataReader;
import pom.*;


public class TC_AM_EnterVehicleData_003_Test extends BaseClass{
	//To check whether make dropdown is multiple dropdown or not
	@Test
	public void TC_AM_EnterVehicleData_003() {
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		Select select = new Select(enterVehicleData.getMakeDropdown());
		Boolean typeOfDropdown=select.isMultiple();
		Reporter.log("Make dropdown is Multiple: "+typeOfDropdown.toString(),true);
	}
}
