package pom_class;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import generic_libraries.BaseClass;
import generic_libraries.WebDriverUtils;
@Test
public class CampaignInfoPage extends WebDriverUtils {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement camInfo;

public CampaignInfoPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public WebElement getcamInfo() {
	return camInfo;
}
//Business logic

public void CampaignPage(WebDriver driver,String cam) {
	
	waitUntilEleToBeVisible(driver, 10, camInfo);
String actual=camInfo.getText();
//if(actual.contains(cam)){
//	System.out.println("Campaign created sucessfully");
//}
//else {
//	System.out.println("Campaign is not created");
//}

assertTrue(actual.contains(cam));

}
}
