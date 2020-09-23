package com.periclesfeltrin.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Item extends PageObject {

	public Item(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "our_price_display")
	protected WebElement price;
	
	@FindBy(how = How.ID, using = "quantity_wanted")
	protected WebElement quantity;

	@FindBy(how = How.ID, using = "group_1")
	protected WebElement size;

	@FindBy(how = How.NAME, using = "Submit")
	protected WebElement addToCart;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Proceed to checkout']")
	protected WebElement proceedToCheckout;
	
	public double getPrice() {
		wait.until(ExpectedConditions.visibilityOf(price));
		return Double.parseDouble(price.getText().replace("$", ""));
	}
	
	public void setQuantityWanted(String quantity_wanted) {
		quantity.clear();
		quantity.sendKeys(quantity_wanted);
	}
	
	public void setSize(String size) {
		selectByVisibleText(this.size, size);
	}
	
	public void setColor(String color) {
		driver.findElement(By.name(color)).click();
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	public void clickOnProceedToCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
	}

	public void adicionarAoCarrinho(String quantity_wanted, String size, String color){
		setQuantityWanted(quantity_wanted);
		setSize(size);
		setColor(color);
		clickOnAddToCart();
	}

	public CartSummary adicionarItemEIrParaOCarrinho(String quantity_wanted, String size, String color){
		adicionarAoCarrinho(quantity_wanted, size, color);
		clickOnProceedToCheckout();
		return new CartSummary(driver);
	}

}
