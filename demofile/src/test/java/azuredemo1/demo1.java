package azuredemo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class demo1 {
	public WebDriver driver;
	 
	@BeforeClass
	 public void a_pageload() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://sprint8-test.ameganow.com");
		driver.manage().window().maximize();

	}

	@Test(priority =1)
	public void b_Login() throws InterruptedException  {
	Boolean Status = driver.findElement(By.xpath("(//div[@class='collapse navbar-collapse']/ul/li)[7]")).isEnabled();
	System.out.println(Status);
	driver.findElement(By.xpath("(//div[@class='collapse navbar-collapse']/ul/li)[7]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sprint8@yopmail.com");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}

	@Test(priority=2)
	public void c_view_taxcode() throws InterruptedException {
		//WebDriverWait wait1 = new WebDriverWait(driver,30);
		//WebElement createpost1 =wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Tax code setup')]")));
		 Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(text(),'Tax code setup')]")).click();
		String text1 = driver.findElement(By.xpath("//span[contains(text(),'Tax code setup')]/following::h1[2]")).getText();
		System.out.println("Heading 1 :-"+text1);
		String text2 = driver.findElement(By.xpath("//th[contains(text(),'S.No')]")).getText();
		System.out.println(text2);
		String text3 = driver.findElement(By.xpath("//th[contains(text(),'Group')]")).getText();
		System.out.println(text3);
		String text4 = driver.findElement(By.xpath("//th[contains(text(),'Reporting')]")).getText();
		System.out.println(text4);
		String text5 = driver.findElement(By.xpath("//th[contains(text(),'Rate')]")).getText();
		System.out.println(text5);
		String text6 = driver.findElement(By.xpath("//th[contains(text(),'Action')]")).getText();
		System.out.println(text6);
		driver.findElement(By.xpath("//button[contains(text(),'Add')]/preceding::input")).sendKeys("ak46%$");
		 
		//WebDriverWait wait2 = new WebDriverWait(driver,30);
		//WebElement createpost2 =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
	}
	
	 @Test(priority=3)
		public void d_logout() throws InterruptedException  {
			//WebDriverWait wait9 = new WebDriverWait(driver,30);
			//WebElement createpost9 =wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'sprint eight')]")));
		    Thread.sleep(10000);
			driver.findElement(By.xpath("//span[contains(text(),'sprint eight')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			
			
			
	}
	 
	@AfterClass
		public void e_browserclose()  {
		driver.close();
	}
    }



