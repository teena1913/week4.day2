package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintRowColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> findElements1 = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		int rowsize=findElements1.size();
		List<WebElement> findElements2 = driver.findElements(By.xpath("//div[@class='render']/table/tbody//td"));
		int rowsize1=findElements2.size();
		for(int i=1;i<rowsize;i++)
			for(int j=1;j<rowsize1;j++) {
				String aaa=driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.println(aaa); 
				
			}
	}
}

