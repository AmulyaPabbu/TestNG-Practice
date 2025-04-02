package day39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	//constructor
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//two things for page object class
	//locators
	By img_logo_loc=By.xpath("//img[@alt='company-branding']"); //capturing only locator and not webelement
	By txt_username_loc=By.name("username");
	By txt_pwd_loc=By.cssSelector("input[placeholder='Password']");
	By btn_submit_loc=By.xpath("//button[normalize-space()='Login']");
	
	//action methods
	public void setUserName(String username)
	{
		driver.findElement(txt_username_loc).sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(txt_pwd_loc).sendKeys(password);
	}
	
	public void clickSubmit()
	{
		driver.findElement(btn_submit_loc).click();
	}
	
	public boolean checkLogoPresence()
	{
		boolean status=driver.findElement(img_logo_loc).isDisplayed();
		return status;
	}

}
