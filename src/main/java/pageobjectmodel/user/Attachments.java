package pageobjectmodel.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Attachments {
    WebDriver driver;
    private By chooseFileDocumentButton = By.id("ufile");
    public By commentInput = By.id("txtAttDesc");
    private By clickUploadButton = By.id("btnSaveAttachment");
    private By cancelButton = By.id("cancelButton");

    private By successfullySavedMessage = By.cssSelector("div.fadable");
    private By attachmentCommentValidationMessage = By.cssSelector("span[for=\"txtAttDesc\"]");
    private By addAttachmentButton = By.id("btnAddAttachment");
    private By selectDocument = By.name("chkattdel[]");
    private By selectAllDocuments = By.id("attachmentsCheckAll");
    private By deleteButton = By.id("btnDeleteAttachment");

    public Attachments(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddAttachmentButton() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(addAttachmentButton).click();
    }

    public void chooseFileForAddAttachment(String file) {
        driver.findElement(chooseFileDocumentButton).sendKeys(file);
    }

    public void clickUploadButtonForAddAttachment() {

        driver.findElement(clickUploadButton).click();
    }


    public void setCommentInput(String enterComment) {
        driver.findElement(commentInput).click();
        driver.findElement(commentInput).sendKeys(enterComment);
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public String getSuccessfullyValidationMessage() {
        return driver.findElement(successfullySavedMessage).getText();
    }

    public String getAttachmentCommentValidationMessage() {
        return driver.findElement(attachmentCommentValidationMessage).getText();
    }

    public int numberOfUploadDocuments() {
        List<WebElement> currentUploadedDocuments = driver.findElements(By.tagName("tr"));
        int numberOfDocuments = currentUploadedDocuments.size();
        return numberOfDocuments - 1;
    }

    public void setSelectDocument() {
        driver.findElement(selectDocument).click();
    }

    public void setSelectAllOddDocuments() {
        List<WebElement> checkBoxes = driver.findElements(selectDocument);

        for (int i = 0; i < checkBoxes.size(); i = i + 2) {
            checkBoxes.get(i).click();
        }
    }

    public void setSelectAllDocuments() {
        driver.findElement(selectAllDocuments).click();
    }

    public void clickDeleteAttachmentButton() {
        driver.findElement(deleteButton).click();
    }

}
