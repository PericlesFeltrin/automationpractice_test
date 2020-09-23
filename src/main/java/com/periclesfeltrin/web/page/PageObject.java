package com.periclesfeltrin.web.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	public PageObject (WebDriver driver) {
		PageObject.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void selectByVisibleText(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

	public void waitDocumentReady(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String status = "complete";
		do {
			status = js.executeScript("return document.readyState").toString();
		}
		while (status.equals("complete") == false);
	}

}
