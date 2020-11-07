package rimidalv111.com.main;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;

public class PageCrawler extends Thread
{

	public SerpHelper instance;
	private String keyword;
	private String domain;

	//selenium stuff
	private JBrowserDriver driver;
	
	public PageCrawler(SerpHelper i, String k, String t)
	{
		instance = i;
		keyword = k;
		domain = t;
	}

	public void run()
	{
		try
		{  
			launchBrowser();
			
			Thread.sleep(2000);
			
			//navigate to google search
			driver.get("https://www.google.com");
			
			//find and fillout search field
			WebElement elementSearch = driver.findElement(By.xpath("//*[@id='lst-ib']"));

			Thread.sleep(1000);
			
			CharSequence[] cs = new String[] {keyword};
			
			elementSearch.sendKeys(cs);
			
			Thread.sleep(1000);
			
			//hit the enter button to complete search
			elementSearch.sendKeys(new CharSequence[] {Keys.ENTER.toString()});
			
			Thread.sleep(2000);
			
			System.out.println(driver.getCurrentUrl().toString());
			
			
			driver.close();
			
		} catch (Exception io)
		{
			io.printStackTrace();
			this.interrupt();
		}
	}
	
	

	public void launchBrowser()
	{
		//driver = new ChromeDriver();
	    //JBrowserDriver driver = new JBrowserDriver(Settings.builder().timezone(Timezone.AMERICA_NEWYORK).build());
		//driver.manage().window().setSize(new Dimension(600, 500));
		
		try
		{

			DesiredCapabilities capabilities = 
			        new DesiredCapabilities("jbrowserdriver", "1", Platform.WINDOWS);
			    
			    // Optionally customize the settings
			    capabilities.merge(
			        Settings.builder().
			        timezone(Timezone.AMERICA_NEWYORK).
			        buildCapabilities());
			    
			    RemoteWebDriver drivers = new RemoteWebDriver(
			        new URL("http://localhost:4444/wd/hub"), capabilities);
			    
			    drivers.get("http://example.com");
			    
			    System.out.println(driver.getPageSource());
			    
			    drivers.quit();
		} catch (Exception io)
		{
			System.out.println("failed");
			io.printStackTrace();
		}
		    
	}
	
	public void killTheThread()
	{

	}

	public void softKillTheThread()
	{

		this.interrupt();
	}
}
