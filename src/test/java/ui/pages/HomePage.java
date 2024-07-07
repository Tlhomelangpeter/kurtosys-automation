package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver webDriver;

    private final By whitePapersLink = By.linkText("White Papers & eBooks");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOnWhitePapersAndeBooks() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement whitePapersEle = wait.until(ExpectedConditions.elementToBeClickable(whitePapersLink));
        whitePapersEle.click();
    }
}
