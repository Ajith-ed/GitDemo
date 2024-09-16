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

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium driver\\chromedriver-win64\\chromedriver-win64");
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		String[] names = { "iphone", "Samsung", "Nokia", "Blackberry" };
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));

		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("//label/input[@value='user']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='okayBtn']")));
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();

		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.cssSelector("input[class*='btn']")).click();

		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'ProtoCommerce Home')] ")));
		driver.findElement(By.xpath("//a[contains(text(), 'ProtoCommerce Home')] "));
		additems(driver, names);
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

	public static void additems(WebDriver driver, String[] names) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

		for (int i = 0; i < products.size(); i++) {
			String[] split = products.get(i).getText().split(" ");
			String formattedname = split[0].trim();

			List device = Arrays.asList(names);

			if (device.contains(formattedname)) {
				j++;
				driver.findElements(By.cssSelector("button[class*='btn']")).get(i).click();
				if (j == names.length) {
					break;
				}

			}

		}
		System.out.println("Success");
		System.out.println("New Branch");
		System.out.println("Welcome");

	}

}
