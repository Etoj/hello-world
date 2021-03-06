package automationFramework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rossmann {
	private WebDriver wd;
	private String url;
	private String loginValue;
	private String passwordValue;
	@Before
	public void setUp() {
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		url = "https://www.rossmann.pl/";	
		loginValue = "login";
		passwordValue ="password";
		wd.get(url);
	}
	@Test
	public void checkUrl() {
		Assert.assertTrue(wd.getCurrentUrl().equals(url));	
	}
	@Test
	public void loginPositiv() {
		
	}
	@Test
	public void loginNegative(){
		wd.findElement(By.xpath("//*[@id=\"header_desktop\"]/div[2]/div[2]/ul/li[11]/a")).click();
		WebElement loginField = wd.findElement(By.xpath("//*[@id=\"loginContainer\"]/div[2]/div[1]/div[2]/div[1]/div/input"));
		loginField.clear();
		loginField.sendKeys(loginValue);
		WebElement passwordField = wd.findElement(By.xpath("//*[@id=\"loginContainer\"]/div[2]/div[1]/div[2]/div[2]/div/input"));
		passwordField.clear();
		passwordField.sendKeys(passwordValue);
		wd.findElement(By.xpath("/html/body/form/section/div[2]/div/span[1]/div/div/div[1]/div/section/div[2]/div[1]/div[2]/div[4]/div/div/div[2]/p/button")).click();
		Assert.assertTrue(wd.getPageSource().contains("Błędny login lub hasło."));
	}
	@After
	public void endTest() {
		wd.quit();
	}
}
