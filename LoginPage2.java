package day39;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	public WebDriver driver;
	
	//constructor
	LoginPage2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); //assigns driver for every WebElement to identify
	}
	
	//two things for page object class using pagefactory
	//WebElements: locators+identifications(without using driver.findElement)
	//@FindBy(how=How.XPATH,using="//img[@alt='company-branding']") //if we don't know what locator to use
	@FindBy(xpath="//img[@alt='company-branding']") //identifying element
	WebElement img_logo;  //stored in variable
	
	@FindBy(name="username")
	WebElement txt_username;
	
	@FindBy(css="input[placeholder='Password']")
	WebElement txt_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btn_submit;
	
	//@FindBy(tagName="a")
	//List<WebElement> links;
	
	//action methods
	public void setUserName(String username)
	{
		txt_username.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		btn_submit.click();
	}
	
	public boolean checkLogoPresence()
	{
		boolean status=img_logo.isDisplayed();
		return status;
	}

}
