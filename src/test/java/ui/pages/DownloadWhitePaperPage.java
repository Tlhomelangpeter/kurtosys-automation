package ui.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DownloadWhitePaperPage {
    private final WebDriver webDriver;

    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");
    private final By personalInfoIframe = By.cssSelector("iframe.optanon-category-C0002");
    private final By firstNameField = By.id("18882_231669pi_18882_231669");
    private final By lastNameField = By.id("18882_231671pi_18882_231671");
    private final By companyField = By.id("18882_231675pi_18882_231675");
    private final By industryField = By.id("18882_231677pi_18882_231677");
    private final By emailField = By.id("18882_231673pi_18882_231673");
    private final By sendMeACopyButton = By.xpath("//input[@type='submit' and @value='Send me a copy']");
    private final By errorMessageText = By.cssSelector("p.error.no-label");

    public DownloadWhitePaperPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        acceptCookiesIfPresent();
    }

    private void switchToFrame() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(personalInfoIframe));
        webDriver.switchTo().frame(iframeElement);
    }

    public void enterFirstName(String firstName) {
        switchToFrame();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement firstNameEle = wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        firstNameEle.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        webDriver.findElement(companyField).sendKeys(company);
    }

    public void enterIndustry(String industry) {
        webDriver.findElement(industryField).sendKeys(industry);
    }

    public void clearEmail() {
        webDriver.findElement(emailField).clear();
    }

    public void clickSendMeACopy() {
        webDriver.findElement(sendMeACopyButton).click();
    }

    public String getErrorMessage() {
        return webDriver.findElement(errorMessageText).getText();
    }

    public void acceptCookiesIfPresent() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            if (button.isDisplayed()) {
                button.click();
            }
        } catch (Exception e) {
            System.out.println("Cookie consent button not found or no longer present.");
        }
    }

    public void takeScreenshot(String filename) throws IOException {
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filename));
    }
}
