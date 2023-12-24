package com.tutorialNinja.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportss {
	
	public static ExtentReports genrateExtentReports() {
		
		ExtentReports exReport = new ExtentReports();
		File extentReportFile =  new File(System.getProperty("user.dir")  +"\\test-output\\ExtentReports\\ExtentReport.html");
		ExtentSparkReporter esr  =new  ExtentSparkReporter(extentReportFile);
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("TutorialNinja TestAutomation Results");
		esr.config().setDocumentTitle("TN Automation Report");
		esr.config().setTimeStampFormat("dd/MM/yyy hh::mm::ss");
		
		exReport.attachReporter(esr);
		
		Properties prop1 = new Properties();
		File file2 = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties" );
	    try {
	        	FileInputStream fis1 = new FileInputStream(file2);
	        	prop1.load(fis1);
	    }catch(Throwable e) {
	    	e.printStackTrace();
	    }
         		
		exReport.setSystemInfo("Application URL", prop1.getProperty("url"));
		exReport.setSystemInfo("BroserName",prop1.getProperty("browser"));
		exReport.setSystemInfo("email", prop1.getProperty("validEmail"));
		exReport.setSystemInfo("password",prop1.getProperty("validPasswoord"));
		exReport.setSystemInfo("Java version",prop1.getProperty("java.version"));
		exReport.setSystemInfo("user name",prop1.getProperty("user.name"));
		return exReport;
		
	}

}
