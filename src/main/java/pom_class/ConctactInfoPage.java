package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConctactInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement conInfo;
	
	public ConctactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getconInfo() {
		return conInfo;
	}
	//Business logic

		public void ContactInfo(String con) {
		String actual=conInfo.getText();
		if(actual.contains(con)){
			System.out.println("Contacts created sucessfully");
		}
		else {
			System.out.println("contacts is not created");
		}
		}
}
