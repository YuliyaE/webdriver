package test.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestFrameData {
    private WebDriver driver;
    private CloudPlatformPricingCalculator test;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        GoogleCloudPlatform.openCalculator(driver);
        test = new CloudPlatformPricingCalculator(driver);
        test.estimateRentCost("4");
        driver.switchTo().frame("idIframe");
    }

    @Test
    public void testVMClass(){
        WebElement element = driver.findElement(By.id("select_option_60"));
        String actual = element.getAttribute("value");
        String expected = "regular";
       assertEquals(actual, expected );
    }

    @Test
    public void testInstanceType(){
        WebElement element = driver.findElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"));
        String actual = element.getAttribute("value");
        String expected = "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8";
        assertEquals(actual, expected );
    }

    @Test
    public void testRegion(){
        WebElement element = driver.findElement(By.xpath("//md-option[@id='select_option_196' and @value='europe-west3']"));
        String actual = element.getAttribute("value");
        String expected = "europe-west3";
        assertEquals(actual, expected );
    }

    @Test
    public void testLocalSSD(){
        WebElement element = driver.findElement(By.xpath("//md-option[@id='select_option_182' and @value='2']"));
        String actual = element.getAttribute("value");
        String expected = "2";
        assertEquals(actual, expected );
    }

    @Test
    public void testCommitmentTerm(){
        WebElement element = driver.findElement(By.xpath("//md-option[@id='select_option_100' and @value='1']"));
        String actual = element.getAttribute("value");
        String expected = "1";
        assertEquals(actual, expected );
    }

    @Test
    public void testRentCostValue(){
        String actual = test.getRentCost();
        String expected = "Total Estimated Cost: USD 1,187.77 per 1 month";
        assertEquals(actual, expected );
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
