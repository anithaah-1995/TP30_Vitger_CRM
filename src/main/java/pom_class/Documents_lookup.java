package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Documents_lookup {
	//declaration
		@FindBy(xpath = "//img[@title='Create Document...']")
		private WebElement lookup;
		
		//initialization
		public Documents_lookup(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		public WebElement getLookup() {
			return lookup;
		}
		//buisness initialization
		public void clickOnDocLookup() {
			lookup.click();
		}
}



