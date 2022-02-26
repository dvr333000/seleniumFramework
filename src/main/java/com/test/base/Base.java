package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	protected WebDriver driver;
	private static Properties resource;
	WebDriverWait wait;
	static String basePath = System.getProperty("user.dir");
	
	private static final Logger log = LogManager.getLogger(Base.class.getName());
		
	public WebDriver initializeDriver(){
		
		FileInputStream fis = null;
		resource = new Properties();
		String browser;
		
		try {
			fis = new FileInputStream(basePath+"/src/main/java/resources/config.properties");
			resource.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Resource file does not exist");
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		browser = resource.getProperty("browser").trim();
		switch(browser){
		case "chrome":
			log.info("Setting up ChromeDriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("ChromeDriver setup completed");
			break;
			
		case "chrome-headless":
			log.info("Setting up ChromeDriver");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			log.info("ChromeDriver setup completed");
			break;
			
		case "firefox":
			log.info("Setting up FirefoxDriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("FirefoxDriver setup completed");
			break;
			
		case "edge":
			log.info("Setting up EdgeDriver");
			WebDriverManager.edgedriver().setup();
			log.info("EdgeDriver setup completed");
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("Please check the given browser name in the resource file");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
    public void loadBaseUrl(WebDriver driver) {
		log.info("Loading URL");
        driver.get(resource.getProperty("url"));
        log.info("Application loaded successfully");
        
    }
	
    public static String getScreenShotLocation(String testName, WebDriver driver) {
    	File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	String destinationFile = basePath+"/reports/"+testName+".png";
    	try {
			FileUtils.copyFile(source, new File(destinationFile));
		} catch (IOException e) {
			log.warn("Screenshot not captured");
			e.printStackTrace();
		}
    	return destinationFile;
    }
    
    public static void shortWait() {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
      
    public static void longWait() {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	
}
