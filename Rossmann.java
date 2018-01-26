package automationFramework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rossmann {
	private WebDriver wd;
	private String url;
	private String loginValue;
	private String passwordValue;
	@Before
	public void setUp() {
	wd = new FirefoxDriver();
	loginValue = "login";
	passwordValue ="password";
	}
	@Test
	public void checkUrl() {
		
	}
	@Test
	public void loginPositiv() {
		
	}
	@Test
	public void loginNegative(){
		
	}
	@After
	public void endTest() {
		wd.quit();
	}
}
