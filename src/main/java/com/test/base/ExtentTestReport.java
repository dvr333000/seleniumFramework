package com.test.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestReport {
	static ExtentReports extent;
	
	public static ExtentReports getReport(){
		String reportPath =System.getProperty("user.dir")+"/reports/results.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Automation Suite execution report");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Executed by", System.getProperty("user.name"));
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		
		return extent;
		
	}
}
