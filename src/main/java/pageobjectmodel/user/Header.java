package pageobjectmodel.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;
    private By pimButton = By.linkText("PIM");
    private By leaveButton = By.linkText("Leave");
    private By timeButton = By.linkText("Time");
    private By myInfoButton = By.id("menu_pim_viewMyDetails");
    private By performanceButton = By.id("menu__Performance");
    private By welcomeStatusText = By.id("welcome");
    private By contactDetailsButton = By.linkText("Contact Details");
    private By dashboardButton = By.id("menu_dashboard_index");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetails clickMyInfo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(myInfoButton).click();
        return new PersonalDetails(driver);
    }
}
