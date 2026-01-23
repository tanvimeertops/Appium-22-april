package com.apm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPressDemo extends FirstDemo {

	@Test
	public void lp() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists"))
		.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"))
		.click();
		//class_value[@text='text_value']
	 WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	 	Thread.sleep(2000);
	 	longPressAction(ele);
	 	Thread.sleep(2000);
	 	String res=driver.findElement(By.id("android:id/title")).getText();
	 	Assert.assertEquals("Sample menu", res);
	}
}
