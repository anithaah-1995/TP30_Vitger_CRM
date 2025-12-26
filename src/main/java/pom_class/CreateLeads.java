package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeads {
	//declaration
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getCompany() {
		return company;
	}


	public WebElement getSave() {
		return save;
	}


	@FindBy(name="company")   //check this
	private WebElement company;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	
	//initialization
		public CreateLeads(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		
		public void leaddata(String lastna,String comname) {
			lastname.sendKeys(lastna);
			company.sendKeys(comname);
			save.click();
}
}