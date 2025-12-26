package generic_libraries;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pom_class.HomePage;
import pom_class.LoginPage;

public class BaseClass {

public	DatabaseUtils dLib = new DatabaseUtils();
public	FileUtils fLib = new FileUtils();
public ExcelUtils eLib = new ExcelUtils();
public JavaUtils jLib = new JavaUtils();
public WebDriverUtils wLib = new WebDriverUtils();  //make public to access below
	 
	public  WebDriver driver ;
	public static WebDriver sdriver;  //we can with class name, so made variable as static
	
	//for parallel exceution Listeners
	public static ThreadLocal<WebDriver> extentTest = new  ThreadLocal<WebDriver>(); //if we use this now this line nor required -public static WebDriver sdriver; 
	
	 @BeforeSuite(alwaysRun = true)    //no need to do chnages again and agian    //connect to db
	// @BeforeSuite(groups= {"smoke","regression"})  //in test scripts its mandatory
	public void connectToDB() throws SQLException
	{
		//dLib.connectToDB(); // if we have created Database dont comment it 
		//	dLib.connectToDB(); //if not created database then comment it
		System.out.println("--connected to DB-----");
		
	}
	 
	 @Parameters("BROWSER")   //pass key inisde parameter(key) //BROWSER is key 	
	 
	 @BeforeClass(alwaysRun = true)   //to luanch browser
//	 @BeforeClass(groups= {"smoke","regression"})
	 
//	public void launchBrowser(String BROWSER) throws IOException
	 //NOTE:  //@Parameters is mandatorty to use @Optional
	public void launchBrowser(@Optional("chrome")String BROWSER) throws IOException  //if we are not changing browser names in suite file/class  chnage here only  
	
	{
		 
//		 String BROWSER = fLib.readDataFromPropertFile("browser");  //to generise all browser
		String URL = fLib.readDataFromPropertFile("url");
	
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}

	//	WebDriver.set   //setters  //for SCreenshot in Listenaers
		sdriver = driver;  //for SCreenshot in Listenaers
		
		
		//Utilityclass.setvalue(driver);  --extentvalue
		
		
		
		
		//maimize window
		wLib.maximizeWindow(driver);
		
		//navigate to appln
		driver.get(URL);
		
		//wait for page load
		wLib.waitForPageLoad(driver, 12);
		
		System.out.println("--browser launched successfully--");
	}
	
	 @BeforeMethod(alwaysRun = true)   //to login to application
	// @BeforeMethod(groups= {"smoke","regression"})
	public void loginToAppln() throws IOException
	{
		String USERNAME = fLib.readDataFromPropertFile("username");
		String PASSWORD = fLib.readDataFromPropertFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("--logged into applicatn--");
		
	}
	
	 @AfterMethod(alwaysRun = true)   //logout from the application
	//@AfterMethod(groups= {"smoke","regression"})
	public void logoutFromAppln()
	{
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
	//hp.signOut(wLib, driver);
	 System.out.println("--connect to DB--");
	}
	
	 @AfterClass(alwaysRun = true)   //close browser 
//	@AfterClass(groups= {"smoke","regression"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("--browser closed--");
	}
	 
	 @AfterSuite(alwaysRun = true)  //disconnect from dB
//	@AfterSuite(groups= {"smoke","regression"})
	public void disconnectFromDB() throws SQLException
	{
		//dLib.disconnectDB();
//		dLib.connectToDB(); //if not created database then comment it
		System.out.println("--disconnected from DB--");
	}
	
	
}
