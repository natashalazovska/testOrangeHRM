package pageobjectmodel.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EmergencyContact extends MyInfoBasePage {
    WebDriver driver;

    protected EmergencyContact(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By saveButton = By.id("btnSaveEContact");
    private By deleteButton = By.id("delContactsBtn");
    private By addContact = By.id("btnAddContact");
    private By contactName = By.id("emgcontacts_name");
    private By relationship = By.id("emgcontacts_relationship");
    private By homePhone = By.id("emgcontacts_homePhone");
    private By mobilePhone = By.id("emgcontacts_mobilePhone");
    private By workPhone = By.id("emgcontacts_workPhone");
    private By checkAll = By.id("checkAll");
    private By checkOnContact = By.name("chkecontactdel[]");
    private By successfullySavedMessage = By.cssSelector("div.fadable");

    public void clickAddContact() {
        driver.findElement(addContact).click();
    }

    public void setContactName(String name) {
        driver.findElement(contactName).sendKeys(name);
    }

    public void setRelationship(String strRelationship) {
        driver.findElement(relationship).sendKeys(strRelationship);
    }

    public void setHomePhone(String homeNumber) {
        driver.findElement(homePhone).sendKeys(homeNumber);
    }

    public void setMobilePhone(String mobileNumber) {
        driver.findElement(mobilePhone).sendKeys(mobileNumber);
    }

    public void setWorkPhone(String workNumber) {
        driver.findElement(workPhone).sendKeys(workNumber);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void deleteContact() {
        driver.findElement(deleteButton).click();
    }

    public void selectAllContacts() {
        List<WebElement> checkBoxes = driver.findElements(checkAll);
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
        }
    }

    public void selectAllEvenContact() {
        List<WebElement> checkBoxes = driver.findElements(checkOnContact);
        for (int i = 1; i < checkBoxes.size(); i += 2) {
            checkBoxes.get(i).click();
        }
    }
    public String getSuccessfulValidationMessage() {
        return driver.findElement(successfullySavedMessage).getText();
    }
}

