package AutomationPractice1;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EcomOrder extends BaseTest
{
private static final Logger log = Logger.getLogger(EcomOrder.class);
	
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("loading the Properties files.....");
		
		launch("chromebrowser");
		log.info("Launching the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("automationpracticeurl");
		log.info("Navigated to url : " + childProp.getProperty("automationpracticeurl"));
		
		
		driver.findElement(By.linkText("Sign in")).click();
		  //Login
		  driver.findElement(By.id("email")).sendKeys("chandrasgangula39@gmail.com");
		  driver.findElement(By.id("passwd")).sendKeys("Chandra@11");
		  driver.findElement(By.id("SubmitLogin")).click();
		  //Click on Women
		  driver.findElement(By.linkText("WOMEN")).click();

		  WebElement FirstImg=driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
		  WebElement MoreBtn=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[2]/span[1]"));
		  Actions actions=new Actions(driver);
		  actions.moveToElement(FirstImg).moveToElement(MoreBtn).click().perform();

		  //Change quantity by 2
		  driver.findElement(By.id("quantity_wanted")).clear();
		  driver.findElement(By.id("quantity_wanted")).sendKeys("2");

		  //Select size as L
		  WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
		  Select oSelect=new Select(Sizedrpdwn);
		  oSelect.selectByVisibleText("M");

		  //Select Color
		  driver.findElement(By.id("color_14")).click();

		  //Click on add to cart
		  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		  Thread.sleep(5000);
		  
		  //Click on proceed
		  driver.findElement(By.xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")).click();
		  //Checkout page Proceed
		  driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")).click();
		  driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
		  //Agree terms&Conditions
		  driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		  driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();

		  //Click on Payby Check
		  driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/p[1]/a[1]")).click();
		  //Confirm the order
		  driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();

		  //Get Text
		  String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
		  
		  // Verify that Product is ordered
		  if(ConfirmationText.contains("complete")) 
		  {
		   System.out.println("Order Completed: Test Case Passed");
		  }
		  else 
		  {
		   System.out.println("Order Not Successfull: Test Case Failed");
			
			driver.quit();
		  }

	}

}
