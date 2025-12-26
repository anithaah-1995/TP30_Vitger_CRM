package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);

		}
		
	//getters
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Business logic
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
	}
	
	
	
	
	
	
	
	
	//business Logic
	//public void loginToApp()
}
