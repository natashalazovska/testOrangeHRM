package pageobjectmodel.adminhelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EditUser {
    WebDriver driver;
    private By editButton = By.id("btnSave");
    private By changePasswordInput = By.id("systemUser_chkChangePassword");
    private By passwordInput = By.id("systemUser_password");
    private By confirmPasswordInput = By.id("systemUser_confirmPassword");
    private By saveButton = By.id("btnSave");
    private By searchButton = By.id("searchBtn");

    public EditUser(WebDriver driver) {
        this.driver = driver;
    }

    public void changePasswordForEssUser(String password1, String password2) {
        driver.findElement(editButton).click();
        driver.findElement(changePasswordInput).click();
        driver.findElement(passwordInput).sendKeys(password1);
        driver.findElement(confirmPasswordInput).sendKeys(password2);
        driver.findElement(saveButton).click();
    }
}
