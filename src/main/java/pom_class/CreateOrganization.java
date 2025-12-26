package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_libraries.WebDriverUtils;

public class CreateOrganization extends WebDriverUtils  {
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryEle;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn; 


	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getIDD() {
		return industryEle;
	}
		public WebElement getSave() {
		return saveBtn;
	}

	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//business logic
	public void createOrganization(String orgN)  //orgN is var which was there in TEst SCript
	{
		orgName.sendKeys(orgN);
		saveBtn.click();
	}
	public void createOrganization(String orgN, String indText)
	{
		orgName.sendKeys(orgN);
	dropdownusingContainsVisibleText(industryEle, indText);
	saveBtn.click();
	}
	
	//utilization
	
	//signOut writerrn in Home page , so here not required
	
}
//coreect code

//NOTE:
//enacpsulation making element as privtae
//abstraction by hiding implementation in POM class
//How method overloading into ur framework - i)POM Class and (all implemention doing in POM class itself, we are creating same method name , by passing diff arguemnts
                                        //ii)