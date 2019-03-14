package test.paste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewPasteHowToGainDominance {

    public void createNewPaste(WebDriver driver) {
        WebElement searchInput = driver.findElement(By.id("paste_code"));
        searchInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        Select syntaxHighlighting = new Select(driver.findElement(By.name("paste_format")));
        syntaxHighlighting.selectByVisibleText("Bash");

        Select pasteExpiration = new Select(driver.findElement(By.name("paste_expire_date")));
        pasteExpiration.selectByValue("10M");

        WebElement searchName = driver.findElement(By.name("paste_name"));
        searchName.sendKeys("how to gain dominance among developers");

        driver.findElement(By.name("submit")).click();

    }

}
