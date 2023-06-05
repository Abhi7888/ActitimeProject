package Com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//Declaration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath ="//div[.='Reports']" )
	private WebElement reportstab;
	
	@FindBy(xpath ="//div[.='Users']" )
	private WebElement userstab;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutlink;
	
	
//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization
	public WebElement getTasktab() {
		return tasktab;
	}


	public WebElement getReportstab() {
		return reportstab;
	}


	public WebElement getUserstab() {
		return userstab;
	}


	public WebElement getLogoutlink() {
		return logoutlink;
	}
	

	
}
