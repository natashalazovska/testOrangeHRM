package pagefactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "txtUsername")
    private WebElement userName;
    @FindBy(id = "txtPassword")
    private WebElement password;
    @FindBy(id = "btnLogin")
    private WebElement submitButton;
    @FindBy(id = "spanMessage")
    private WebElement status;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String username) {
        userName.sendKeys(username);
    }

    public void setPassword(String passwordUser) {
        password.sendKeys(passwordUser);
    }

    public Dashboard clickLoginButton() {
        submitButton.click();
        return new Dashboard(driver);
    }

    public Dashboard loginWithEssUser() {
        userName.sendKeys("linda.anderson");
        password.sendKeys("linda123");
        submitButton.click();
        return new Dashboard(driver);
    }

    public String getValidationText() {
        return status.getText();
    }
}
