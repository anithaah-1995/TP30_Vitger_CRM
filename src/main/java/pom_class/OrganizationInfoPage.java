package pom_class;

import static org.testng.Assert.assertTrue;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic_libraries.WebDriverUtils;

public class OrganizationInfoPage  extends WebDriverUtils {
	//declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement orgInfo;
		
		public WebElement getOrgInfo() {
			return orgInfo;
		}

		//INITIALization
		public OrganizationInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		public void orgInfoMsg(WebDriver driver, String org1)
		{
			//Assertions
//			waitUntilEleToBeVisible(driver, 10, orgInfo);
			String actual = orgInfo.getText();
//			
//		assertTrue(actual.contains(org1));
			
			if (actual.contains(org1))
			{
				System.out.println("Organization is created successfully");
			}
			else {
				System.out.println("Organization is not created");
			}
		}
		
		
		
		}

