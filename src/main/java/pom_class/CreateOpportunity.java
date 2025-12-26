package pom_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_libraries.WebDriverUtils;

public class CreateOpportunity extends WebDriverUtils {

	@FindBy(name="potentialname")
	private WebElement OpprName;
	
	public WebElement getOpprName() {
		return OpprName;
	}

	@FindBy(xpath = "//input[@id=\"related_to_display\"]/following-sibling::img")
	private WebElement OppurLookUpimage;
	
	public WebElement getOppurLookUpimage() {
		return OppurLookUpimage;
	}
	
	@FindBy(xpath =  "//input[@id=\"search_txt\"]")
	private WebElement searchTextField; 

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchNowBtn; 
	
	public WebElement getSave() {
		return save;
	}

	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save; 
	
	public CreateOpportunity(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business logic
	public void opportunityPage(WebDriver driver,String expoppName, String existingOrg ) {
		
		OpprName.sendKeys(expoppName);
		String parentwindow = driver.getWindowHandle();
		OppurLookUpimage.click();
		switchToChildFrame(driver, "Accounts&action");
		
		searchTextField.sendKeys(existingOrg);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[.='"+existingOrg+"']")).click();
		switchToParentWindows(driver, parentwindow);
		save.click();
	}
}
