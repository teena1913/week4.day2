package Jquery;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ReSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option); 
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://jqueryui.com/resizable/"); 
		  driver.switchTo().frame(0);
		  WebElement y = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
		  WebElement diagonal = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		  WebElement x = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']"));
		  WebElement move = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-resizable']"));
		  Actions obj=new Actions(driver);
		  obj.dragAndDrop(x, move).perform();
		  obj.dragAndDrop(y, move).perform();
		  obj.dragAndDrop(diagonal, move).perform();
		  driver.close();
	}

}
