package OpenCart_Main;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import OpenCart.Base.BaseClass;
import OpenCart.ExcelData.ReadExcelFile;
import OpenCart_Pages.Add_Cart;
import OpenCart_Pages.Login_OpenCart;
import OpenCart_Pages.Order_GuestCheckout;
import OpenCart_Pages.Register_Account;
import OpenCart_Pages.Register_Failure;

public class MainTest_OpenCart extends BaseClass{
	WebDriver driver;
	Actions act;
  	ReadExcelFile userdata= new ReadExcelFile();

	@Test(priority=0)
	public void RegisterAccount() throws InterruptedException, IOException {
		driver= initializedriver();
		 driver.get("https://demo.opencart.com/");
		 
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
	
	@Test(priority=1)
	public void RegisterFailure() throws InterruptedException, IOException {
		
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
	
	@Test(priority=2)
	public void loginOpencart() throws IOException {
		
		//data from excel
		ArrayList<String> testdata= userdata.getdata("Login Account");
				
		Login_OpenCart login=new Login_OpenCart(driver);
		login.myaccount().click();
		login.loginpage().click();
		login.emailid().sendKeys(testdata.get(3));
		login.password().sendKeys(testdata.get(5));
		login.loginbutton().click();
	}
	
	@Test(priority=3)
	public void verifytitle() {
		//verify title of app
		WebElement title=driver.findElement(By.xpath("//a[text()='Your Store']"));
		boolean verifytitle=title.isDisplayed();
		System.out.println(verifytitle +"***verified title of application***");
	}
		
	
	@Test(priority=4)
	public void addcart() throws InterruptedException {
		
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
		@Test(priority=5)
		public void Guestcheckout() throws InterruptedException, IOException {
			
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

	


	
	
	
	
	
	
	
	
	
	

