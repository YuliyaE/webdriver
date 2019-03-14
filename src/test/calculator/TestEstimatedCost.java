package test.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static test.calculator.GoogleCloudPlatform.getRandomEmail;
import static test.calculator.GoogleCloudPlatform.openCalculator;
import static test.calculator.GoogleCloudPlatform.readEmail;

public class TestEstimatedCost {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        openCalculator(driver);

        CloudPlatformPricingCalculator calculator;
        calculator = new CloudPlatformPricingCalculator(driver);
        calculator.estimateRentCost("4");

        String parentWindowId = driver.getCurrentUrl();
        String email = getRandomEmail(driver);
        driver.navigate().to(parentWindowId);
        calculator.confirmRentCostEstimation(email);
        readEmail(driver);
    }

    @Test
    public void testTotalEstimatedCostFromEmail() {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'USD')]"));
        String actual = element.getText();
        String expected = "Estimated Monthly Cost: USD 1,187.77";
        assertEquals(actual, expected);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
