
package week4.day2;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	ChromeDriver driver=new ChromeDriver(option);
	driver.get("https://www.myntra.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Actions act= new Actions(driver);
	WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
	act.moveToElement(men).perform();
	driver.findElement(By.xpath("//a[text()='Jackets']")).click();
 String aa=driver.findElement(By.xpath("//div[@class='title-container']")).getText();
 System.out.println(aa);
	String bb=driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
	System.out.println(bb);
	Thread.sleep(1000);
	if(aa.equals(bb)) {
		System.out.println("count matches");
	}else {
		System.out.println("count not matched");
	}
	Thread.sleep(1000);
	WebElement brand = driver.findElement(By.xpath("//div[@class='brand-more']"));
	act.scrollToElement(brand).moveToElement(brand).click(brand).perform();
	driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke",Keys.ENTER);
	WebElement duke=driver.findElement(By.xpath("//label[@class=' common-customCheckbox']/input"));
	act.moveToElement(duke).click(duke).perform();
	driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	List <WebElement> dukeprice=driver.findElements(By.xpath("//h3[text()='Duke']"));
	for(WebElement element:dukeprice) {
		String price=element.getText();
		System.out.println(price);
	}
WebElement ff =	driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
act.moveToElement(ff).perform();
Thread.sleep(1000);
driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
System.out.println(price);
driver.findElement(By.xpath("//div[@class='product-imageSliderContainer']")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> handle = new ArrayList<String>(windowHandles);
driver.switchTo().window(handle.get(1));
File ss = driver.getScreenshotAs(OutputType.FILE);
File dest = new File("./snap/shot.png");
FileUtils.copyFile(ss, dest);
driver.findElement(By.xpath("//div[contains(@class,' pdp-add-to-wishlist pdp-button ')]")).click();
driver.quit();
}

}
