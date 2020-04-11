package pageobjectmodel.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoSideNavigation {

    WebDriver driver;

    private By profilePicture = By.id("empPic");
    private By contactDetails = By.linkText("Contact Details");

    public MyInfoSideNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePicture navigateToUpdateProfilePicture() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(profilePicture).click();
        return new ProfilePicture(driver);
    }

    public ContactDetails navigateToContactDetails() {
        driver.findElement(contactDetails).click();
        return new ContactDetails(driver);
    }

}
