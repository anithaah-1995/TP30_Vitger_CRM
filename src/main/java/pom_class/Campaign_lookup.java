package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign_lookup {
	//declaration
		@FindBy(xpath = "//img[@title='Create Campaign...']")
		private WebElement Camplookup;

		//initialization
		public Campaign_lookup(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		public WebElement getLookup() {
			return Camplookup;
		}
		public void clickOnCampLookup() {
			Camplookup.click();
		}
		
}
