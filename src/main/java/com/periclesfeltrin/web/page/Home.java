package com.periclesfeltrin.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home extends PageObject {

	public Home(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "search_query_top")
	protected WebElement searchQueryTop;
	
	@FindBy(how = How.NAME, using = "submit_search")
	protected WebElement submitSearch;

	public void setSearchItem(String item) {
		wait.until(ExpectedConditions.visibilityOf(searchQueryTop));
		searchQueryTop.sendKeys(item);
	}	
	
	public void clickOnSubmitSearch() {
		submitSearch.click();
	}	

	public SearchResult buscarItem(String item){
		waitDocumentReady();
		setSearchItem(item);
		clickOnSubmitSearch();
		return new SearchResult(driver);
	}
}
