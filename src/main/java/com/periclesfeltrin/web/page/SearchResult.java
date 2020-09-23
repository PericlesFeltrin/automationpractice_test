package com.periclesfeltrin.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResult extends PageObject {

	public SearchResult(WebDriver driver) {
		super(driver);
	}

	public void clickOnItem(String linkText) {
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//a[@class='product-name'][contains(text(),'"+linkText+"')]"))
			)).click();
	}

	public Item selecionarItem(String item){
		waitDocumentReady();
		clickOnItem(item);
		return new Item(driver);
	}

}
