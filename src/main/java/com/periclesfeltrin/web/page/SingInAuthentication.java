package com.periclesfeltrin.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SingInAuthentication extends PageObject {

	public SingInAuthentication(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "email_create")
	protected WebElement emailCreate;

	@FindBy(how = How.ID, using = "SubmitCreate")
	protected WebElement submitCreate;

	@FindBy(how = How.ID, using = "email")
	protected WebElement email;

	@FindBy(how = How.ID, using = "passwd")
	protected WebElement password;

	@FindBy(how = How.ID, using = "SubmitLogin")
	protected WebElement submitLogin;

	public void setEmailCreate(String email) {
		emailCreate.sendKeys(email);
	}	
	
	public void clickOnCreateAccount() {
		submitCreate.click();
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPassword(String passwd) {
		password.sendKeys(passwd);
	}

	public void clickOnSubmitLogin() {
		submitLogin.click();
	}

	public void login(String email, String password){
		setEmail(email);
		setPassword(password);
		clickOnSubmitLogin();
	}
}
