package Com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.Actitime.GenericLibrary.BaseClass;
import Com.Actitime.GenericLibrary.FileLibrary;
import Com.Actitime.Pom.HomePage;
import Com.Actitime.Pom.Taskpage;

public class CreateCustomer extends BaseClass {
@Test
public void createcustomer() throws EncryptedDocumentException, IOException {
	HomePage hp= new HomePage(driver);
	hp.getTasktab().click();
	Taskpage tp= new Taskpage(driver);
	tp.getAddnewbtn().click();
	tp.getNewcust().click();
	FileLibrary f1=new FileLibrary();
	String cust = f1.readDataFromExelSheet("celebrities", 2, 1);
	tp.getCustname().sendKeys(cust);
	String describtion = f1.readDataFromExelSheet("celebrities",2 , 2);
	tp.getCustdesp().sendKeys(describtion);
	tp.getCreatebtn().click();
	 String expectedresult = cust;
	  String actualresult = driver.findElement(By.xpath("(//div[.='"+cust+"'][2]")).getText();
	  SoftAssert s = new SoftAssert();
	  s.assertEquals(actualresult, expectedresult);
}
}

