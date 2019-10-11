package net.PHPTravel.PHPTravel;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TourSearch 
{
	@Test
	public void ToursSearch() throws IOException, InterruptedException 
	{
		Properties p = new Properties();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Desktop\\Vinita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Maven\\PHPtravels\\src\\main\\java\\data.properties");
	    p.load(fis);
	    driver.get(p.getProperty("url"));
	    driver.manage().window().maximize();
	    
	    //Tour button
	    driver.findElement(By.xpath("//div[@id='body-section']//li[3]//a[1]")).click();
	    
	    //City name
	    driver.findElement(By.xpath("//*[@id=\"s2id_autogen3\"]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"s2id_autogen3\"]/a")).sendKeys(p.getProperty("City_name"));
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"s2id_autogen3\"]/a")).sendKeys(Keys.ENTER);
	    
	    //Check in
	    driver.findElement(By.xpath("//div[@id='tchkin']//input[@placeholder='Check in']")).click(); //check in
	    String s1 = driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[2]")).getText(); //month
	    while(!s1.equalsIgnoreCase(p.getProperty("check_in")))
	    {
	    	driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[3]")).click(); //next button
	    	s1= driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[2]")).getText(); //month
	    }
	    String s2;
	    for(int i=1; i<=6; i++)
	    {
	    	for(int j=1; j<=7; j++)
	    	{
	    	s2 = driver.findElement(By.xpath("//div[11]//tr["+i+"]//td["+j+"]")).getText(); //date
	    		if(s2.equals("1"))
	    		{
	    			for(int k=1; k<=6; k++)
	    			{
	    				for(int x=1; x<=7; x++)
	    				{
	    					s2 = driver.findElement(By.xpath("//div[11]//tr["+k+"]//td["+x+"]")).getText();
	    					System.out.println(s2);
	    					if(s2.equals(p.getProperty("indate")))
	    					{
	    						driver.findElement(By.xpath("//div[11]//tr["+k+"]//td["+x+"]")).click();
	    					}
	    				}                                
	    			}
	    		}
	    	}
	    }
	    
	    //Guest
	    driver.findElement(By.xpath("//select[@id='adults']")).click();
	    driver.findElement(By.xpath("//select[@id='adults']")).sendKeys(p.getProperty("Guest"));
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//select[@id='adults']")).sendKeys(Keys.ENTER);
	    
	    //Tour Type
	    driver.findElement(By.xpath("//select[@id='tourtype']")).click();
	    driver.findElement(By.xpath("//select[@id='tourtype']")).sendKeys(p.getProperty("Tour_type"));
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//select[@id='tourtype']")).sendKeys(Keys.ENTER);
	    
	    //Search button
	    driver.findElement(By.xpath("//div[@id='tours']//div[@class='col-md-2 form-group go-right col-xs-12 search-button']")).click();
	}

}
