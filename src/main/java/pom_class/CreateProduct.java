package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_libraries.WebDriverUtils;

public class CreateProduct extends  WebDriverUtils {
	
	
	@FindBy(name="productname")
	private WebElement prodname;
	
	@FindBy(name= "productcategory")
	private WebElement prodCategory;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	public WebElement getProdname() {
		return prodname;
	}

	public WebElement getProdCategory() {
		return prodCategory;
	}

	public WebElement getSave() {
		return save;
	}

	
	
	//initialization
	public CreateProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void Productsdetails(String pname,String PDD) {
		prodname.sendKeys(pname);
		dropdownusingContainsVisibleText(prodCategory, PDD);
		save.click();
	}
}
