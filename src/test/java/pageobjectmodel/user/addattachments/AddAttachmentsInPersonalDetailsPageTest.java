package pageobjectmodel.user.addattachments;

import pageobjectmodel.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.user.Attachments;
import pageobjectmodel.user.Dashboard;
import pageobjectmodel.user.PersonalDetails;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class AddAttachmentsInPersonalDetailsPageTest extends BaseTest {
    @Test
    public void testUploadDocumentLessThan1MB() {
        String validDocument = "addattachments/documentLessThan1Mb.pdf";
        String expectedUploadMessage = "Successfully Saved";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument, "");
        attachments.clickUploadButtonForAddAttachment();

        Assert.assertTrue(attachments.getSuccessfullyValidationMessage().contains(expectedUploadMessage));
    }

    public Attachments uploadDocumentWithUserLinda(String document, String commentOnDocument) {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();

        Attachments attachments = personalDetails.getAttachmentSection();

        File file = null;
        try {
            URL resource = AddAttachmentsInPersonalDetailsPageTest.class.getClassLoader().getResource(document);
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(file.exists());

        attachments.clickAddAttachmentButton();
        attachments.chooseFileForAddAttachment(file.getAbsolutePath());
        attachments.setCommentInput(commentOnDocument);

        return attachments;
    }

    @Test
    public void testUploadDocumentMoreThan1MB() {
        String validDocument = "addattachments/documentMoreThen1MB.pdf";
        String expectedUploadMessage = "Failed to Save: File Size Exceeded";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument, "");
        attachments.clickUploadButtonForAddAttachment();
        Assert.assertTrue(attachments.getSuccessfullyValidationMessage().contains(expectedUploadMessage));
    }

    @Test
    public void testUploadDocumentLessThan1MbWithInvalidCommentSize() {
        String validDocument = "addattachments/documentLessThan1Mb.pdf";
        String commentOnDocumentInvalidSize = "this is my comment this is my comment this is my comment this is my comment this is my comment this is my comment this is my comment this " +
                "is my comment this is my comment this is my comment this is Myt";
        String commentMessage = "Should be less than 200 characters";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument, commentOnDocumentInvalidSize);
        attachments.clickUploadButtonForAddAttachment();

        Assert.assertEquals(attachments.getAttachmentCommentValidationMessage(), commentMessage);
    }

    @Test
    public void testUploadDocumentLessThan1MbWithValidCommentSize() {
        String validDocument = "addattachments/documentLessThan1Mb.pdf";
        String commentOnDocumentValidSize = "this is my comment this is my comment this is my comment this is my comment this is my comment this is my comment this " +
                "is my comment this is my comment this is my comment";
        String expectedUploadMessage = "Successfully Saved";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument, commentOnDocumentValidSize);
        attachments.clickUploadButtonForAddAttachment();

        Assert.assertTrue(attachments.getSuccessfullyValidationMessage().contains(expectedUploadMessage));
    }

    @Test
    public void testCancelButtonForUploadDocument() {
        String validDocument = "addattachments/documentLessThan1Mb.pdf";
        String commentOnDocument = "this is my comment this is my comment this is my comment this is my comment this is my comment this is my comment this is my comment this " +
                "is my comment this is my comment this is my comment";
        Attachments attachments = uploadDocumentWithUserLinda(validDocument, commentOnDocument);
        int numberOfDocumentsBeforeCancel = attachments.numberOfUploadDocuments();
        attachments.clickCancelButton();
        int numberOfDocumentsAfterCancel = attachments.numberOfUploadDocuments();
        boolean currentNumberOfDocument = numberOfDocumentsBeforeCancel == numberOfDocumentsAfterCancel;

        Assert.assertTrue(currentNumberOfDocument, "Cancel button Doesn't Work");
    }

}
