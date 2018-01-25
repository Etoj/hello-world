package automationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cos {
	private WebDriver wd;
	private String url;
	private String chkBxValue;
	private String nameValue;
	
	@Before
	public void setUp() {
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		url ="http://toolsqa.com/automation-practice-form/";
		wd.get(url);
		chkBxValue ="Automation Tester";
		nameValue ="Bartek"
	}
	@Test
	public void url() {
		Assert.assertTrue(wd.getCurrentUrl().equals(url));
		}
	@Test
	public void nameInput(){
		WebElement name = wd.findElement(By.name("firstname"));
		name.clear();
		name.sendKeys(nameValue);	
		Assert.assertTrue(wd.findElement(By.name("firstname")).getAttribute("value").equals(nameValue));
	}
	@Test
	public void chkBxTest() {
		List<WebElement> chkBox =wd.findElements(By.name("profession"));
		int iSize = chkBox.size();
		for(int i=0; i<iSize;i++) {
			String sValue = chkBox.get(i).getAttribute("value");
			if(sValue.equalsIgnoreCase(chkBxValue)) {
				chkBox.get(i).click();
				break;
			}
		}
		Assert.assertTrue(wd.findElement(By.id("profession-1")).isSelected());
	}
	@Test
	public void rdBtnTest() {
		List<WebElement> rdBtn = wd.findElements(By.name("sex"));
		boolean bValue = false;
		bValue =rdBtn.get(0).isSelected();
		if(bValue==true) {
			rdBtn.get(1).click();
		}else {
			rdBtn.get(0).click();
		}
		Assert.assertTrue(wd.findElement(By.id("sex-0")).isSelected());
	}
	@After
	public void quit() {
		wd.quit();
	}
	}
