package week4.day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stockmarket {
public static void main(String[] args) {
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.chittorgarh.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.findElement(By.linkText("STOCK MARKET")).click();
	driver.findElement(By.linkText("NSE Bulk Deals")).click();
	List<WebElement> findElements1 = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr/td[1]"));
	Set<String> dup=new HashSet<String>();
	int row=findElements1.size();
	System.out.println(row);
	for(int i=1;i<findElements1.size();i++) {
		String security=driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr[" +i+ "]/td[1]")).getText();
System.out.println(security);
dup.add(security);
	}
	System.out.println(dup);
	System.out.println(dup.size());
	if(findElements1.size()==dup.size()) {
		System.out.println("no duplicates present");
	}
	else {
System.out.println("duplicates present");
	}
	
}
}
