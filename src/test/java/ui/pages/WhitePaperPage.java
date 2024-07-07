package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WhitePaperPage {
    WebDriver webDriver;

    private final By ucitsWhitepaperLink = By.linkText("UCITS White Paper");

    public WhitePaperPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickUcitsWhitePaperLink() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement ucitsWhitepaperEle = webDriver.findElement(ucitsWhitepaperLink);
        js.executeScript("window.scrollBy(0, 190);");
        wait.until(ExpectedConditions.elementToBeClickable(ucitsWhitepaperEle));
        ucitsWhitepaperEle.click();
    }
}
