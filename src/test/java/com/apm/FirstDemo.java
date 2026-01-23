package com.apm;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class FirstDemo {
	AndroidDriver driver;
	@BeforeClass
	public void base() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("tanvi");
		options.setApp("D:\\Selenium\\apk file\\ApiDemos-debug.apk");
//		options.setApp("D:\\Selenium\\apk file\\General-Store.apk");
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		 //implicit wait
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	public void seekBar(WebElement seekBar) {
		int xStart = seekBar.getLocation().getX();
		int width = seekBar.getSize().getWidth();
		int yCenter = seekBar.getLocation().getY() + (seekBar.getSize().getHeight() / 2);
		// Start at the middle (50%)
		int startX = xStart + (width / 2);
		// FIX: Move to 20% of the bar's width instead of the absolute 0%
		int endX = xStart + (int)(width * 0.70);
		// 2. Define the Sequence
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragLeft = new Sequence(finger, 1);
		// Move to start position
		dragLeft.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), startX, yCenter));
		// Press down
		dragLeft.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		// IMPORTANT: Small pause so the slider "grabs" the thumb
		dragLeft.addAction(new Pause(finger, Duration.ofMillis(200)));
		// Move to the new endX (20% mark)
		dragLeft.addAction(finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), endX, yCenter));
		// Release
		dragLeft.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		// 3. Execute
		driver.perform(Collections.singletonList(dragLeft));
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
	
}
