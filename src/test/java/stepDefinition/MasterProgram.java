package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterProgram {
	public WebDriver d;
	
	@Given("^Launch site$")
	public void launch_site() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Given Executed");
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
	    opt.addArguments("--remote-allow-origins=*");
		d= new ChromeDriver(opt);
		d.get("https://www.saucedemo.com/"); 
		d.manage().window().maximize();
	}
  
	

	@When("^Enter Credentials$")
	public void enter_Credentials(DataTable arg1) throws Throwable {
		 List< List<String>> data=arg1.raw();
		 d.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(data.get(0).get(0));
			d.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(data.get(0).get(1));
			d.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	@When("^Visit Homepage$")
	public void visit_Homepage() throws Throwable {
		d.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		Thread.sleep(6000);
		d.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]")).click();
		String title1 = d.getTitle();
		System.out.println(title1);
		d. navigate(). back();
	} 
	
	@When("^Add to cart$")
	public void add_to_cart() throws Throwable {
	    // adding items into cart
		d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
		d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
		
		//click on my cart link
		d.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		
	    //remove one item from link
		d.findElement(By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]")).click();
		Thread.sleep(6000);
		//count Number of items in carts
		WebElement cartIcon = d.findElement(By.className("shopping_cart_badge"));
        String itemCountText = cartIcon.getText();

        // Convert the text to an integer
        int itemCount = Integer.parseInt(itemCountText);

        System.out.println("Number of items in the cart: " + itemCount);

	}
	

	@When("^checkout$")
	public void checkout(DataTable arg2) throws Throwable {
	    // click on checkout Button
		d.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		List< List<String>> data=arg2.raw();
		 d.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(data.get(0).get(0));
			d.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(data.get(0).get(1));
			d.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(data.get(0).get(2));
			//continue shoping
			d.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		//cancel button
			d.findElement(By.xpath("//*[@id=\"cancel\"]")).click();
	}

	@When("^logout$")
	public void logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		d.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		Thread.sleep(6000);
		//click on logout
		d.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
	}

	@Then("^Close Browser$")
	public void close_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		d.close();
	   
	}


}
