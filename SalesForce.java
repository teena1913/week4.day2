package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce {
public static void main(String[] args) throws InterruptedException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	ChromeDriver driver=new ChromeDriver(option);
	driver.get("https://qeagle-dev-ed.my.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	driver.findElement(By.id("password")).sendKeys("Leaf@123");
	driver.findElement(By.id("Login")).click();
	driver.findElement(By.xpath("//span[text()='Learn More']")).click();
	Set<String> window=driver.getWindowHandles();
	List<String> win=new ArrayList<String>(window);
	Thread.sleep(1000);
	driver.switchTo().window(win.get(1));
	driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	driver.getTitle();
	driver.switchTo().window(win.get(0));
	Thread.sleep(1000);
	driver.quit();
	
}
}



