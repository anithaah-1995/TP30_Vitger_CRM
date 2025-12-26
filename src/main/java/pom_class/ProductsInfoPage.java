package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement prdtInfo;

public ProductsInfoPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public WebElement getprdtInfo() {
	return prdtInfo;
}
//buisness logic

public void productInfo(String prdt) {
String actual=prdtInfo.getText();
if(actual.contains(prdt)){
	System.out.println("Products created sucessfully");
}
else {
	System.out.println("Products is not created");
	
	}
	}
}
