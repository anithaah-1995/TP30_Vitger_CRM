package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products_lookup {
	//declaration
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productsLookUp;
	
	public WebElement getProductsLookUp() {
		return productsLookUp;
	}
//initialization
	public Products_lookup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//business logic
	public void clickOnPrdtLookup() {
		productsLookUp.click();
	}
}


