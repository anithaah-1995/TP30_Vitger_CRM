package pom_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_libraries.WebDriverUtils;

public class CreateContactWithMan extends WebDriverUtils {    //for swtichTO wnidow method extend
@FindBy(name="lastname")
private WebElement lastnameEdt;

public WebElement getLastname() {
	return lastnameEdt;
}


@FindBy(xpath = "//input[@name='search_text']")
private WebElement searchTextField; 

public WebElement getSearchTextField() {
	return searchTextField;
}

@FindBy(xpath = "//input[@type='button']")
private WebElement searchNowBtn; 

public WebElement getSearchNowBtn() {
	return searchNowBtn;
}

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;
public WebElement getSave() {
	return saveBtn;
}

@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
private WebElement pluslookup;

public WebElement getPluslookup() {
	return pluslookup;
}



public CreateContactWithMan(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//Bisness logic
public void createContact(WebDriver driver,String contName)
{
	lastnameEdt.sendKeys(contName);
	saveBtn.click();
}
public void createContact(WebDriver driver, String contName, String orgName)
{
	lastnameEdt.sendKeys(contName);
	//dropdownusingContainsVisibleText(lastnameEdt, orgName);
	pluslookup.click();
	String parentwindow = driver.getWindowHandle();
	switchToChildWindows(driver, "Accounts&action");
	searchTextField.sendKeys(orgName);
	searchNowBtn.click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	switchToParentWindows(driver, parentwindow);
	saveBtn.click();
}





}
