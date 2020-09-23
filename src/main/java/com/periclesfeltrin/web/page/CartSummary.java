package com.periclesfeltrin.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartSummary extends PageObject {

	public CartSummary(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//td[@class='cart_description']//p[@class='product-name']")
	protected WebElement productName;

	@FindBy(how = How.XPATH, using = "//td[@class='cart_description']//small//a")
	protected WebElement colorSize;

	@FindBy(how = How.ID, using = "total_product")
	protected WebElement totalProduct;
	
	@FindBy(how = How.ID, using = "total_shipping")
	protected WebElement totalShipping;

	@FindBy(how = How.ID, using = "total_price_without_tax")
	protected WebElement totalPriceWithoutTax;
	
	@FindBy(how = How.ID, using = "total_tax")
	protected WebElement totalTax;

	@FindBy(how = How.ID, using = "total_price")
	protected WebElement totalPrice;

	@FindBy(how = How.XPATH, using = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	protected WebElement proceedToCheckout;
	
	public String getProductName(){
		return productName.getText();
	}

	public String getColorSize(){
		return colorSize.getText();
	}

	public double getTotalProducts() {
		return Double.parseDouble(totalProduct.getText().replace("$", ""));
	}	
	
	public double getTotalShipping() {
		return Double.parseDouble(totalShipping.getText().replace("$", ""));
	}	
	
	public double getTotalPriceWithoutTax() {
		return Double.parseDouble(totalPriceWithoutTax.getText().replace("$", ""));
	}	
	
	public double getTotalTax() {
		return Double.parseDouble(totalTax.getText().replace("$", ""));
	}	
	
	public double getTotalPrice() {
		return Double.parseDouble(totalPrice.getText().replace("$", ""));
	}	
		
	public void clickOnProceedToCheckout() {
		proceedToCheckout.click();
	}
	
}
