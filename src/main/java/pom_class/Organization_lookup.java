package pom_class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_libraries.WebDriverUtils;

public class Organization_lookup extends WebDriverUtils{
	//declaration
		@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement organizationsLookUp;
		
		
		
		@FindBy(xpath = "//table[@class='lvtBg']/descendant::tr[@bgcolor='white']/td/a[@title='Organizations']")
	  //  private WebElementlistOfOrganizations;
		private List<WebElement> listOfOrganizations;
		

		//if any other element if we have taken then include those also, as now n plus image we hvae taken
		//initialization
		public Organization_lookup(WebDriver driver)
		{
			PageFactory.initElements(driver, this);

		}
		
		public WebElement getOrganizationsLookUp() {
			return organizationsLookUp;
		}

		public List<WebElement> getListOfOrganizations() {
			return listOfOrganizations;
		}
		
		
		//business logic
		
		public void clickOnCreateOrgLookupImg()
		{
			organizationsLookUp.click();
		}
		public void getListOfOrgNames()
		{
			for(WebElement orgName : listOfOrganizations) 
			{
				System.out.println(orgName.getText());
			}
		}
}

//correct code