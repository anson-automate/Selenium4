package org.anson.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActionsDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver dr = new ChromeDriver();
		
		dr.navigate().to("https://www.google.com/");
		// 1. key down  2. key up 3. clear text box
		WebElement serBx = dr.findElement(By.name("q"));
		Actions act = new Actions(dr);
		
		act.keyDown(Keys.SHIFT).sendKeys(serBx, "selenium ").keyUp(Keys.SHIFT).sendKeys("selenium").build().perform();
		
		serBx.clear();
		
		dr.close();
		dr.quit();
		
		

	}

}
