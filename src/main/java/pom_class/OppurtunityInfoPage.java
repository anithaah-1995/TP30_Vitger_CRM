package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppurtunityInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement opprtInfo;

public  OppurtunityInfoPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getopprtInfo() {
	return opprtInfo;
}


//Business logic

public void oppurtunityInfo(String oppurt) {
String actual=opprtInfo.getText();
if(actual.contains(oppurt)){
	System.out.println("Oppurtunity created sucessfully");
}
else {
	System.out.println("Oppurtunity is not created");
}
}

}
