package com.PruebaTecnicaTest.avianca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	private WebDriver driver;
	
	//Metodos de Selenium que se van a usar
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		return driver;
	}
			
	public WebElement findElement(By locator) {
		
		return driver.findElement(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public String Text(By locator) {
		String Text = driver.findElement(locator).getText();
		return Text;
	}
	
	public void clear(By locator) {
		driver.findElement(locator).clear();;
	}
	
	public Boolean isDisplayed(By locator) {
		
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public String istext(By locator) {
		String a =driver.findElement(locator).getText();
		return a;
	}
	//metodo que usa JavaScrip para hacer Scroll
	public void Hacer_scroll(WebDriver driver,By locator) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	
}
