package pageobjectmodel.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactDetails extends MyInfoBasePage {

    WebDriver driver;

    private By addressStreetFirstLineInput = By.id("contact_street1");
    private By addressStreetSecondLineInput = By.id("contact_street2");
    private By cityInput = By.id("contact_city");
    private By provinceInput = By.id("contact_province");
    private By zipPostalCodeInput = By.id("contact_emp_zipcode");

    private By countryInput = By.id("contact_country");
    private By homePhoneInput = By.id("contact_emp_hm_telephone");
    private By mobilePhoneInput = By.id("contact_emp_mobile");
    private By workTelephoneInput = By.id("contact_emp_work_telephone");
    private By workEmailInput = By.id("contact_emp_work_email");
    private By otherEmailInput = By.id("contact_emp_oth_email");
    private By stateProvinceInput = By.id("contact_state");
    // validation Message
    private By homeTelephoneValidationMessage = By.cssSelector("span[for=\"contact_emp_hm_telephone\"]");
    private By mobileValidationMessage = By.cssSelector("span[for=\"contact_emp_mobile\"]");
    private By workTelephoneValidationMessage = By.cssSelector("span[for=\"contact_emp_work_telephone\"]");
    private By workEmailValidationMessage = By.cssSelector("span[for=\"contact_emp_work_email\"]");
    private By otherEmailValidationMessage = By.cssSelector("span[for=\"contact_emp_oth_email\"]");
    private By successfullySaveMessage = By.cssSelector("div.fadable");
    private By editButton = By.id("btnSave");

    private static final String UNITED_STATES = "United States";

    public ContactDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickEdit() {
        driver.findElement(editButton).click();
    }

    public void clickSave() {
        driver.findElement(editButton).click();
    }

    public void setAddressStreetFirstLine(String address) {
        driver.findElement(addressStreetFirstLineInput).clear();
        driver.findElement(addressStreetFirstLineInput).sendKeys(address);
    }

    public void setAddressStreetSecondLine(String address) {
        driver.findElement(addressStreetSecondLineInput).clear();
        driver.findElement(addressStreetSecondLineInput).sendKeys(address);
    }

    public void setCityInput(String cityName) {
        driver.findElement(cityInput).clear();
        driver.findElement(cityInput).sendKeys(cityName);
    }

    public void setZipPostalCodeInput(String zipCode) {
        driver.findElement(zipPostalCodeInput).clear();
        driver.findElement(zipPostalCodeInput).sendKeys(zipCode);
    }

    public void setCountryAndStateProvince(String selectedCountry, String selectedStateOrProvince) {
        Select selectCountry = new Select(driver.findElement(countryInput));
        selectCountry.selectByVisibleText(selectedCountry);

        if (UNITED_STATES.equals(selectedCountry)) {
            Select selectState = new Select(driver.findElement(stateProvinceInput));
            selectState.selectByVisibleText(selectedStateOrProvince);
        } else {
            driver.findElement(provinceInput).sendKeys(selectedStateOrProvince);
            System.out.println("country is not in US");
        }
    }

    public void setHomePhoneInput(String home_phone) {
        driver.findElement(homePhoneInput).clear();
        driver.findElement(homePhoneInput).sendKeys(home_phone);
    }

    public void setWorkTelephone(String work_telephone) {
        driver.findElement(workTelephoneInput).clear();
        driver.findElement(workTelephoneInput).sendKeys(work_telephone);
    }

    public void setMobilePhoneInput(String mobile_number) {
        driver.findElement(mobilePhoneInput).clear();
        driver.findElement(mobilePhoneInput).sendKeys(mobile_number);
    }

    public void setWorkEmail(String work_email) {
        driver.findElement(workEmailInput).clear();
        driver.findElement(workEmailInput).sendKeys(work_email);
    }

    public void setOtherEmail(String other_email) {
        driver.findElement(otherEmailInput).clear();
        driver.findElement(otherEmailInput).sendKeys(other_email);
    }

    public String getHomeTelephoneValidationMessage() {
        return driver.findElement(homeTelephoneValidationMessage).getText();
    }

    public String getMobileValidationMessage() {
        return driver.findElement(mobileValidationMessage).getText();
    }

    public String getWorkTelephoneValidationMessage() {
        return driver.findElement(workTelephoneValidationMessage).getText();
    }

    public String getWorkEmailValidationMessage() {
        return driver.findElement(workEmailValidationMessage).getText();
    }

    public String getOtherEmailValidationMessage() {
        return driver.findElement(otherEmailValidationMessage).getText();
    }

    public String getSuccessfullySavedMessage() {
        return driver.findElement(successfullySaveMessage).getText();
    }
}
