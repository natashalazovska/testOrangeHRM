package pageobjectmodel.adminhelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    WebDriver driver;

    private By adminMenu = By.id("menu_admin_viewAdminModule");
    private By userManagement = By.id("menu_admin_UserManagement");
    private By users = By.id("menu_admin_viewSystemUsers");

    public Header(WebDriver driver){
        this.driver = driver;
    }

    public Admin  clickSystemUser() {
        try {
            //  the page needs more time to load and we get error message NoSuchElementException, Unable to find element
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(adminMenu).click();
        driver.findElement(userManagement).click();
        driver.findElement(users).click();
        return new Admin(driver);
    }
}
