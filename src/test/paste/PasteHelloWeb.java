package test.paste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteHelloWeb {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        createNewPaste(driver);

        Thread.sleep(5000);
        driver.quit();
    }

    private static void createNewPaste(WebDriver driver) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("paste_code")));
        WebElement searchInput = driver.findElement(By.id("paste_code"));
        searchInput.sendKeys("Hello from WebDriver");

        WebElement searchName = driver.findElement(By.name("paste_name"));
        searchName.sendKeys("helloweb");

        Select pasteExpiration = new Select(driver.findElement(By.name("paste_expire_date")));
        pasteExpiration.selectByVisibleText("10 Minutes");

        driver.findElement(By.name("submit")).click();
    }

}
