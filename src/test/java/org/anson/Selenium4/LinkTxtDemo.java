package org.anson.Selenium4;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkTxtDemo {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver dr = new ChromeDriver();
		
		dr.navigate().to("https://www.amazon.in/");
		
		WebElement hover = dr.findElement(By.xpath("*//span[@class='nav-line-2 ']"));
		
		System.out.println("hover ele text "+hover.getText());
		
		Actions at = new Actions(dr);
		
		at.moveToElement(hover).build().perform();
		
		WebElement sectAcc = dr.findElement(By.id("nav-al-your-account"));
		
		List<WebElement> links = sectAcc.findElements(By.tagName("a"));
		
		WebElement link = null;
		
		Iterator ie = links.iterator();
		
		while (ie.hasNext()) {
			link= (WebElement) ie.next();
			
			System.out.println(link.getText());
		}
	dr.close();
	dr.quit();

	}
	

}
