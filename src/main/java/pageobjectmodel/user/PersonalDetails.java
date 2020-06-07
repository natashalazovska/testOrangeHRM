package pageobjectmodel.user;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class PersonalDetails extends MyInfoBasePage {
    private WebDriver driver;
    private By editAndSaveButton = By.id("btnSave");
    private By firstNameInput = By.id("personal_txtEmpFirstName");
    private By middleNameInput = By.id("personal_txtEmpMiddleName");
    private By lastNameInput = By.id("personal_txtEmpLastName");
    private By otherIdInput = By.id("personal_txtOtherID");
    private By licenseExpiryDateInput = By.id("personal_txtLicExpDate");
    private By maritalStatusDropDown = By.id("personal_cmbMarital");
    private By genderMaleRadioButton = By.id("personal_optGender_1");
    private By genderFemaleRadioButton = By.id("personal_optGender_2");
    private By nationalityDropDown = By.id("personal_cmbNation");
    private By employeeIdInput = By.id("personal_txtEmployeeId");
    private By driverLicenseNumberInput = By.id("personal_txtLicenNo");
    private By dateOfBirthInput = By.id("personal_DOB");
    private By firstNameValidationMessage = By.cssSelector("span[for=\"personal_txtEmpFirstName\"]");
    private By lastNameValidationMessage = By.cssSelector("span[for=\"personal_txtEmpLastName\"]");
    private By successfullySavedMessage = By.cssSelector("div.fadable");
    private By dateValidationMessage = By.cssSelector("span[for=\"personal_txtLicExpDate\"]");
    private By openCalendarButton = By.xpath("//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[2]/li[4]/img");
    private By calendar = By.id("ui-datepicker-div");
    private By month = By.cssSelector(".ui-datepicker-month");
    private By year = By.cssSelector(".ui-datepicker-year");
    private By day = By.cssSelector(".ui-datepicker-calendar td");
    private Attachments attachmentSection;

    public PersonalDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.attachmentSection = new Attachments(driver);
    }

    public void clickEdit() {
        driver.findElement(editAndSaveButton).click();
    }

    public void clickSave() {
        driver.findElement(editAndSaveButton).click();
    }

    public void editFirstName(String name) {
        try {

            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(name);
    }

    public void editMiddleName(String setMiddleName) {
        driver.findElement(middleNameInput).clear();
        driver.findElement(middleNameInput).sendKeys(setMiddleName);
    }

    public void editLastName(String setLastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(setLastName);
    }

    public void editOtherID(String idNumber) {
        driver.findElement(otherIdInput).clear();
        driver.findElement(otherIdInput).sendKeys(idNumber);
    }

    public void chooseMaleFromGender() {
        driver.findElement(genderMaleRadioButton).click();
    }

    public void chooseFemaleFromGender() {
        driver.findElement(genderFemaleRadioButton).click();
    }

    private Select findMaritalStatus() {
        return new Select(driver.findElement(maritalStatusDropDown));
    }

    public void selectMaritalStatusFromDropDown(String option) {
        findMaritalStatus().selectByVisibleText(option);
    }

    public String getMaritalStatusDropDown() {
        List<WebElement> selectedElements = findMaritalStatus().getAllSelectedOptions();
        if (selectedElements.size() == 1) {
            return selectedElements.get(0).getText();
        }
        return "";
    }

    private Select findNationality() {
        return new Select(driver.findElement(nationalityDropDown));
    }

    public void selectNationalityFromDropDown(String option) {
        findNationality().selectByVisibleText(option);
    }

    public String getSelectedNationality() {
        List<WebElement> selectedElements = findNationality().getAllSelectedOptions();
        if (selectedElements.size() == 1) {
            return selectedElements.get(0).getText();
        }
        return "";
    }

    public boolean isEmployeeIdEditable() {
        return driver.findElement(employeeIdInput).isEnabled();
    }

    public boolean isDriverLicenseNumberIsEditable() {
        return driver.findElement(driverLicenseNumberInput).isEnabled();
    }

    public boolean isDateOfBirthEditable() {
        return driver.findElement(dateOfBirthInput).isEnabled();
    }

    public String getFirstNameValidationMessage() {
        return driver.findElement(firstNameValidationMessage).getText();
    }

    public String getLastNameValidationMessage() {
        return driver.findElement(lastNameValidationMessage).getText();

    }

    public String getSuccessfulSaveMessage() {
        return driver.findElement(successfullySavedMessage).getText();
    }

    public Attachments getAttachmentSection() {
        return attachmentSection;
    }

    public void enterDateForLicenseExpiryDateFromKeyboard(String date) {
        driver.findElement(licenseExpiryDateInput).clear();
        driver.findElement(licenseExpiryDateInput).sendKeys(date);
    }

    public void chooseMonth(String selectedMonth) {
        Select select = new Select(driver.findElement(month));
        select.selectByValue(selectedMonth);
    }

    public void chooseYear(String selectedYear) {
        Select select = new Select(driver.findElement(year));
        select.selectByValue(selectedYear);
    }


    public void chooseDay(String selectedDay) {
        List<WebElement> days = driver.findElements(day);
        for (WebElement cell : days) {

            if (cell.getText().equals(selectedDay)) {
                driver.findElement(By.linkText(selectedDay)).click();
            }
        }
    }

    public void openCalendar() {
        if (!isCalendarOpen()) {
            driver.findElement(openCalendarButton).click();
        }
    }

    public boolean isCalendarOpen() {
        return driver.findElement(calendar).isDisplayed();
    }

    public String getDateValidationMessage() {
        return driver.findElement(dateValidationMessage).getText();
    }

}
