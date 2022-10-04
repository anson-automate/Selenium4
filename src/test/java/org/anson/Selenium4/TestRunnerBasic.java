package org.anson.Selenium4;

import java.awt.RenderingHints.Key;
import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunnerBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("working");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";
		driver.navigate().to(url);
		
		//1. Get current URL
		
		System.out.println("current URL "+driver.getCurrentUrl());
		
		// 2. Get Title
		
		System.out.println("Get Title" +driver.getTitle());
		
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

		driver.close();
		
		driver.quit();

	}

}
