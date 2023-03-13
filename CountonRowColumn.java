package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountonRowColumn {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
int rowsize=findElements.size();
System.out.println(rowsize);
List<WebElement> findElements1 = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody//td"));
	int columnsize=findElements1.size();
System.out.println(columnsize);
driver.close();
}

}
