package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMVehicleData {
	public AMVehicleData(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnterVehicleDataNavBar() {
		return enterVehicleDataNavBar;
	}
	
	public WebElement getEnterVehicleDataNumMandatoryFileds() {
		return enterVehicleDataNumMandatoryFileds;
	}

	public WebElement getMakeDropdownLabel() {
		return makeDropdownLabel;
	}

	public WebElement getMakeDropdown() {
		return makeDropdown;
	}

	public WebElement getMakeDropdownOptions() {
		return makeDropdownOptions;
	}

	public WebElement getMsgOfMakeDropdown() {
		return msgOfMakeDropdown;
	}

	public WebElement getEnginePerformanceLabel() {
		return enginePerformanceLabel;
	}

	public WebElement getEnginePerformanceTextField() {
		return enginePerformanceTextField;
	}

	public WebElement getMsgOfEnginePerformance() {
		return msgOfEnginePerformance;
	}

	public WebElement getDateOfManufactureInputField() {
		return dateOfManufactureInputField;
	}

	@FindBy(id = "entervehicledata")
	private WebElement enterVehicleDataNavBar;

	@FindBy(xpath = "//a[@id='entervehicledata']//span")
	private WebElement enterVehicleDataNumMandatoryFileds;

	@FindBy(xpath = "//select[@id='make']/..//label")
	private WebElement makeDropdownLabel;

	@FindBy(id = "make")
	private WebElement makeDropdown;
	
	
	@FindBy(xpath = "//select[@id='make']/..//i")
	private WebElement iconmMakeDropdown;
	
	@FindBy(xpath = "//input[@id='engineperformance']/..//i")
	private WebElement iconEnginePerformanceLabel;
	
	@FindBy(xpath = "//input[@id='engineperformance']/..//span")
	private WebElement errorMsgEnginePerformance;

	public WebElement getErrorMsgEnginePerformance() {
		return errorMsgEnginePerformance;
	}

	public WebElement getIconmMakeDropdown() {
		return iconmMakeDropdown;
	}

	public WebElement getIconEnginePerformanceLabel() {
		return iconEnginePerformanceLabel;
	}

	@FindBy(xpath = "//select[@id='make']//option")
	private WebElement makeDropdownOptions;
	
	public WebElement getAutomobileInsurancePageConfirm() {
		return automobileInsurancePageConfirm;
	}

	@FindBy(xpath = "//span[text()='Automobile Insurance']")
	private WebElement automobileInsurancePageConfirm;

	@FindBy(xpath = "//select[@id='make']/..//span")
	private WebElement msgOfMakeDropdown;

	////////////

	@FindBy(xpath = "//input[@id='engineperformance']/..//label")
	private WebElement enginePerformanceLabel;

	@FindBy(id = "engineperformance")
	private WebElement enginePerformanceTextField;

	@FindBy(xpath = "//input[@id='engineperformance']/..//span")
	private WebElement msgOfEnginePerformance;

	////////////

	@FindBy(id = "dateofmanufacture")
	private WebElement dateOfManufactureInputField;

	/*
	 * //dateofmanufacture
	 * |//span[text()='January']/..//span[text()='2023']/../../..//a[text()='18']
	 */

}
