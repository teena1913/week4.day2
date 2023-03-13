package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act=new Actions(driver);
		//act.moveToElement(null).perform();
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		act.moveToElement(brand).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='css-ov2o3v']/a")).click();
	    System.out.println(driver.getTitle());
	   WebElement hair = driver.findElement(By.xpath("//a[text()='hair']"));
	   act.moveToElement(hair).perform();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//a[text()='Shampoo']")).click();
	   Set<String> wind=driver.getWindowHandles();
	   List<String> win=new ArrayList<String>(wind);
	   driver.switchTo().window(win.get(1));
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//span[text()='Concern']")).click();
	   String aa=driver.findElement(By.xpath("//span[text()='2620']")).getText();
	   driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	   String bb=driver.findElement(By.xpath("//span[text()='284']")).getText();
	   Thread.sleep(1000);
	  if(aa.equals(bb)) {
		  System.out.println("no filter applied");
	  }
	  else {
		  System.out.println("filters applied");
	  }
	  driver.findElement(By.xpath("//input[@class='css-1upamjb']")).sendKeys("loreal pariscolor protected shampoo",Keys.ENTER);
	  driver.findElement(By.xpath("//div[@class='css-43m2vm']")).click();
	  Thread.sleep(1000);
	  Set<String> window=driver.getWindowHandles();
	   List<String> wind1=new ArrayList<String>(window);
	  driver.switchTo().window(wind1.get(2));
	  
	driver.findElement(By.xpath("//span[text()='180ml']")).click();
	Thread.sleep(1000);
	String price=driver.findElement(By.xpath("//div[@class='css-1d0jf8e']")).getText();	
	System.out.println(price); 
	
	driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
	driver.findElement(By.xpath("//span[@class='cart-count']")).click();
	driver.switchTo().frame(0);
	Thread.sleep(1000);
  String grandtotal = driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']")).getText();
  System.out.println("grangtotal is "+grandtotal);
	driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	driver.findElement(By.xpath("//div[@class='css-gecnnw eqr1d9n12']")).click();
	String finalprice=driver.findElement(By.xpath("//p[text()='₹259']")).getText();
	System.out.println("finalprice is "+finalprice);
	if(grandtotal.equals(finalprice)) {
		System.out.println("same price");
	}else {
		System.out.println("Different price");
	}

	}
}
//output:
//Buy L'Oreal Paris products online at best price on Nykaa | Nykaa
//filters applied
//MRP:
//₹209
//grangtotal is₹259
//finalprice is₹259
//same price
