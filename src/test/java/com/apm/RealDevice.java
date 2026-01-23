package com.apm;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class RealDevice {
	@Test
public void device() throws MalformedURLException {
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability("deviceName", "Xiaomi M2006C3LI");
	cap.setCapability("udid","AQLFZ96DCUH6QKKV");
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion", "10.0");
	cap.setCapability( "appPackage","com.miui.calculator");
	cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
	cap.setCapability("automationName", "UIAutomator2");
	URL url=new URL("http://127.0.0.1:4723/");
		
		AppiumDriver driver=new AppiumDriver(url, cap);




	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

}
}
