package org.anson.Selenium4;

import java.awt.RenderingHints.Key;
import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

		String mainWindow = driver.getWindowHandle();

		System.out.println(mainWindow);

		driver.switchTo().newWindow(WindowType.TAB);

		url = "https://www.google.com/";
		driver.navigate().to(url);

		String secondWindow = driver.getWindowHandle();

		System.out.println(secondWindow);

		driver.switchTo().window(mainWindow);

		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("test");
		
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);		
		driver.navigate().refresh();

		// driver.close();

	}

}
