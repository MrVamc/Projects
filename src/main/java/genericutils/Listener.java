package genericutils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener{


	@Override
	public void onTestStart(ITestResult result) {
	 String testcaseName = result.getName();
		Reporter.log("Test Case Started " + testcaseName, true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testcaseName = result.getName();
		Reporter.log("Test Case Success " + testcaseName, true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcaseName = result.getName();
		Reporter.log("Test Case Failure " + testcaseName, true);
		
		TakesScreenshot ss = (TakesScreenshot)BaseClass.driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File des = new File("./folder/p1.png");
		try {
			com.google.common.io.Files.copy(src, des);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testcaseName = result.getName();
		Reporter.log("Test Case Skipped " + testcaseName, true);
	}

	@Override
	public void onStart(ITestContext context) {
		String testcaseName = context.getName();
		Reporter.log("Test Case Start " + testcaseName, true);
	}

	@Override
	public void onFinish(ITestContext context) {
		String testcaseName = context.getName();
		Reporter.log("Test Case Finish " + testcaseName, true);
	}
	

}
