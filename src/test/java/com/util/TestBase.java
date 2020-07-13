
package com.util;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir")
					+"\\src\\test\\java\\com\\config\\config.properties");
			prop.load(fin);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","F:\\Selenium_Course\\webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browserName.equals("firefox")){
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
