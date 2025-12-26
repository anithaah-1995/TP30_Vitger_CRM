package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Documents {
	@FindBy(name="notes_title")
	private WebElement title;

	@FindBy(xpath="//input[@type='file']")
	private WebElement fileupload;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;



	//initialization
	public Documents(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getFileupload() {
		return fileupload;
	}
	public void documentpage(String tile)
	{
		title.sendKeys(tile);
		fileupload.sendKeys("C:\\\\Users\\\\NAGARAJ\\\\Desktop\\\\TekPyramid\\\\ADVANCE SELENIUM\\\\NOTES GIVEN\\\\DataDrivenTesting_new.docx");
		save.click();
	}

}
