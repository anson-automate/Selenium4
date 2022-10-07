package org.anson.Selenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver dr = new ChromeDriver();
		
		// implicit wait
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		dr.navigate().to("https://www.google.com/");
		
		dr.findElement(By.name("q")).sendKeys("abc");
		WebDriverWait wait= new WebDriverWait(dr,Duration.ofSeconds(20));
		try {
			WebElement elementToWait = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
			elementToWait.click();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			dr.close();
			dr.quit();
		}
		
		
		
		
		
		
		
		
		

	}

}
