package pageobjectmodel.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePicture extends MyInfoBasePage {
    WebDriver driver;
    private By chooseFile = By.id("photofile");
    private By uploadButton = By.id("btnSave");
    private By uploadMessage = By.cssSelector("div.fadable");

    public ProfilePicture(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String uploadPhoto(String picture) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement photo = driver.findElement(chooseFile);
        photo.sendKeys(picture);
        driver.findElement(uploadButton).click();

        return getUploadMessage();
    }
    private String getUploadMessage() {
        return driver.findElement(uploadMessage).getText();
    }
}
