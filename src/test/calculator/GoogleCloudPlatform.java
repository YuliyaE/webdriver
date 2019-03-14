package test.calculator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatform {

    public static void openCalculator(WebDriver driver) {
        driver.manage().window().maximize();

        WebElement searchButtonExploreProducts = driver.findElement(By.xpath("//*[@class='cloud-button cloud-button--primary' and @href='https://cloud.google.com/products/']"));
        searchButtonExploreProducts.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='cloud-button cloud-button--secondary' and @href='https://cloud.google.com/pricing/']")));
        WebElement searchButtonSeePricing = driver.findElement(By.xpath("//*[@class='cloud-button cloud-button--secondary' and @href='https://cloud.google.com/pricing/']"));
        searchButtonSeePricing.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@href='https://cloud.google.com/pricing/calculators' and @track-type='inPageNav']")));
        WebElement searchCalculator = driver.findElement(By.xpath("//*[@href='https://cloud.google.com/pricing/calculators' and @track-type='inPageNav']"));
        searchCalculator.click();
    }

    public static String getRandomEmail(WebDriver driver) {
        driver.navigate().to("https://10minutemail.com");
        WebElement element = driver.findElement(By.id("mailAddress"));
        return element.getAttribute("value");
    }

    public static void readEmail(WebDriver driver) {
        driver.navigate().to("https://10minutemail.com");
        new WebDriverWait(driver, 600).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='inc-mail-address']")));
        driver.findElement(By.xpath("//span[@class='inc-mail-address']")).click();
    }
}