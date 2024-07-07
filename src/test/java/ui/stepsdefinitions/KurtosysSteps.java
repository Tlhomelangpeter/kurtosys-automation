package ui.stepsdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.DownloadWhitePaperPage;
import ui.pages.HomePage;
import ui.pages.WhitePaperPage;

import java.io.IOException;

public class KurtosysSteps {
    WebDriver webDriver = new ChromeDriver();
    WhitePaperPage whitePaperPage;
    DownloadWhitePaperPage downloadWhitePaperPage;

    @Given("I am on the Kurtosys homepage")
    public void navigateToHomePage() {
        webDriver.get("https://www.kurtosys.com/");
        webDriver.manage().window().maximize();
    }

    @When("I navigate to White Papers & eBook from Resources")
    public void navigateToWhitePapersAndeBooksFromResources() {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnWhitePapersAndeBooks();
    }

    @And("I click on a white paper titled UCITS Whitepaper")
    public void clickOnPage() {
        whitePaperPage = new WhitePaperPage(webDriver);
        whitePaperPage.clickUcitsWhitePaperLink();
    }

    @And("I fill in the personal information fields except email field")
    public void enterPersonalDetails() {
        downloadWhitePaperPage = new DownloadWhitePaperPage(webDriver);
        downloadWhitePaperPage.enterFirstName("TestMe");
        downloadWhitePaperPage.enterLastName("Dummy");
        downloadWhitePaperPage.enterCompany("Automation Inc");
        downloadWhitePaperPage.enterIndustry("IT");
        downloadWhitePaperPage.clearEmail();
    }

    @And("I click on Send me a copy")
    public void clickButton() throws InterruptedException {
        downloadWhitePaperPage.clickSendMeACopy();
    }

    @Then("I should see error messages regarding the necessary fields")
    public void checkErrorValidationMessage() throws IOException {
        String errorMessage = downloadWhitePaperPage.getErrorMessage();

        if (!errorMessage.isEmpty()) {
            downloadWhitePaperPage.takeScreenshot("errorScreenshot.png");
        }
    }

    @After
    public void close() {
       if (webDriver != null) {
           webDriver.quit();
       }
    }
}
