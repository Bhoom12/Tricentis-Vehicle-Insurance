package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMInsurantData {
	public AMInsurantData(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@id='gendermale']/../../..//label)[1]")
	private WebElement genderLabelRadioButton;
	
	
	@FindBy(xpath = "//input[@id='genderfemale']/..//span")
	private WebElement femaleCheckedRadioButton;
	
	@FindBy(xpath = "//input[@id='gendermale']/..//span[contains(@class,'radio checked')]")
	private WebElement maleCheckedRadioButton;
	
	public WebElement getFemaleCheckedRadioButton() {
		return femaleCheckedRadioButton;
	}

	public WebElement getMaleCheckedRadioButton() {
		return maleCheckedRadioButton;
	}

	@FindBy(xpath = "//input[@id='gendermale']/..")
	private WebElement maleLabelRadioButton;
	
	@FindBy(xpath = "//input[@id='genderfemale']/..")
	private WebElement femaleLabelRadioButton;
	
	public WebElement getMaleLabelRadioButton() {
		return maleLabelRadioButton;
	}

	public WebElement getFemaleLabelRadioButton() {
		return femaleLabelRadioButton;
	}

	@FindBy(id = "enterinsurantdata")
	private WebElement enterInsurantDataPage;

	@FindBy(id = "gendermale")
	private WebElement maleRadioButton;

	@FindBy(id = "genderfemale")
	private WebElement femaleRadioButton;

	@FindBy(xpath = "(//input[@id='speeding']/../../..//label)[1]")
	private WebElement hobbiesLabelCheckbox;
	
	@FindBy(id = "speeding")
	private WebElement speedingCheckbox;
	
	@FindBy(id = "bungeejumping")
	private WebElement bungeejumpingCheckbox;
	
	@FindBy(id = "cliffdiving")
	private WebElement cliffdivingCheckbox;
	
	@FindBy(id = "skydiving")
	private WebElement skydivingCheckbox;
	
	@FindBy(id = "other")
	private WebElement otherCheckbox;

	public WebElement getGenderLabelRadioButton() {
		return genderLabelRadioButton;
	}

	public WebElement getEnterInsurantDataPage() {
		return enterInsurantDataPage;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getHobbiesLabelCheckbox() {
		return hobbiesLabelCheckbox;
	}

	public WebElement getSpeedingCheckbox() {
		return speedingCheckbox;
	}

	public WebElement getBungeejumpingCheckbox() {
		return bungeejumpingCheckbox;
	}

	public WebElement getCliffdivingCheckbox() {
		return cliffdivingCheckbox;
	}

	public WebElement getSkydivingCheckbox() {
		return skydivingCheckbox;
	}

	public WebElement getOtherCheckbox() {
		return otherCheckbox;
	}
	
	
}
