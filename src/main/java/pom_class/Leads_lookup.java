package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads_lookup {
	//declaration
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement leadsLookUp;
	
	public WebElement getLeadsLookUp() {
		return leadsLookUp;
	}

		//initialization
		public Leads_lookup(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}


		public void clickOnLookup() {
			leadsLookUp.click();
		}
}

