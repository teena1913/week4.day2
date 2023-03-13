package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleframe {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.switchTo().frame(0);
		WebElement findElement1 = driver.findElement(By.xpath("//button[@id='Click']"));
		findElement1.click();
		System.out.println(findElement1.getText());
		driver.switchTo().defaultContent();//access to bring to main page
		 //count frames step
	    driver.switchTo().frame(1);
		WebElement findElement2 = driver.findElement(By.xpath("//button[@id='Click']"));
		findElement2.click();
		System.out.println(findElement2.getText());
		driver.switchTo().defaultContent();
		
		WebElement findElement3 = driver.findElement(By.xpath("(//div[@class='card']/iframe)[3]"));
		 driver.switchTo().frame(findElement3);//by webelement can switch
		 driver.switchTo().frame("frame2");
		 driver.findElement(By.xpath("//button[@id='Click']")).click();
		 driver.switchTo().defaultContent();
	}

}
