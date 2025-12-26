package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement docInfo;

public DocumentInfoPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getConInfo() {
	return docInfo;
}


//Business logic

public void DocumentInfo(String doc) {
String actual=docInfo.getText();
if(actual.contains(doc)){
	System.out.println("Document created sucessfully");
}
else {
	System.out.println("Document is not created");
}
}
}
