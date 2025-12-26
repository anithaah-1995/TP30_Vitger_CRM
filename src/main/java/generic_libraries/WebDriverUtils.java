package generic_libraries;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	/** Thi method is used to maximize the window
	 * @author NAGARAJ
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		
		driver.manage().window().maximize();
		
	}
	/**
	 * 
	 * @param driver
	 * @param seconds
	 */
	
	
	public void waitForPageLoad(WebDriver driver, int seconds)
	/**This method is used to wait for page load
	 * @author NAGARAJ
	 */
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	/**
	 * This method is used to wait until element is avialble on webpage
	 * @author NAGARAJ
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntilEleToBeVisible(WebDriver driver,int seconds, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		//wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}
	/**
	 * This method is used to wait until element to be clickable
	 * @author NAGARAJ
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	
	public void waitUntilEleToBeclickable(WebDriver driver,int seconds, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
//	 public void dropdownUsingValue(WebElement element, String value) 
//	   {
//		    
//		   Select sel = new Select(element);
//		 sel.selectByValue(value);		   
//	   }
	
//	public void dropdownUsingIndex(WebElement element, int index) 
//	   {
//		    
//		   Select sel = new Select(element);
//		 sel.selectByIndex(index);	 
//	   }
	
	
	//NOTE call dropdownUsingValue and dropdownUsingIndex mthods directly
	
	//to create abject one time instaed for repaeted time // which are there in comments
	/**
	 * Thismethod is used to select dropdown using select class
	 * @author NAGARAJ
	 * @param element
	 * @return
	 */
	public Select dropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel;
	}
//	
	/**
	 * This method is used to select element using dropdown by selectByValue
	 * @param element
	 * @param value
	 */
   public void dropdownUsingValue(WebElement element, String value) 
   {
	  
   dropdown(element).selectByValue(value);
   }
   /**
    *  This method is used to select element in dropdown using index by selectByIndex
    * @param element
    * @param index
    */
   public void dropdownUsingIndex(WebElement element, int index) 
   {	 
	 dropdown(element).selectByIndex(index);
   }
/**
 *  This method is used to select element in dropdown by selectByVisibleText
 * @param element
 * @param text
 */
   public void dropdownusingVisibleText(WebElement element, String text)
   {
	   dropdown(element).selectByVisibleText(text);
	   
   }
 //NOTE:   Call dropdownUsingIndex, dropdownUsingValue and dropdownusingVisibleText methods not dropdown method
  
   //addtionall method added
   public void dropdownusingContainsVisibleText(WebElement element, String text)
   {
	   dropdown(element).selectByContainsVisibleText(text);
   }
   
   //Actions class
   /**
    * This method is used for Actions class create object of Actions class
    * @param driver
    * @return
    */
   public Actions actions(WebDriver driver)
   {
	   Actions act = new Actions(driver);
	   return act;
	   
   }
   /**
    * This method is used to mouseOver on the Elements
    * @param driver
    * @param element
    */
   public void mouseHover(WebDriver driver, WebElement element)
   {
	   actions(driver).moveToElement(element).perform();
   }
   /**
    * This method is used to mouseHover the element and click on the element
    * @param driver
    * @param element
    */
   public void mouseHoverAndClickOnEle(WebDriver driver, WebElement element)
   {
	   actions(driver).moveToElement(element).click(element).perform();
   }
   /**
    * This method is used to drag the element from one place to another place (from source to destination)
    * @param driver
    * @param src
    * @param dst
    */
   public void dragAndDrop(WebDriver driver, WebElement src,WebElement dst)
   {
	   actions(driver).dragAndDrop(src, dst).perform();
   }
 /**
  * This method is used to scroll the page upto one Web element by scrollWebElement Method
  * @param driver
  * @param element
  */
   public void scrollWebElement(WebDriver driver,WebElement element  )
	  { 
actions(driver).scrollToElement(element).perform();

	  }
   /**
    * This method is used to scroll the WebPage   with X and Y coordinates using scrollByAmount
    * @param driver
    * @param x
    * @param y
    */
  public void scrollWebPage(WebDriver driver, int x, int y)
		  { 
	  actions(driver).scrollByAmount(x, y).perform(); 
	  
		  }
  /**
   * This method is used to doubleClick on the page 
   * @param driver
   */
  public void doubleClick(WebDriver driver)  //double lcick on page
  {
	  actions(driver).doubleClick().perform();  
  }
  /**
   * This method is used to doubleClick on the Web element
   * @param driver
   * @param element
   */
  public void doubleClickOnElement(WebDriver driver,WebElement element)  ////double click on element
  {
	  actions(driver).doubleClick(element).perform();  
  }
  /**
   *This method is used to right ClickOn the WebPage
   * @param driver
   */
  //rightClick  //chcek
  public void rightClickOnWebPage(WebDriver driver)
  {
	  actions(driver).contextClick().perform();
  }
  /**
   * *This method is used to right ClickOn the Web element
   * @param driver
   * @param element
   */
  public void rightClickOnEle(WebDriver driver,WebElement element)
  {
	  actions(driver).contextClick(element).perform();
  }
  /**
   * *This method is used to click and hold the element simultaneously
   * @param driver
   * @param element
   */
  public void clickAndHold(WebDriver driver,WebElement element)
  {
	  actions(driver).clickAndHold(element).perform();
  }
  /**
   * This method is used to click and hold the element and the release the element
   * @param driver
   * @param element
   */
  //clcikHoldAndRelease
  public void clcikHoldAndRelease(WebDriver driver,WebElement element)
  {
	  actions(driver).clickAndHold(element).release().perform();
  }
  
   //dragAndDrop
   //dragAndDrop
   //ScrooltoEle
   //doubleclick
   //rightclick
   //clcikandHold
   //clcikHoldAndRelease
   /**
    * This method is used to switch from current window To ChildWindows
    * @param driver
    * @param expTitle
    */
   public void switchToChildWindows(WebDriver driver,String expTitle)
   {
	   String parent = driver.getWindowHandle();
	   Set<String> windows = driver.getWindowHandles();
	   Iterator<String> it = windows.iterator();   
   
       while(it.hasNext())
       {
    	   String currentWin = it.next();
    	
		String actualTitle = driver.switchTo().window(currentWin).getTitle();
    	   if(actualTitle.contains(expTitle))
    	   {
    		   break;
    	   }
    	   
       }
   
   
   }
   
   /**
    * This method is used to switch from current window To parent window
    * @param driver
    * @param ParentID
    */
   public void switchToParentWindows(WebDriver driver, String ParentID)
   {
	   driver.switchTo().window(ParentID);
   }
   
   //frames
   
   /**
    *  This method is used to switch current frame to ChildFrame using index
    * @param driver
    * @param index
    */
   
   public void switchToChildFrame(WebDriver driver, int index)
   {
	   driver.switchTo().frame(index);
   }
   /**
    * *  This method is used to switch current frame to ChildFrame using name
    * @param driver
    * @param index
    */
   public void switchToChildFrame(WebDriver driver, String name)
   {
	   driver.switchTo().frame(name);
   }
   /**
    *  This method is used to switch current frame to ChildFrame using element
    * @param driver
    * @param element
    */
   public void switchToChildFrame(WebDriver driver, WebElement element)
   {
	   driver.switchTo().frame(element);
   }
   /**
    *  This method is used to switch current frame to ParentFrame
    * @param driver
    */
   public void switchToParentFrame(WebDriver driver)
   {
	   driver.switchTo().parentFrame();
   }
   /**
    * This method is used to switch current frame to MainFrame
    * @param driver
    */
   public void switchToMainFrame(WebDriver driver)
   {
	   driver.switchTo().defaultContent();
   }
   /**
    *  This method is used to accept the pop up 
    * @param driver
    */
   //alert popup
   public void acceptAlertPopup(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   /**
    * This method is used to dismiss the pop up 
    * @param driver
    */
   public void cancelAlertPopup(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   /**
    * This method is used to print the  text in the ppop up
    * @param driver
    */
   public void getTextFromAlertPopup(WebDriver driver)
   {
	   driver.switchTo().alert().getText();    // we can store in variable and we get get the text
   }
   /**
    * This method is used to enter text field  in the ppop up
    * @param driver
    * @param value
    */
   public void enterValueIntoAlertPopupTextField(WebDriver driver, String value)
   {
	   driver.switchTo().alert().sendKeys(value);
   }
   /** This method is used to create object
    * 
    * @param driver
    * @return
    */
   
   //javaScriptExceutor methods
   public JavascriptExecutor javaScriptExecutor(WebDriver driver)
   {
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  return js;
   }
   
   /**
    * This method is used to scroll till bottom of the page
    * @param driver
    */
   public void scrollHeight(WebDriver driver)
   {
	   javaScriptExecutor(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
   }
   
   /**
    * This method is used to scroll page till web element
    * @param driver
    * @param element
    */
   //scrollToElement
   public void scrollUntilEleVisibleUsingJSE(WebDriver driver, WebElement element)
   
   {
	   javaScriptExecutor(driver).executeScript("arguments[0].scrollIntoView()", element);
	   
   }
   /**
    * This method is used to clcik on the element using JSE without select tag
    * @param driver
    * @param element
    */
  // click on Element  //if actions class is not wroking
   public void clickOnElementUsingJSE(WebDriver driver, WebElement element)
   {
	   javaScriptExecutor(driver).executeScript("arguments[0].click()", element);
	   
   }
   /**
    * This method is used to enter into text filed using sendkeys
    * @param driver
    * @param element
    * @param value
    */
   //sendkeys
   public void enterValueIntoTextFieldUsingJSE(WebDriver driver, WebElement element, String value)
   {
	   javaScriptExecutor(driver).executeAsyncScript("arguments[0].value=arguments[1]", element, value);
   }
   /**This method is used to scroll to the particular element using X and Y coordinates
    * 
    * @param driver
    * @param element
    */
   public void scrollToEleUsingXYCoOrdinate(WebDriver driver, WebElement element)
   {
	 Point loc = element.getLocation();
	 int x=loc.getX();
	 int y=loc.getY();
	 javaScriptExecutor(driver).executeScript("window.scrollBy("+x+","+y+")");
   }
   
   
   //Ex:- elemnet user name//value is admin
   
   
   //hasNext()=----->are there any next windows
} 

//Q: How u used OOPS in ur framework-OOPS concept-used here --> handling dropdowns, handling frames, performing actions, 