import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gitdemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium driver\\chromedriver-win64\\chromedriver-win64");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.cssSelector("input[class*='btn']")).click();

		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'ProtoCommerce Home')] ")));
		driver.findElement(By.xpath("//a[contains(text(), 'ProtoCommerce Home')] "));

	}

}
