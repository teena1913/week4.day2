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
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='NOT NOW']")).click();
		driver.findElement(By.className("navlink")).click();
		driver.findElement(By.className("linkTest")).click();
		WebElement aa = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
	    String bb =aa.getText();
		System.out.println(bb);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		WebElement sortby=driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"));
		String cc=sortby.getText();
		//Mouse syntax
		Actions build=new Actions(driver);
		build.moveToElement(sortby).click(sortby).perform();
		Thread.sleep(1000);
		WebElement sortby1=driver.findElement(By.xpath("(//li[@class='search-li'])"));
		String dd=sortby1.getText();
		build.moveToElement(sortby1).click(sortby1).perform();
		if(cc.equals(dd)) {
			System.out.println("not sorted");
		}
		else {
			System.out.println("sorted");
		}
		driver.findElement(By.xpath("//span[text()='Sports Shoes for Men']")).click();
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200",Keys.ENTER);
		Thread.sleep(1000);
        WebElement vew=driver.findElement(By.xpath("//button[text()='View More ']"));
        build.scrollByAmount(182, 493).moveToElement(vew).click(vew).perform();
        driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
        WebElement price=driver.findElement(By.xpath("//div[@class='navFiltersPill']"));
        String rs=price.getText();
        WebElement color=driver.findElement(By.xpath("(//div[@class='navFiltersPill'])[2]"));
        String col=color.getText();
        if(rs.equals(col)) {
        	System.out.println("filters not applied");
        }
        else {
        	System.out.println("filters applied");
        }
        Thread.sleep(1000);
        WebElement shoe=driver.findElement(By.xpath("//img[@class='product-image wooble']"));
        build.moveToElement(shoe).click(shoe).perform();
        Thread.sleep(1000);
        // windows syntax
        Set<String> wind=driver.getWindowHandles();
        List<String> win= new ArrayList<String>(wind);
        driver.switchTo().window(win.get(1));
        Thread.sleep(1000);
        WebElement pri=driver.findElement(By.xpath("//div[@class='pdp-e-i-PAY-r disp-table-cell lfloat']/span"));
        String ps=pri.getText();
        System.out.println(ps);
        WebElement dis=driver.findElement(By.xpath("(//div[@class='pdp-e-i-PAY-r disp-table-cell lfloat']/span)[2]"));
        String dp=dis.getText();
        System.out.println(dp);
        driver.switchTo().window(win.get(0));
     //snapshot syntax   
        File screenshotAs = shoe.getScreenshotAs(OutputType.FILE);
        File destn=new File("./snap/shot2.png");
        FileUtils.copyFile(screenshotAs, destn);
        driver.close();
        driver.quit();
	}
	

}






