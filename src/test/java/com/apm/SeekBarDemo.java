package com.apm;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SeekBarDemo extends FirstDemo {
	@Test
public void sb() throws InterruptedException {
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.androidUIAutomator
			("new UiScrollable(new UiSelector())"
					+ ".scrollIntoView(text(\"Seek Bar\"));")).click();
	Thread.sleep(2000);
	WebElement seekBar=driver.findElement(By.id("io.appium.android.apis:id/seek"));
		seekBar(seekBar);

}
}
