package day39;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;
	//LoginPage lp;
	LoginPage2 lp;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=1)
	void testLogo()
	{
		//if we want to use a method then we need to create an object and also pass the constructor parameter
		//lp.checkLogoPresence();
		lp=new LoginPage2(driver);
		//capture the return value and so keep assertion
		Assert.assertEquals(lp.checkLogoPresence(), true);
		
	}
	
	@Test(priority=2)
	void testLogin()
	{
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickSubmit();
		
		//validation
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

}
