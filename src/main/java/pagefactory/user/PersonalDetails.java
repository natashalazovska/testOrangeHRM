package pagefactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetails {

    private WebDriver driver;

    @FindBy(linkText = "Emergency Contacts")
    WebElement clickEmergencyContacts;

    public PersonalDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmergencyContact navigateToEmergencyContact() {
        clickEmergencyContacts.click();
        return new EmergencyContact(driver);
    }


}
