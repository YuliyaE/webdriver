package test.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPlatformPricingCalculator {

    private WebDriver driver;

    private By numberOfInstances = By.id("input_46");
    private By operatingSystem = By.id("select_58");
    private By vmClass = By.id("select_62");
    private By instanceType = By.xpath("//md-select[@placeholder='Instance type']");
    private By addGPUs = By.xpath("//*[@class='md-container md-ink-ripple']");
    private By numberOfGPUs = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private By GPUType = By.xpath("//md-select[@placeholder='GPU type']");
    private By localSSD = By.xpath("//md-select[@placeholder='Local SSD']");
    private By datacenterLocation = By.xpath("//md-select[@placeholder='Datacenter location']");
    private By commitedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private By rentCost = By.xpath("//*[contains(text(),'Total Estimated Cost:')]");

    public CloudPlatformPricingCalculator(WebDriver driver) {
        this.driver = driver;
    }

    public void clickComputeEngine() {
        driver.findElement(By.xpath("//*[contains(text(),'Compute Engine')]")).click();
    }

    public void setNumberOfInstances(String numberOfInstances) {
        driver.findElement(this.numberOfInstances).sendKeys(numberOfInstances);
    }

    public void setOperatingSystem() {
        driver.findElement(operatingSystem).click();
        driver.findElement(By.id("select_option_48")).click();
    }

    public void setVmClass() {
        driver.findElement(vmClass).click();
        driver.findElement(By.id("select_option_60")).click();
    }

    public void setInstanceType() {
        WebElement element = driver.findElement(instanceType);
        element.click();
        driver.findElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")).click();
    }

    public void setAddGPUs() {
        WebElement searchBtnAddGPUs = driver.findElement(addGPUs);
        searchBtnAddGPUs.click();
    }

    public void setNumberOfGPUs() {
        driver.findElement(numberOfGPUs).click();
        driver.findElement(By.xpath("//div[@class='md-text ng-binding' and text()='1']")).click();
    }

    public void setGPUType() {
        driver.findElement(GPUType).click();
        driver.findElement(By.xpath("//div[@class='md-text ng-binding' and text()='NVIDIA Tesla V100']")).click();
    }

    public void setLocalSSD() {
        driver.findElement(localSSD).click();
        driver.findElement(By.xpath("//div[@class='md-text ng-binding' and text()='2x375 GB']")).click();
    }

    public void setDatacenterLocation() {
        driver.findElement(datacenterLocation).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_196' and @value='europe-west3']")).click();
    }

    public void setCommitedUsage() {
        driver.findElement(commitedUsage).click();
        driver.findElement(By.xpath("//md-option[@id='select_option_100' and @value='1']")).click();
    }

    public void clickEstimate() {
        driver.findElement(By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and text()='Add to Estimate']")).click();
    }

    public String getRentCost() {
        WebElement element = driver.findElement(rentCost);
        return element.getText();
    }

    public void clickEmailEstimate() {
        driver.findElement(By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and @id='email_quote']")).click();
    }

    public void enterEmail(String email) {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
    }


    public void clickSendEmail() {
        driver.findElement(By.xpath("//button[@aria-label='Send Email']")).click();

    }

    public void estimateRentCost(String numberOfInstances) {
        driver.switchTo().frame("idIframe");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        clickComputeEngine();
        setNumberOfInstances(numberOfInstances);
        setOperatingSystem();
        setVmClass();
        setInstanceType();
        setAddGPUs();
        setNumberOfGPUs();
        setGPUType();
        setLocalSSD();
        setDatacenterLocation();
        setCommitedUsage();
        clickEstimate();
        getRentCost();
        driver.switchTo().defaultContent();
    }

    public void confirmRentCostEstimation(String email) {
        driver.switchTo().frame("idIframe");
        clickEmailEstimate();
        enterEmail(email);
        clickSendEmail();
        driver.switchTo().defaultContent();
    }

}
