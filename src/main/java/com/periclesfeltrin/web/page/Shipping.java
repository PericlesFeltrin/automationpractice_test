package com.periclesfeltrin.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Shipping extends PageObject {

	public Shipping(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "cgv")
	protected WebElement terms;
	
	@FindBy(how = How.XPATH, using = "//div[@class='delivery_option_price']")
	protected WebElement price;

	@FindBy(how = How.NAME, using = "processCarrier")
	protected WebElement processCarrier;

	public void setTerms() {
		terms.click();
	}

	public double getPriceShipping() {
		return Double.parseDouble(price.getText().replace("$", ""));
	}
	
	public void clickOnProcessCarrier() {
		processCarrier.click();
	}
		
}
