package OpenCart_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Cart {


	WebDriver driver;

	public Add_Cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	WebElement mac;

	public WebElement Mac() {
		return mac;
	}
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")
	WebElement productmac;

	public WebElement iMac() {
		return productmac;
	}
	
	@FindBy(id="button-cart")
	WebElement addcart;

	public WebElement Addcart() {
		return addcart;
	}
	
	@FindBy(xpath="//body[1]/div[2]/div[1]")
	WebElement text;

	public WebElement Addcart_text() {
		return text;
	}
	//body[1]/div[2]/div[1]
	
	
	
	
}
