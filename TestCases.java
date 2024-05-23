package testsuit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
WebDriver driver;
@BeforeTest
public void setUp() {
	        System.setProperty("webdriver.chrome.driver","C://Users//ashutosh//Downloads//chromedriver.exe");//path to chromedriver
	        driver = new ChromeDriver();
	        driver.get("https://www.tendable.com");
	    }
	  

	    public void verifyTestMenus() {
	        String[] menus = {"Home", "Our Story", "Our Solution", "Why Tendable"};
	     
	            for (String menu : menus) {
	                WebElement menuElement = (WebElement) driver.findElements(By.id("main-navigation-new"));
	                Assert.assertTrue(menuElement.isDisplayed(), menu + " is not accessible");
	            }
	        }
	   @Test 
	    public void testDemoButton() {
	        String[] menus = {"Home", "Our Story", "Our Solution", "Why Tendable"};
	        for (String menu : menus) {
	            driver.findElement(By.id("main-navigation-new")).click();
	            WebElement requestDemoButton = driver.findElement(By.cssSelector("a[href*='request-demo']"));
	            Assert.assertTrue(requestDemoButton.isDisplayed() && requestDemoButton.isEnabled(), "Request a Demo button is not active on " + menu + " page");
	        }
	    }
	   @Test
	    public void testContactForm() {
	        driver.findElement(By.linkText("Contact Us")).click();
	        driver.findElement(By.tagName("button")).click(); 
	        driver.findElement(By.cssSelector("#form-input-fullName")).sendKeys("Sushma");
	        driver.findElement(By.cssSelector("#form-input-organisationName")).sendKeys("xyz");
	        driver.findElement(By.cssSelector("#form-input-cellPhone")).sendKeys("9090909090");
	        driver.findElement(By.cssSelector("#form-input-consentAgreed-0")).click();
	        driver.findElement(By.cssSelector("button[type='submit']")).click();

	        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Sorry, there was an error submitting the form. Please try again')]"));
	        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed when message field is empty");
	    }
@AfterTest
public void closeBrowser()
{
	if(driver!=null)
	{
		driver.quit();
	}
	}
	    
}


