package Step_Definition;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import OpenCart.Base.BaseClass;
import OpenCart.ExcelData.ReadExcelFile;
import OpenCart_Pages.Add_Cart;
import OpenCart_Pages.Login_OpenCart;
import OpenCart_Pages.Order_GuestCheckout;
import OpenCart_Pages.Register_Account;
import OpenCart_Pages.Register_Failure;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cucumber_Step extends BaseClass {
	WebDriver driver;
	Actions act;
  	ReadExcelFile userdata= new ReadExcelFile();

	
	@Given("^launch open cart site$")
	public void launch_open_cart_site() throws Throwable {
		
		driver= initializedriver();
		 driver.get("https://demo.opencart.com/");
		
		
	}

	@When("^Enter firstname,lastname,Email id,password and click continue$")
	public void enter_firstname_lastname_Email_id_password_and_click_continue() throws Throwable {
		

		//data from excel
				ArrayList<String> testdata= userdata.getdata("RegisterAccount-Failure");
						
				Register_Failure fail=new Register_Failure(driver);
				
				fail.myaccount().click();
		        Thread.sleep(3000);
		        fail.register().click();
		        fail.firstname().sendKeys(testdata.get(1));
		        fail.lastname().sendKeys(testdata.get(2));
		        fail.emailid().sendKeys(testdata.get(3));
		        fail.password().sendKeys(testdata.get(5));
		        fail.confirmpassword().sendKeys(testdata.get(6));
		        fail.agree().click();
		        fail.continuebutton().click();
		        
				WebElement error=driver.findElement(By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']"));
				//error text
				System.out.println(error.getText()+"****error text**");
				//verify error text
				Boolean text=error.isDisplayed();
				System.out.println(text +"****Text is verified**");
				 Thread.sleep(5000);
		

	}

	@Then("^Account has created successfully$")
	public void account_has_created_successfully() throws Throwable {
	    System.out.println("Account has created successfully");
	}

	
	@When("^Enter firstname,lastname,Email id,password,telephone and click continue$")
	public void enter_firstname_lastname_Email_id_password_telephone_and_click_continue() throws Throwable {
Register_Account reg=new Register_Account(driver);
		
		//data from excel
		ArrayList<String> testdata= userdata.getdata("RegisterAccount");
		
		               reg.myaccount().click();
		               Thread.sleep(3000);
		               reg.register().click();
		               reg.firstname().sendKeys(testdata.get(1));
		               reg.lastname().sendKeys(testdata.get(2));
		               reg.emailid().sendKeys(testdata.get(3));
		               reg.telephone().sendKeys(testdata.get(4));
		               reg.password().sendKeys(testdata.get(5));
		               reg.confirmpassword().sendKeys(testdata.get(6));
		               reg.agree().click();
		               reg.continuebutton().click();
		               reg.myaccount().click();
		               reg.logout().click();
		               Thread.sleep(3000);
		
	}

	@Then("^Account has not created$")
	public void account_has_not_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Account has not created");
	}

	@When("^Enter Email id and Password$")
	public void enter_Email_id_and_Password() throws Throwable {
		
		//data from excel
				ArrayList<String> testdata= userdata.getdata("Login Account");
						
				Login_OpenCart login=new Login_OpenCart(driver);
				login.myaccount().click();
				login.loginpage().click();
				login.emailid().sendKeys(testdata.get(3));
				login.password().sendKeys(testdata.get(5));
				login.loginbutton().click();
			}
	

	@Then("^Home page has populated$")
	public void home_page_has_populated() throws Throwable {
		
		System.out.println("Login page has populated");
		
		//verify title of app
				WebElement title=driver.findElement(By.xpath("//a[text()='Your Store']"));
				boolean verifytitle=title.isDisplayed();
				System.out.println(verifytitle +"***verified title of application***");
			}



@When("^mouse over mac and click imac product$")
public void mouse_over_mac_and_click_imac_product() throws Throwable {
   
	 Add_Cart cart=new Add_Cart(driver);
	 act=new Actions(driver);
     WebElement desktop=	driver.findElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
	 act.moveToElement(desktop).build().perform();
	Thread.sleep(3000);
	cart.Mac().click();
	cart.iMac().click();
	Thread.sleep(3000);
	
	cart.Addcart().click();
	
	String text=cart.Addcart_text().getText();
	System.out.println(text+"***success**");
	
}


@Then("^product has added in cart successfully$")
public void product_has_added_in_cart_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   System.out.println("product added in cart successfully");
}


@When("^add cart the product and place order$")
public void add_cart_the_product_and_place_order() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	//data from excel
	ArrayList<String> testdata= userdata.getdata("Billing details");
	
	  WebElement laptop=driver.findElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
	  act.moveToElement(laptop).build().perform();
	  
	  Order_GuestCheckout checkout=new Order_GuestCheckout(driver);
	  Thread.sleep(3000);
	  checkout.laptop().click();
	  checkout.hplaptop().click();
	  checkout.futuredate().click();
	  checkout.futuredate().clear();
	  checkout.futuredate().sendKeys("2021-07-25");
	  
	  checkout.Addcart().click();
	  Thread.sleep(3000);
	  checkout.itemsbasket().click();
	  Thread.sleep(3000);
	  checkout.check().click();
	  checkout.removeitem().click();
	  Thread.sleep(3000);
	  checkout.checkbutton().click();
	  
	 //billing details
	  driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[3]/label[1]")).click();
	  
	  checkout.firstname().sendKeys(testdata.get(1));
	  checkout.lastname().sendKeys(testdata.get(2));
	  checkout.address().sendKeys(testdata.get(7));
	
	 checkout.cityname().sendKeys(testdata.get(8));
	 
	 //country
	 Select country=new Select(driver.findElement(By.id("input-payment-country")));
	  country.selectByValue("99");
	  
	  Select state=new Select(driver.findElement(By.id("input-payment-zone")));
	  state.selectByValue("1476");
	  
	WebElement continuebutton=  driver.findElement(By.id("button-payment-address"));
	 continuebutton.click();
	 Thread.sleep(3000);
	 
	 //delivery details
		WebElement shipping=  driver.findElement(By.id("button-shipping-address"));
		shipping.click();
		
	 //delivery method
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/p[4]/textarea[1]")).sendKeys("successfully added");
		WebElement commands=  driver.findElement(By.id("button-shipping-method"));
       commands.click();
              
       
	 //payment method
       WebElement agree=  driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/input[1]"));
		agree.click();
		 Thread.sleep(3000);
       WebElement payment=  driver.findElement(By.id("button-payment-method"));
		payment.click();
		 Thread.sleep(3000);
		//confirm oder
		WebElement confirm=  driver.findElement(By.id("button-confirm"));
                confirm.click();






}

	
	
	
	
	
}
