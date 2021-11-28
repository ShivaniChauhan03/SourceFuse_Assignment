package classes;

import java.sql.SQLException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class formvalidation {
	 static WebDriver driver;
	 DataBaseConnection db = new DataBaseConnection();
	

  @BeforeMethod
  public void setup() 
  {
	  System.setProperty("webdriver.chrome.driver","src/Driver/chromedriver2.exe");
	  driver = new ChromeDriver();
	  String username = "sfwebhtml";
	  String password = "t63KUfxL5vUyFLG4eqZNUcuRQ";

	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
	 driver.get("http://"+username+":"+password+"@sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
	 
  }
 
  @Test(priority=1)
  public void verifyPageTitleTest() 
  {
	boolean flag =  driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
	Assert.assertTrue(flag,"**[ASSERT FAILED]: Form Title image is not displayed");
	  System.out.println("**[ASSERT PASSED]: Form Title image is displayed"); 
	  
	  
  }
  
 //Try to submit without filling required fields and "Labels" of all the required fields printed on Console 
 
  @Test (priority=2)
  public void submitWithoutFill() 
  {
    WebElement SubmitButton =  driver.findElement(By.xpath("//button[text()='Submit Form']"));
    SubmitButton.isDisplayed();
    SubmitButton.click();
	  
	LogEntries entry =driver.manage().logs().get(LogType.BROWSER);
	LogEntries entry2 =driver.manage().logs().get(LogType.CLIENT);
	LogEntries entry3 =driver.manage().logs().get(LogType.DRIVER);
	List<LogEntry> logs = entry.getAll();
	List<LogEntry> logs2 = entry2.getAll();
	List<LogEntry> logs3 = entry3.getAll();

	
	for(LogEntry log: logs) 
	{
		System.out.println("Message : \n" +log.getMessage());
		System.out.println("Level is : \n" +log.getLevel());
	}
	
	System.out.println("");
	
  }
  
// Verify all input fields using Hard assertions
  
  @Test (priority=3)
  public void verifyInputFields_hardAssert()
  {
	  WebElement fname =  driver.findElement(By.xpath("//div[@id='fnameInput']"));
	  WebElement lname =  driver.findElement(By.xpath("//div[@id='lnameInput']"));
	  WebElement email =  driver.findElement(By.xpath("//div[@id='emailInput']"));
	  WebElement currentCompany =  driver.findElement(By.xpath("//div[@id='curCompanyInput']"));
	  WebElement mobNo =  driver.findElement(By.xpath("//div[@id='mobInput']"));
	  WebElement dob =  driver.findElement(By.xpath("(//div[contains(@class, 'date')])[1]"));
	  WebElement position =  driver.findElement(By.xpath("//div[@id='positionInput']"));
	  WebElement portfolioWeb =  driver.findElement(By.xpath("//div[@id='portfolioInput']"));
	  WebElement salaryRequirements  =  driver.findElement(By.xpath("//div[@id='salaryInput']"));
	  WebElement doj =  driver.findElement(By.xpath("//div[@id='whenStartInput']"));
	  WebElement address =  driver.findElement(By.xpath("//div[@id='addressInput']"));
	  WebElement uploadFile =  driver.findElement(By.xpath("//input[@type='file']"));

	  Assert.assertTrue(fname.isDisplayed(),"**[ASSERT FAILED]: First name text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: First name text box is displayed");
	  Assert.assertTrue(lname.isDisplayed(),"**[ASSERT FAILED]: Last name text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Last name text box is displayed");
	  Assert.assertTrue(email.isDisplayed(),"**[ASSERT FAILED]: Email text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Email text box is displayed");
	  Assert.assertTrue(currentCompany.isDisplayed(),"**[ASSERT FAILED]: Current company text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Current company text box is displayed");
	  Assert.assertTrue(mobNo.isDisplayed(),"**[ASSERT FAILED]:Mobile no text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Mobile no text box is displayed");
	  Assert.assertTrue(dob.isDisplayed(),"**[ASSERT FAILED]: Date of birth text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Date of birth text box is displayed");
	  Assert.assertTrue(position.isDisplayed(),"**[ASSERT FAILED]: Position text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Position text box is displayed");
	  Assert.assertTrue(portfolioWeb.isDisplayed(),"**[ASSERT FAILED]: Portfolio Web link text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Portfolio Web link text box is displayed");
	  Assert.assertTrue(salaryRequirements.isDisplayed(),"**[ASSERT FAILED]: Salary Requirements text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Salary Requirements text box is displayed");
	  Assert.assertTrue(doj.isDisplayed(),"**[ASSERT FAILED]: Date of Joining text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Date of Joining text box is displayed");
	  Assert.assertTrue(address.isDisplayed(),"**[ASSERT FAILED]: Address text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Address text box is displayed");
	  Assert.assertTrue(uploadFile.isDisplayed(),"**[ASSERT FAILED]: Upload Resume input is not displayed");
	  System.out.println("**[ASSERT PASSED]: Upload Resume input is displayed");
	    
  }
  
  
//Verify all input fields using Soft assertions  
  
  @Test (priority=4)
  public void verifyInputFields_SoftAssert()
  {
	  WebElement fname =  driver.findElement(By.xpath("//div[@id='fnameInput']"));
	  WebElement lname =  driver.findElement(By.xpath("//div[@id='lnameInput']"));
	  WebElement email =  driver.findElement(By.xpath("//div[@id='emailInput']"));
	  WebElement currentCompany =  driver.findElement(By.xpath("//div[@id='curCompanyInput']"));
	  WebElement mobNo =  driver.findElement(By.xpath("//div[@id='mobInput']"));
	  WebElement dob =  driver.findElement(By.xpath("(//div[contains(@class, 'date')])[1]"));
	  WebElement position =  driver.findElement(By.xpath("//div[@id='positionInput']"));
	  WebElement portfolioWeb =  driver.findElement(By.xpath("//div[@id='portfolioInput']"));
	  WebElement salaryRequirements  =  driver.findElement(By.xpath("//div[@id='salaryInput']"));
	  WebElement doj =  driver.findElement(By.xpath("//div[@id='whenStartInput']"));
	  WebElement address =  driver.findElement(By.xpath("//div[@id='addressInput']"));
	  WebElement uploadFile =  driver.findElement(By.xpath("//input[@type='file']"));
	  
	  SoftAssert softAssertion= new SoftAssert();
	  System.out.println("softAssert Method Was Started");

	  softAssertion.assertTrue(fname.isDisplayed(),"**[ASSERT FAILED]: First name text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: First name text box is displayed");
	  softAssertion.assertTrue(lname.isDisplayed(),"**[ASSERT FAILED]: Last name text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Last name text box is displayed");
	  softAssertion.assertTrue(email.isDisplayed(),"**[ASSERT FAILED]: Email text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Email text box is displayed");
	  softAssertion.assertTrue(currentCompany.isDisplayed(),"**[ASSERT FAILED]: Current company text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Current company text box is displayed");
	  softAssertion.assertTrue(mobNo.isDisplayed(),"**[ASSERT FAILED]:Mobile no text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Mobile no text box is displayed");
	  softAssertion.assertTrue(dob.isDisplayed(),"**[ASSERT FAILED]: Date of birth text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Date of birth text box is displayed");
	  softAssertion.assertTrue(position.isDisplayed(),"**[ASSERT FAILED]: Position text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Position text box is displayed");
	  softAssertion.assertTrue(portfolioWeb.isDisplayed(),"**[ASSERT FAILED]: Portfolio Web link text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Portfolio Web link text box is displayed");
	  softAssertion.assertTrue(salaryRequirements.isDisplayed(),"**[ASSERT FAILED]: Salary Requirements text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Salary Requirements text box is displayed");
	  softAssertion.assertTrue(doj.isDisplayed(),"**[ASSERT FAILED]: Date of Joining text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Date of Joining text box is displayed");
	  softAssertion.assertTrue(address.isDisplayed(),"**[ASSERT FAILED]: Address text box is not displayed");
	  System.out.println("**[ASSERT PASSED]: Address text box is displayed");
	  softAssertion.assertTrue(uploadFile.isDisplayed(),"**[ASSERT FAILED]: Upload Resume input is not displayed");
	  System.out.println("**[ASSERT PASSED]: Upload Resume input is displayed");
	  softAssertion.assertAll();
	    
  }
  
  
//Submit the form after filling all details properly by using XPath only
  
  @Test (priority=5)
  public void verifyFillDetails() throws SQLException
  {
	  WebElement fname =  driver.findElement(By.xpath("(//input[@type='text'])[1]"));
	  WebElement lname =  driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	  WebElement email =  driver.findElement(By.xpath("//input[@type='email']"));
	  WebElement currentCompany =  driver.findElement(By.xpath("(//input[@type='text'])[3]"));
	  WebElement mobNo =  driver.findElement(By.xpath("//input[@type='tel']"));
	  WebElement dob =  driver.findElement(By.xpath("(//input[@type='text'])[4]"));
	  WebElement position =  driver.findElement(By.xpath("(//input[@type='text'])[5]"));
	  WebElement portfolioWeb =  driver.findElement(By.xpath("//input[@type='url']"));
	  WebElement salaryRequirements  =  driver.findElement(By.xpath("(//input[@type='text'])[6]"));
	  WebElement doj =  driver.findElement(By.xpath("(//input[@type='text'])[7]"));
	  WebElement address =  driver.findElement(By.xpath("//textarea[@id='address']"));
	  WebElement uploadFile =  driver.findElement(By.xpath("//input[@id='resume']"));
	  WebElement relocateRadioBtn =  driver.findElement(By.xpath("//input[@id='notSure']"));
	  WebElement SubmitBtn = driver.findElement(By.xpath("//button[text()='Submit Form']"));
	  
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  
	  
	  fname.click();
	  fname.sendKeys("Shivani");
	  lname.click();
	  lname.sendKeys("Chauhan");
	  email.click();
	  email.sendKeys("schauhan9703@gmail.com");
	  currentCompany.click();
	  currentCompany.sendKeys("QA Infotech - A QUALITEST COMPANY");
	  mobNo.click();
	  mobNo.sendKeys("9958726837");
	  dob.click();
	  dob.sendKeys("05/05/1998");
	  position.click();
	  position.sendKeys("Automation Engineer");
	  
	  portfolioWeb.click();
	  portfolioWeb.clear();
	  portfolioWeb.sendKeys("https://linkedin.com/in/linkedin.com/in/shivani-chauhan9803");
	  
	  salaryRequirements.click();
	  salaryRequirements.sendKeys("15 LPA");
	  doj.click();
	  doj.sendKeys("After 90 Days");
	  address.click();
	  address.sendKeys("C-32, G-2, DLF Dilshad Ex-2nd Bhopura Ghaziabad UP-201005");
	  uploadFile.sendKeys("C:\\Users\\shivani.chauhan\\Desktop\\Shivani__Resume.pdf");
      relocateRadioBtn.click();
      SubmitBtn.click();
      System.out.print("Click on Submit Button");
      hardWait(5);
      
// DataBase Connectivity
      db.database();
      
  }
  

@AfterMethod
  public void tearDown()
  {
	  hardWait(10);
	  driver.quit();
  }
  

protected void hardWait(int sec)
{
	try {
		Thread.sleep(sec*1000);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
