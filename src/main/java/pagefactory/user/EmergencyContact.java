package pagefactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmergencyContact {

    private WebDriver driver;

    @FindBy(id = "btnAddContact")
    WebElement addContact;
    @FindBy(id = "emgcontacts_name")
    WebElement contactName;
    @FindBy(id = "emgcontacts_relationship")
    WebElement relationship;
    @FindBy(id = "emgcontacts_homePhone")
    WebElement homeTelephone;
    @FindBy(id = "btnSaveEContact")
    WebElement saveButton;
    @FindBy(id = "delContactsBtn")
    WebElement deleteButton;
    @FindBy(name = "chkecontactdel[]")
    List<WebElement> checkOnContact;

    public EmergencyContact(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAddContact() {
        addContact.click();
    }

    public void setContactName(String name) {
        contactName.sendKeys(name);
    }

    public void setRelationship(String strRilationship) {
        relationship.sendKeys(strRilationship);
    }

    public void setHomePhone(int number) {
        homeTelephone.sendKeys(String.valueOf(number));
    }

    public void setSaveButton() {
        saveButton.click();
    }

    public void selectAllContacts() {
        List<WebElement> checkBoxes = checkOnContact;
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
        }
    }

    public void setSelectAllEvenContact() {
        List<WebElement> checkBoxes = checkOnContact;

        for (int i = 1; i < checkBoxes.size(); i += 2) {
            checkBoxes.get(i).click();
        }
    }

    public void deleteContact() {
        deleteButton.click();
    }

}
