package BaseTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


class ExtendClass {
	private static ExtentReports extent;
	public static ExtentReports getInstance(String fileName){
	    if(extent == null){
	        extent = new ExtentReports(fileName, true, DisplayOrder.NEWEST_FIRST);
	        //Loading Config File for Report
	        extent.loadConfig(new File(System.getProperty("user.dir")+"//reportConfig.xml"));
	    }

	    return extent;
	}

}
