package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadInfo;

public LeadsInfoPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public WebElement getleadInfo() {
	return leadInfo;
}
//Business logic

public void LeadsInfo(String lead) {
String actual=leadInfo.getText();
if(actual.contains(lead)){
	System.out.println("Leads created sucessfully");
}
else {
	System.out.println("Leads is not created");
}
}
}
