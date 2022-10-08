package org.anson.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionsDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver dr = new ChromeDriver();
		
		dr.navigate().to("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		// 1. Click and hold and move to element
		WebElement colA = dr.findElement(By.xpath("*//li[@name='A']"));
		
		WebElement colB = dr.findElement(By.xpath("*//li[@name='B']"));
		
		Actions act = new Actions(dr);
		
		act.moveToElement(colA);
		
		act.clickAndHold();
		act.moveToElement(colB);
		
		//act.dragAndDrop(colA, colB);
		
		act.build().perform();
		
		
		// 2. Drag and drop
		
		dr.navigate().to("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		
		WebElement dragE  = dr.findElement(By.id("draggable"));
		
		WebElement dropE = dr.findElement(By.id("droppable"));
		
		//Actions act1 = new Actions(dr);
		
		act.dragAndDrop(dragE, dropE);
		
		act.build().perform();
		
		

	}

}
