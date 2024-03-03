package genericutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
public Reusable re;
public static WebDriver driver;
@BeforeSuite
public void bs()
{
	System.out.println("Extra Cofiguration conected");
}
@BeforeClass
public void OpenChrome() throws Throwable {
	re = new Reusable();
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(re.PropertyFetch(Iconstant.orghrm, "url"));
	

}
@BeforeMethod
public void Login() throws Throwable {
	try {
		driver.findElement(By.name("username")).sendKeys(re.PropertyFetch(Iconstant.orghrm,"user"),Keys.TAB,re.PropertyFetch(Iconstant.orghrm,"pwd"),Keys.ENTER);
	}
	catch (Exception e) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(re.PropertyFetch(Iconstant.orghrm,"user"),Keys.TAB,re.PropertyFetch(Iconstant.orghrm,"pwd"),Keys.ENTER);
	}
	
}
@AfterMethod
public void Logout() throws Throwable {
	WebElement ele = driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']"));
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
	ele.click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	
}
@AfterClass
public void CloseChrome() {
	driver.close();
	System.out.println("Closed");
}
@AfterSuite
public void as() {
	System.out.println("Extra Configuration disconnected");
}

}
