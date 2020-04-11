package pageobjectmodel.user;

import pageobjectmodel.adminhelper.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static final String ORANGEHRM_VIEW_MY_INFO = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails";
    WebDriver driver;
    private By userName = By.id("txtUsername");
    private By password = By.id("txtPassword");
    private By submitButton = By.id("btnLogin");
    private By status = By.id("spanMessage");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void setPassword(String passwordUser) {
        driver.findElement(password).sendKeys(passwordUser);
    }

    public Dashboard clickLoginButton() {
        driver.findElement(submitButton).click();
        return new Dashboard(driver);
    }

    public PersonalDetails clickMyInfoHeader() {
        driver.findElement(submitButton).click();
        String actualUrl = driver.getCurrentUrl();
        if (ORANGEHRM_VIEW_MY_INFO.contentEquals(actualUrl)) {
            return new PersonalDetails(driver);
        }
        throw new IllegalStateException("User navigation not as expected.");
    }

    public Header loginWithAdmin() {
        driver.findElement(userName).sendKeys("admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(submitButton).click();
        return new Header(driver);
    }

    public Dashboard loginWithEssUser() {
        driver.findElement(userName).sendKeys("linda.anderson");
        driver.findElement(password).sendKeys("linda123");
        driver.findElement(submitButton).click();
        return new Dashboard(driver);
    }

    public String getValidationText() {
        return driver.findElement(status).getText();
    }


}
