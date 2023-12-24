package com.tutorialNinja.qa.listnerss;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialNinja.Utils.ExtentReportss;

import java.awt.Desktop;
import java.io.*;

public class MyListners implements ITestListener {

	ExtentReports extentReport1 ;
	ExtentTest extentTest;
	@Override
	public void onStart(ITestContext context) {
		
			 extentReport1 = ExtentReportss.genrateExtentReports();
	}
	@Override
	public void onTestStart(ITestResult result) {
	String testName = result.getName();
    extentTest = extentReport1.createTest(testName);
	extentTest.log(Status.INFO,"started executing"  +  testName );
// 	System.out.println("started executing"  +  testName  );
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
	extentTest.log(Status.PASS,testName + "gotSuccessfullyExecuted");

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		 WebDriver driver=null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        File srcShot =         ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        
		        String destinationScreenShotPath  =  System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
		        try {
					FileHandler.copy(srcShot, new File(destinationScreenShotPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        extentTest.addScreenCaptureFromPath(destinationScreenShotPath);
	//	System.out.println("screenshot taken"); 
		        extentTest.log(Status.INFO,result.getThrowable());
		        extentTest.log(Status.FAIL, testName + "got Failled");
	//	System.out.println(result.getThrowable());
	//	System.out.println(testName + "got Failled");


			
		}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		String testName = result.getName();
		 extentTest.log(Status.INFO,result.getThrowable());
		 extentTest.log(Status.SKIP,testName + " got Skipped");
	
		
			
		}
	 

	

	@Override
	public void onFinish(ITestContext context) {
		extentReport1.flush();
		
		String pathOfExtentReport = System.getProperty("system.dir") +"\\test-output\\ExtentReports\\ExtentReport.html";
		File extentReport1  =new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport1.toURI());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	

}
 	   