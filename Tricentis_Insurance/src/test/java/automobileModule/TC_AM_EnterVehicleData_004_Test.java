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
import pom.*;


public class TC_AM_EnterVehicleData_004_Test extends BaseClass {
	//To check when user select any options of Make dropdown corresponding option is selected(Positive Datas)
	@Test
	public void TC_AM_EnterVehicleData_004() {
		Reporter.log("TC_AM_EnterVehicleData_004_Test", true);
		TricentisHomePage tricentisHomePage = new TricentisHomePage(driver);
		tricentisHomePage.navigateToAutomobile();
		AMVehicleData enterVehicleData = new AMVehicleData(driver);
		Select select = new Select(enterVehicleData.getMakeDropdown());
		List<WebElement> makeOptions = select.getOptions();
		makeOptions.remove(0);
		for(WebElement e:makeOptions) { 
			select.selectByVisibleText(e.getText());
			Assert.assertEquals(select.getFirstSelectedOption().getText().toString(), e.getText(), "Dropdown selected options mismatched");
			Reporter.log(select.getFirstSelectedOption().getText().toString(),true);
			explicitwait.until(ExpectedConditions.visibilityOf(enterVehicleData.getIconmMakeDropdown()));
			Assert.assertEquals(enterVehicleData.getIconmMakeDropdown().getCssValue("background-position"),DataReader.fromPropertyFile("tickBackPosition"),"Positive data"+e.getText() +"is not acepted");
			Reporter.log( "Make dropdown option "+e.getText()+ " is accepted and tick icon is displayed successfully",true);
		}
	}
}
