package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_libraries.WebDriverUtils;

//public class HomePage {
public class HomePage extends WebDriverUtils {
	
	//declaration
	@FindBy(linkText  = "Organizations")
	private WebElement organizationLink;
	
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement oppurtunitiesLink;
	
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLink;
	

	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement more;
	
	@FindBy(name="Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText = "More")
	private WebElement More;
	
	@FindBy(name="Campaigns")
	private WebElement campaignsLink;
	
	//Utilization: making as public     //for Signout
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	//Initialize
	
	public  HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void clickOnOrgLink()
	{
		organizationLink.click();
	}
	public void clickOnContactsLink()
	{
		contactsLink.click();
	}
	public void clickOnOppurLink()
	{
		oppurtunitiesLink.click();
	}
	public void clickOnLeadsLink()
	{
		leadsLink.click();
	}
	public void clickOnProductsLink()
	{
		productsLink.click();
	}
	public void clickOnDocumentsLink()
	{
		documentsLink.click();
	}
	public void clickOnVendorsLink()
	{
		More.click();
		vendorsLink.click();
	}
	public void clickOnCampaignsLink()
	{
		campaignsLink.click();
	}
	public void campaign_page(WebDriver driver) {
		More.click();
		//WebElement camp = driver.findElement(By.xpath("//a[text()='Campaigns']"));
		//mousehoverandclickonEle(driver, camp);
	//	camp.click();
		campaignsLink.click();
	}
	////business logic
	
	//public void signOut(WebDriverUtils wLib,WebDriver driver)  
	public void signOut(WebDriver driver)  //whatevr var u are calling , u have to pass as arguments// no need to give arg here if we are extending from webdriver Utils in mian method//in comments as shown
	{
		administratorImg.click();
		
	//	wLib.mouseHoverAndClickOnEle(driver, signOut);    ///again dont write Actions act = new Actions();
	    mouseHoverAndClickOnEle(driver, signOut);
	    
//	    //for cross browser // comment // mouseHoverAndClickOnEle(driver, signOut); //baseclass  comment //@parameter
//	waitUntilEleToBeVisible(driver, 10, signOut);
//	clickOnElementUsingJSE(driver, signOut);
	    
	    
	}



}
//correct code