package pageobjectmodel.adminhelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Admin {
    private WebDriver driver;
    private By searchInput = By.id("searchSystemUser_userName");
    private By clickSearchButton = By.id("searchBtn");
    private By clickOnEssUserLindaAnderson = By.linkText("linda.anderson");
    private By selectUser = By.name("chkSelectRow[]");
    private By editButton = By.id("btnSave");
    private By deleteButton = By.id("btnDelete");
    private By deleteConfirmationButton = By.id("dialogDeleteBtn");
    private By statusAlert = By.linkText("No Records Found");
    private By userRole = By.id("systemUser_userType");
    private By addUserButton = By.id("btnAdd");

    public Admin(WebDriver driver) {
        this.driver = driver;
    }

    public AddUsers addUsers() {
        driver.findElement(addUserButton).click();
        return new AddUsers(driver);
    }

    public EditUser searchUser(String searchUser) {
        driver.findElement(searchInput).sendKeys(searchUser);
        driver.findElement(clickSearchButton).click();
        driver.findElement(selectUser).click();
        driver.findElement(clickOnEssUserLindaAnderson).click();
        return new EditUser(driver);
    }

    public boolean isAddButtonDisplayed() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(addUserButton).isDisplayed();
    }
    public void deleteUser() {
        driver.findElement(deleteButton).click();
        driver.findElement(deleteConfirmationButton).click();
    }

    public int numberOfUsersBefore() {
        List<WebElement> menuItems = driver.findElements(By.tagName("tr"));
        return menuItems.size();
    }

    public int countUsersAfterDelete() {
        List<WebElement> menuItems = driver.findElements(By.tagName("tr"));
        return menuItems.size();
    }

    public void editUser() {
        driver.findElement(selectUser).click();
        driver.findElement(editButton);
    }
}
