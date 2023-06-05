package Com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.Actitime.Pom.LoginPage;

public class BaseClass {
	FileLibrary fl= new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void DatabaseConnection() {
		Reporter.log("Database is connected",true);
		
	}
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actitimeurl = fl.readDataFromPropertyFile("url");
		driver.get(actitimeurl);
		Reporter.log("Browser is launched",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String un = fl.readDataFromPropertyFile("username");
		lp.getUntbx().sendKeys(un);
		
		String psw = fl.readDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(psw);
		
		lp.getLgbtn().click();
		
	Reporter.log("Login successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out",true);

	}
	@AfterClass
	public void BrowsClosed() {
		driver.close();
		Reporter.log("Browser closed",true);
	}
	@AfterSuite
	public void DatabaseDisconnected() {
		Reporter.log("Database Disconnected",true);
	}
	}



