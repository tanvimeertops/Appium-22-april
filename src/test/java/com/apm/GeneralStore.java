package com.apm;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class GeneralStore extends FirstDemo {

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("com.androidsample"
				+ ".generalstore:id/spinnerCountry")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector())"
						+ ".scrollIntoView(text(\"Bhutan\"));")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
		.sendKeys("tops");
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore"
				+ ":id/radioFemale"))
		.click();
		
	}
	
	
	
	
}
