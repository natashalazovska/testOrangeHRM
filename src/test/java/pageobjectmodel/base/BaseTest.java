package pageobjectmodel.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjectmodel.user.LoginPage;

public class BaseTest {
    private static final String ORANGEHRMLIVE_URL = "https://opensource-demo.orangehrmlive.com/";
    private static final String LOGOUT_URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/logout";
    protected LoginPage login;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void navigateToOrangeHRM() {
        driver.get(ORANGEHRMLIVE_URL);
        driver.manage().window().maximize();
        login = new LoginPage(driver);
    }

    @AfterMethod
    public void logout() {
        driver.get(LOGOUT_URL);
    }

    @AfterClass
    public void turnDown() {
        driver.quit();
    }
}

