package net.PHPTravel.PHPTravel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightSearch 
{
    @Test
	public  void FlightSearch() throws IOException, InterruptedException  
	{
		Properties p = new Properties();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Desktop\\Vinita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Maven\\PHPtravels\\src\\main\\java\\data.properties");
	    p.load(fis);
	    driver.get(p.getProperty("url"));
	    driver.manage().window().maximize();
	    
	    //Flight Button
	    driver.findElement(By.xpath("//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[2]/a")).click();
	    
	    //Enter Source
	    driver.findElement(By.xpath("//div[@id='s2id_origin']//a[@class='select2-choice select2-default']")).click();
	    driver.findElement(By.xpath("//div[@id='s2id_origin']//a[@class='select2-choice select2-default']")).sendKeys(p.getProperty("Source"));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='s2id_origin']//a[@class='select2-choice select2-default']")).sendKeys(Keys.ENTER);
	    
	    //Enter Destination
	    driver.findElement(By.xpath("//div[@id='s2id_destination']//a[@class='select2-choice select2-default']")).click();
	    driver.findElement(By.xpath("//div[@id='s2id_destination']//a[@class='select2-choice select2-default']")).sendKeys(p.getProperty("Destination"));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='s2id_destination']//a[@class='select2-choice select2-default']")).sendKeys(Keys.ENTER);
	    
	    //Departure 
	    driver.findElement(By.xpath("//input[@id='departure']")).click();
	    String s1 = driver.findElement(By.xpath("//div[16]/div[1]/table/thead/tr[1]/th[2]")).getText();
	    while(!s1.equalsIgnoreCase(p.getProperty("Departure_date")))
	    {
	    	driver.findElement(By.xpath("//div[16]//div[1]//tr[1]//th[3]")).click(); //next button
	    	s1= driver.findElement(By.xpath("//div[16]/div[1]/table/thead/tr[1]/th[2]")).getText(); //month
	    }
	    String s2;
	    for(int i=1; i<=6; i++)
	    {
	    	for(int j=1; j<=7; j++)
	    	{                                  
	    	s2 = driver.findElement(By.xpath("//div[16]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText(); //date
	    		if(s2.equals("1"))
	    		{
	    			for(int k=1; k<=6; k++)
	    			{
	    				for(int x=1; x<=7; x++)
	    				{
	    					s2 = driver.findElement(By.xpath("//div[16]/div[1]/table/tbody/tr["+k+"]/td["+x+"]")).getText();
	    					System.out.println(s2);
	    					if(s2.equals(p.getProperty("Dep_date")))
	    					{
	    						driver.findElement(By.xpath("//div[16]/div[1]/table/tbody/tr["+k+"]/td["+x+"]")).click();
	    					}
	    				}                                
	    			}
	    		}
	    	}
	    }
	    
	    
	    //Round Trip
	    driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
	    

	    //arrival
		    driver.findElement(By.xpath("//input[@id='arrival']")).click();
		    String s3 = driver.findElement(By.xpath("//div[17]/div[1]/table/thead/tr[1]/th[2]")).getText();
		    while(!s3.equalsIgnoreCase(p.getProperty("Return_date")))
		    {
		    	driver.findElement(By.xpath("//div[17]//div[1]//tr[1]//th[3]")).click(); //next button
		    	s3= driver.findElement(By.xpath("//div[17]/div[1]/table/thead/tr[1]/th[2]")).getText(); //month
		    }
		    String s4;
		    for(int i=1; i<=6; i++)
		    {
		    	for(int j=1; j<=7; j++)
		    	{                                  
		    	s4 = driver.findElement(By.xpath("//div[17]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText(); //date
		    		if(s4.equals("1"))
		    		{
		    			for(int k=1; k<=6; k++)
		    			{
		    				for(int x=1; x<=7; x++)
		    				{
		    					s4 = driver.findElement(By.xpath("//div[17]/div[1]/table/tbody/tr["+k+"]/td["+x+"]")).getText();
		    					System.out.println(s4);
		    					if(s4.equals(p.getProperty("ret_date")))
		    					{
		    						driver.findElement(By.xpath("//div[17]/div[1]/table/tbody/tr["+k+"]/td["+x+"]")).click();
		    					}
		    				}                                
		    			}
		    		}
		    	}
		    }
		    
	    //Guest
	    driver.findElement(By.xpath("//*[@id=\"thflights\"]/div[5]/div/input")).click();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//select[@id='madult']")).click();
	    driver.findElement(By.xpath("//select[@id='madult']")).sendKeys(p.getProperty("Adult"));
	    driver.findElement(By.xpath("//select[@id='mchildren']")).click();
	    driver.findElement(By.xpath("//select[@id='mchildren']")).sendKeys(p.getProperty("Child"));
	    driver.findElement(By.xpath("//select[@id='minfant']")).click();
	    driver.findElement(By.xpath("//select[@id='minfant']")).sendKeys(p.getProperty("Infant"));
	    driver.findElement(By.xpath("//*[@id=\"manual_flightTravelers\"]/div/div/div[3]")).click(); //Done button
	    Thread.sleep(2000);
	    
	    //Search button
	    driver.findElement(By.xpath("//div[@class='bgfade col-md-3 col-xs-12 search-button']")).click();
	
	 }
}
