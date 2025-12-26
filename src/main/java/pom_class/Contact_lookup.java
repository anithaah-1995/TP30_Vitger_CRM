package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_lookup {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement contactsLookUpImg;
	
	
	
	public WebElement getContactLookUp() {
		return contactsLookUpImg;
	}


//Innitialization
	public Contact_lookup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business logic
	public void cliclkOnContactsLookup()
	{
		contactsLookUpImg.click();
	}
	
	
	
	
}
