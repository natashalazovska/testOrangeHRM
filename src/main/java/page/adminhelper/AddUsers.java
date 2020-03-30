package page.adminhelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUsers {
    WebDriver driver;
    private By userRoleDropDown = By.id("systemUser_userType");
    private By employeeNameInput = By.id("systemUser_employeeName_empName");
    private By userNameInput = By.id("systemUser_userName");
    private By statusDropDown = By.id("systemUser_status");
    private By passwordInput = By.id("systemUser_password");
    private By confirmPasswordInput = By.id("systemUser_confirmPassword");
    private By saveButton = By.name("btnSave");
    private By cancelButton = By.id("btnCancel");
    private By employeeNameValidationMessage = By.cssSelector("span[for=\"systemUser_employeeName_empName\"]");
    private By usernameLengthValidationMessage = By.cssSelector("span[for=\"systemUser_userName\"]");
    private By usernameValidationMessage = By.cssSelector("span[for=\"systemUser_userName\"]");

    private By messageForPassword = By.cssSelector("span[for=\"systemUser_password\"]");
    private By messageForConfirmPassword = By.cssSelector("span[for=\"systemUser_confirmPassword\"]");
    private By message = By.id("systemUser_password_help_text");

    public AddUsers(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserRoleDropDown(String option) {
        Select setOption = new Select(driver.findElement(userRoleDropDown));
        setOption.selectByVisibleText(option);
    }

    public void setEmployeeNameInput(String employeeName) {
        driver.findElement(employeeNameInput).sendKeys(employeeName);
    }

    public void setUserNameInput(String username) {
        driver.findElement(userNameInput).sendKeys(username);
    }

    public void setStatusDropDown(String statusOption) {
        Select setOption = new Select(driver.findElement(statusDropDown));
        setOption.selectByVisibleText(statusOption);
    }

    public Admin clickSaveButton() {
        driver.findElement(saveButton).click();
        return new Admin(driver);
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setConfirmPasswordInput(String confirmPassword) {
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public String getValidationMessageForEmployeeName() {
        return  driver.findElement(employeeNameValidationMessage).getText();
    }

    public String getValidationMessageForUsernameLength() {
        return driver.findElement(usernameLengthValidationMessage).getText();
    }

    public String getValidationMassageForUsername() {
        return driver.findElement(usernameValidationMessage).getText();
    }
}
