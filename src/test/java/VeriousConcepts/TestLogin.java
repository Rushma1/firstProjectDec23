package VeriousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {
	WebDriver driver;
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	//@Test
	public void loginTest() {
		//storing web element
		//WebElement type
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));
		
		
		
		
		
		By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By SIGNIN_BUTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
		By DASHBOARD_HEADER_FIELD = By.xpath("//strong[text()='Dashboard']");
		By CUSTOMER_MENU_FIELD=By.xpath("");
		
		
		
		//driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("demo@codefios.com");
		//driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));
		
		boolean pageTitleDisplayStatus;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//strong[text()='Dashboard']"));
			pageTitleDisplayStatus=true;
		}catch(Exception e) {
			pageTitleDisplayStatus=false;
			e.getStackTrace();
		}
		
		
		Assert.assertTrue("Dashboard page not found!!", pageTitleDisplayStatus);
		
	}
	@Test
	public void testDropdown() {
		loginTest();
		//driver.findElement(CUSTOMER_MENU_FILED)
		
	}

}
