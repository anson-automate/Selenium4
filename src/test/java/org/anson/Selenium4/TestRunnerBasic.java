package org.anson.Selenium4;

import java.awt.RenderingHints.Key;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TestRunnerBasic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("working");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		String url = "https://www.google.com/";

		driver.navigate().to(url);

		// 1. Get current URL

		System.out.println("current URL " + driver.getCurrentUrl());

		// 2. Get Title

		System.out.println("Get Title" + driver.getTitle());

		// 3. Forward | Back | Refresh

		driver.navigate().back();

		driver.navigate().forward();

		driver.navigate().refresh();

		// 4. Switching windows (window handle)

		String mainWindow = driver.getWindowHandle();

		System.out.println(mainWindow);

		// 5. Open new Tab
		driver.switchTo().newWindow(WindowType.TAB);

		// 6. Open new window
		driver.switchTo().newWindow(WindowType.WINDOW);

		url = "https://www.google.com/";
		driver.navigate().to(url);

		String secondWindow = driver.getWindowHandle();

		System.out.println(secondWindow);

		// 7. switching windows

		driver.switchTo().window(mainWindow);
		// 8. webelement
		WebElement search = driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));

		// 9. sending text
		search.sendKeys("test");
		// 10. sending keys
		search.sendKeys(Keys.ENTER);

		// 11. maximize window , minimize, full screen
//
//		driver.manage().window().maximize();
//
//		driver.manage().window().minimize();
//
//		driver.manage().window().fullscreen();

		// 12. taking screenshots
		// page level
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshot, new File("./image1.png"));
		// element level
		WebElement gImage = driver.findElement(By.xpath("//*[@id='logo']/img"));

		File screenshot1 = gImage.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshot1, new File("./Image2.png"));

		// 13find elements and frame

		// 14 relative locator sele 4
		// relative element

		driver.navigate().to(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement inputBox = driver.findElement(By.name("q"));

		System.out.println("tagName--" + inputBox.getTagName());

		System.out.println("type-" + inputBox.getAttribute("type"));

		WebElement button = driver.findElement(RelativeLocator.with(By.tagName("input")).below(inputBox));
		// System.out.println("tagName---"+button.getTagName());
		System.out.println("text--" + button.getAttribute("aria-label"));

		WebElement btn1 = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(button));

		System.out.println("text1--" + btn1.getAttribute("aria-label"));
		// linkadd
		// WebElement findEle = driver.findElement(By.id("testId"));
		// tag used to find the type of element
		// driver.findElement(RelativeLocator.with(By.tagName("input")).above(findEle)).sendKeys("elements");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

		driver.quit();

	}

}
