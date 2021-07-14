package OpenCart.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import OpenCart.ExtentReports.ExtentReporter;

public class Listeners implements ITestListener {
	ExtentTest test;
	
	ExtentReports extent=ExtentReporter.config();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 test= extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		  test.log(Status.PASS, "success");
	}
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());   
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");

		/*
		 * Object testobject=result.getInstance(); Class
		 * classs=result.getTestClass().getRealClass(); try {
		 * driver=(WebDriver)classs.getDeclaredField("driver").get(testobject); } catch
		 * (Exception e1) { // TODO Auto-generated catch block }
		 */
	        try {
	        	TakeScreenshot.getscreenshotpath(result.getMethod().getMethodName());
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	        }
	        test.log(Status.FAIL, "Test Failed");
	       
			// TODO Auto-generated method stub
		
		
	}
		
	

		
	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
         
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	

}
