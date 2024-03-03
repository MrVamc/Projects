package admin;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericutils.BaseClass;

@Listeners(genericutils.Listener.class)
public class tc1 extends BaseClass {

@Test 

public void m1() {
	try {
	driver.findElement(By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();
	driver.findElement(By.xpath("//span[text()='Admin']")).click();
	}
	catch (Exception e) {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
	}
}
}
