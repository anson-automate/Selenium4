package org.anson.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {

		/// System.setProperty("webdriver.chrome.driver", "C://Selenium-java
		/// browserstack//chromedriver_win32//chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();

		dr.navigate().to("https://trytestingthis.netlify.app/");

		WebElement dropDn = dr.findElement(By.id("option"));

		Select selObj = new Select(dropDn);

		// Selecting an option in drop down
		selObj.selectByIndex(1);

		Thread.sleep(2000);

		selObj.selectByValue("option");

		Thread.sleep(2000);

		selObj.selectByVisibleText("Option 3");

		WebElement dropList = dr.findElement(By.id("owc"));

		Select selNew = new Select(dropList);

		selNew.selectByIndex(1);

		Thread.sleep(2000);

		selNew.selectByValue("option 3");

		Thread.sleep(2000);

		// De selecting an option in drop down

		selNew.deselectByIndex(3);

		Thread.sleep(2000);

		dr.close();
		dr.quit();

	}

}
