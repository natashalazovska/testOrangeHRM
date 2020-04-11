package user.uploadphoto;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.user.Dashboard;
import pageobjectmodel.user.PersonalDetails;
import pageobjectmodel.user.ProfilePicture;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class AddAttachmentsInPersonalDetailsPageTest extends BaseTest {

    @Test
    public void uploadPhotoWithJPGFormatLessThan1MB() {
        String validJpgPhoto = "profilepicture/jpgLessThan1MB.jpg";
        String expectedUploadMessage = "Successfully Uploaded";
        uploadImageAsUserLinda(validJpgPhoto, expectedUploadMessage);
    }

    private void uploadImageAsUserLinda(String picture, String expectedUploadMessage) {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();

        ProfilePicture photo = personalDetails.getMyInfoSideNavigation().navigateToUpdateProfilePicture();

        File file = null;
        try {
            URL resource = AddAttachmentsInPersonalDetailsPageTest.class.getClassLoader().getResource(picture);
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(file.exists());

        String uploadMessage = photo.uploadPhoto(file.getAbsolutePath());
        Assert.assertTrue(uploadMessage.contains(expectedUploadMessage));
    }

    @Test
    public void uploadPhotoWithGifFormatLessThan1MB() {
        String validGifPhoto = "profilepicture/gifLessThan1MB.gif";
        String expectedUploadMessage = "Successfully Uploaded";
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        uploadImageAsUserLinda(validGifPhoto, expectedUploadMessage);
    }

    @Test
    public void uploadPhotoWithGifFormatMoreThan1MB() {
        String invalidGifPhoto = "profilepicture/gifMoreThan1MB.gif";
        String expectedUploadMessage = "Validation Failed";
        uploadImageAsUserLinda(invalidGifPhoto, expectedUploadMessage);
    }

    @Test
    public void uploadPhotoWithPNGFormatLassThan1MB() {
        String validPngPhoto = "profilepicture/pngLessThan1MB.png";
        String expectedUploadMessage = "Successfully Uploaded";
        uploadImageAsUserLinda(validPngPhoto, expectedUploadMessage);
    }

    @Test
    public void uploadPhotoWithPNGFormatMoreThan1MB() {
        String invalidPngPhoto = "profilepicture/pngMoreThan1MB.png";
        String expectedUploadMessage = "Validation Failed";
        uploadImageAsUserLinda(invalidPngPhoto, expectedUploadMessage);
    }

    @Test
    public void uploadPhotoWithNotAllowedFormat() {
        String invalidPhoto = "profilepicture/differentFormat.xlsx";
        String expectedUploadMessage = "Failed to Save: File Type Not Allowed";
        uploadImageAsUserLinda(invalidPhoto, expectedUploadMessage);
    }

}
