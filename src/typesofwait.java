import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class typesofwait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium driver\\chromedriver-win64\\chromedriver-win64.exe");
		driver.manage().window().maximize();
		//explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String[] names = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Thread.sleep(3000);
		System.out.println(driver.getTitle());
		additems(driver, names);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		
				
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());

	}
	public static void additems(WebDriver driver, String[] names)
	{
		int j =0;
		List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		
		for(int i=0;i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();
			//format the name to get the actual vegetable name
			//Convert array into array list using easy search
			//Check whether the name you extracted is present in the array list or not
			
			List items = Arrays.asList(names);
			
			if(items.contains(formattedname))
					{
				//add to cart
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if(j==names.length)
				{
					break;
				}
				
				
				
					}
			System.out.println("Post 3");
			System.out.println("Post 4");
			System.out.println("Post 5");
			System.out.println("Post 6");
			
			
		}
		
		
	}

}
