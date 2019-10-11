package net.PHPTravel.PHPTravel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class browser 
{
	@Test
	public void SignUp() throws IOException
	{
		Properties p = new Properties();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Desktop\\Vinita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Maven\\PHPtravels\\src\\main\\java\\data.properties");
	    p.load(fis);
	    driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Sign Up')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(p.getProperty("First_Name"));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(p.getProperty("Last_Name"));
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(p.getProperty("Mobile_no"));
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(p.getProperty("Email"));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(p.getProperty("Password"));
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(p.getProperty("Confirm_Password"));
		driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click(); //Cookie
	    driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")).click(); //Signup
	
    }
}
