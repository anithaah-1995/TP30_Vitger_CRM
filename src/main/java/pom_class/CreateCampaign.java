package pom_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_libraries.WebDriverUtils;

public class CreateCampaign extends WebDriverUtils {
	@FindBy(linkText = "More")
	private WebElement More;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignname;

	
	public CreateCampaign(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}


	public WebElement getMore() {
		return More;
	}


	public WebElement getCampaignname() {
		return campaignname;
	}


	public WebElement getSave() {
		return save;
	}

public void campaign_page(String campname) {
	campaignname.sendKeys(campname);
	save.click();
}
}
