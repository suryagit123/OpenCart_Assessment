package OpenCart_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Failure {


	
	WebDriver driver;

	public Register_Failure(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myaccount;

	public WebElement myaccount() {
		return myaccount;
	}

	@FindBy(xpath = "//a[text()='Register']")
	WebElement reg;

	public WebElement register() {
		return reg;
	}

	@FindBy(id = "input-firstname")
	WebElement first;

	public WebElement firstname() {
		return first;
	}

	@FindBy(id = "input-lastname")
	WebElement last;

	public WebElement lastname() {
		return last;
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

	@FindBy(id = "input-confirm")
	WebElement confirm;

	public WebElement confirmpassword() {
		return confirm;
	}

	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacy;

	public WebElement agree() {
		return privacy;
	}

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement button;

	public WebElement continuebutton() {
		return button;
	}
	
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	public WebElement logout() {
		return logout;
	}
	
	
}
