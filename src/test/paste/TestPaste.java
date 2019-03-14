package test.paste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestPaste {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        NewPasteHowToGainDominance paste = new NewPasteHowToGainDominance();
        paste.createNewPaste(driver);
    }

    @Test
    public void testPasteName(){
        WebElement searchElement = driver.findElement(By.className("paste_box_line1"));
        String actual = searchElement.getAttribute("title");
        String expected = "how to gain dominance among developers";
        assertEquals(actual, expected);
    }

    @Test
    public void testSyntaxHighlighting(){
        WebElement element = driver.findElement(By.className("h_640"));
        String actual = element.getText();
        String expected = "Bash";
        assertEquals(actual,expected);
    }

    @Test
    public void testEnteredCode(){
        WebElement element = driver.findElement(By.id("paste_code"));
        String actual = element.getText();
        String expected = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        assertEquals(actual, expected);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
