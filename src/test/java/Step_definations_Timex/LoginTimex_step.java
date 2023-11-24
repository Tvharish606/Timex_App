package Step_definations_Timex;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginTimex_step 
{
	WebDriver driver;
	String Parent_id;
	
	@Given("when user entered the valid email id and click on next button")
	public void when_user_entered_the_valid_email_id_and_click_on_next_button() throws InterruptedException
	{
		
	    System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	    driver =new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.navigate().to("https://timex-app-service.azurewebsites.net/#/login");
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.findElement(By.xpath("//button[text()='Login with ']")).click();
	   String Parent_id = driver.getWindowHandle();
	   Set<String> All_tabs = driver.getWindowHandles();
	   ArrayList<String> list_of_tabs=new ArrayList<String>(All_tabs);
	   
	   for(String List_of_windows:list_of_tabs)
	   {
		   driver.switchTo().window(List_of_windows);
	   }
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("harish.v@3ktechnologies.com");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
	    Thread.sleep(3000);
	   }

	@Given("enter the valid password and click on Sign in button")
	public void enter_the_valid_password_and_click_on_sign_in_button() throws InterruptedException 
	{
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hari@3ktech606");
		 Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
		    Thread.sleep(15000);
		    driver.findElement(By.xpath("//input[@id='idSIButton9']")).sendKeys(Keys.ENTER);
		    Thread.sleep(6000);
		    
		    
	}

	@Then("check wheather the user is able to see the Welcome page")
	public void check_wheather_the_user_is_able_to_see_the_welcome_page() throws InterruptedException 
    {
		driver.switchTo().window(Parent_id);
		Thread.sleep(2000);
	   String Actual_Welcome_page_url = driver.getCurrentUrl();
	   String Excepted_welcome_page_url="https://timex-app-service.azurewebsites.net/#/layouts/welcome";
	   Assert.assertEquals(Actual_Welcome_page_url,Excepted_welcome_page_url);
	   Assert.assertTrue(true);
	   System.out.println(Actual_Welcome_page_url);
	  
	   
	}

	@Given("enter the invalid password and click on Sign in button")
	public void enter_the_invalid_password_and_click_on_sign_in_button() throws InterruptedException
	{
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hari@3kt606");
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
		    
		   
	}
	@Then("check wheather the user able to login to welcome page")
	public void check_wheather_the_user_able_to_login_to_welcome_page()
	{
		boolean Error_message = driver.getPageSource().contains("you");
		System.out.println(Error_message);
	}
}

