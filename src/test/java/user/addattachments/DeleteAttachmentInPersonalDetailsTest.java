package user.addattachments;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.user.Attachments;
import pageobjectmodel.user.Dashboard;
import pageobjectmodel.user.PersonalDetails;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class DeleteAttachmentInPersonalDetailsTest extends BaseTest {

    public Attachments uploadDocumentWithUserLinda(String document) {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();

        Attachments attachments = personalDetails.getAttachmentSection();

        File file = null;
        try {
            URL resource = DeleteAttachmentInPersonalDetailsTest.class.getClassLoader().getResource(document);
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 4; i++) {
            attachments.clickAddAttachmentButton();
            attachments.chooseFileForAddAttachment(file.getAbsolutePath());
            attachments.clickUploadButtonForAddAttachment();
            Assert.assertTrue(attachments.getSuccessfullyValidationMessage().contains("Successfully Saved"));
        }
        return attachments;
    }

    @Test
    public void deleteOneDocument() {
        String validDocument = "addattachments/documentLessThan1Mb.pdf";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attachments.setSelectDocument();
        attachments.clickDeleteAttachmentButton();
    }

    @Test
    public void deleteMultipleDocument() {
        String validDocument = "addattachments/documentLessThan1Mb.pdf";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attachments.setSelectAllOddDocuments();
        attachments.clickDeleteAttachmentButton();
        String expectedMessage = "Successfully Deleted";

        assertTrue(attachments.getSuccessfullyValidationMessage().contains(expectedMessage));
    }

    @Test
    public void deleteAllDocuments() {
        String validDocument = "addattachments/documentLessThan1Mb.pdf";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attachments.setSelectAllDocuments();
        attachments.clickDeleteAttachmentButton();
        String expectedMessage = "Successfully Deleted";

        assertTrue(attachments.getSuccessfullyValidationMessage().contains(expectedMessage));
    }
}
