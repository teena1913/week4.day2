package Jquery;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dropaction {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement findElement1 = driver.findElement(By.xpath("//p[text()='Drop here']"));
		Actions will=new Actions(driver);
		will.dragAndDrop(findElement, findElement1).perform();
		Thread.sleep(1000);
		driver.close();
	}

}
