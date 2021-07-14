package OpenCart_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_OpenCart {


	WebDriver driver;

	public Login_OpenCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myaccount;

	public WebElement myaccount() {
		return myaccount;
	}
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginbutton;

	public WebElement loginpage() {
		return loginbutton;
	}
	
	@FindBy(id = "input-email")
	WebElement email;

	public WebElement emailid() {
		return email;
	}
	@FindBy(id = "input-password")
	WebElement pass;

	public WebElement password() {
		return pass;
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;

	public WebElement loginbutton() {
		return login;
	}
	
}
