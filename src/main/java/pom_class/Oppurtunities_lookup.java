package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oppurtunities_lookup {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement oppurtunitiesLookUp;

	public WebElement getOppurtunitiesLookUp() {
		return oppurtunitiesLookUp;
	}

	public Oppurtunities_lookup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnLookup() {
		oppurtunitiesLookUp.click();
	}
}



