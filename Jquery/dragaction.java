package Jquery;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragaction {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		Actions opt=new Actions(driver);
		opt.dragAndDropBy(findElement, 100, 70).perform();
		Thread.sleep(1000);
		driver.close();
		

}
}