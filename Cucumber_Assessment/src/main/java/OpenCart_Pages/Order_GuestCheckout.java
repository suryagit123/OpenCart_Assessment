package OpenCart_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order_GuestCheckout {

	WebDriver driver;

	public Order_GuestCheckout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/div[1]/a[1]")
	WebElement showall;

	public WebElement laptop() {
		return showall;
	}
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")
	WebElement hp;

	public WebElement hplaptop() {
		return hp;
	}
	
	@FindBy(id="input-option225")
	WebElement date;

	public WebElement futuredate() {
		return date;
	}
	

	@FindBy(id="button-cart")
	WebElement addcart;

	public WebElement Addcart() {
		return addcart;
	}
	
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/button[1]")
	WebElement items;

	public WebElement itemsbasket() {
		return items;
	}
	
	
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]")
	WebElement check;

	public WebElement check() {
		return check;
	}
	
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/span[1]/button[2]")
	WebElement remove;

	public WebElement removeitem() {
		return remove;
	}
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]")
	WebElement checkbutton;

	public WebElement checkbutton() {
		return checkbutton;
	}
	
	
	@FindBy(id="input-payment-firstname")
	WebElement first;

	public WebElement firstname() {
		return first;
	}
	

	@FindBy(id="input-payment-address-1")
	WebElement add;

	public WebElement address() {
		return add;
	}

	@FindBy(id="input-payment-lastname")
	WebElement last;

	public WebElement lastname() {
		return last;
	}
	
	
	@FindBy(id="input-payment-city")
	WebElement city;

	public WebElement cityname() {
		return city;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
