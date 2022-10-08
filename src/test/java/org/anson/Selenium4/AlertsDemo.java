package org.anson.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		
		dr.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		
		// 1 JS alert
		WebElement jsAl = dr.findElement(By.xpath("*//button[@onclick='jsAlert()']"));
		
		//System.out.println("Text is "+jsAl.getText());
		
		jsAl.click();
		
		dr.switchTo().alert().accept();
		
		System.out.println("Text is present? "+dr.findElement(By.xpath("(*//*[contains(text(),'You successfully')])[2]")).isDisplayed());
		
		// 2 J S confirm
		dr.findElement(By.xpath("*//button[@onclick='jsConfirm()']")).click();
		
		dr.switchTo().alert().dismiss();
		
		System.out.println("Text is present- "+dr.findElement(By.id("result")).getText());
		
		// 3. J S prompt 
		
		dr.findElement(By.xpath("*//button[@onclick='jsPrompt()']")).click();
		
		dr.switchTo().alert().sendKeys("fun");
		
		dr.switchTo().alert().accept();
		
		System.out.println("Text is present- "+dr.findElement(By.id("result")).getText());
		
		
		dr.close();
		dr.quit();

	}

}
