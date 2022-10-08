package org.anson.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {

		/// System.setProperty("webdriver.chrome.driver", "C://Selenium-java
		/// browserstack//chromedriver_win32//chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();

		dr.navigate().to("https://trytestingthis.netlify.app/");
		
		dr.manage().window().maximize();

		WebElement dropDn = dr.findElement(By.id("option"));

		Select selObj = new Select(dropDn);

		// 1 Selecting an option in drop down
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

		// 2 .De selecting an option in drop down

		selNew.deselectByIndex(3);

		Thread.sleep(2000);

		
		// 3. Setting date
		
		//dr.findElement(By.id("day")).sendKeys("21051986",Keys.TAB);
		
		//4. Setting Slider 
		int setVal = 40;
		int  currVal= 0;
		
		Keys keyT = Keys.ARROW_RIGHT;
		
		if (setVal < 50) {
			keyT = Keys.ARROW_LEFT;
		}
		while (setVal != currVal) {
			dr.findElement(By.id("a")).sendKeys(keyT);
			
			currVal=Integer.valueOf(dr.findElement(By.xpath("*//output[@name='x']")).getText());
		}
	

		// 5. scroll to element 
		Actions act = new Actions (dr);
		WebElement toScroll = dr.findElement(By.xpath("*//h6"));
		act.scrollToElement(toScroll).build().perform();
		
		System.out.println("new  val -> "+dr.findElement(By.xpath("*//output[@name='x']")).getText());
		// 6. upload a file
		
		Thread.sleep(2000);
		dr.findElement(By.id("myfile")).sendKeys("/home/lenovo/Documents/Git_projects/TesFileUpLoad");

		
		
		Thread.sleep(2000);
//		dr.close();
//		dr.quit();

	}

}
