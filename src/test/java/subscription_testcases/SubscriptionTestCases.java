package subscription_testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.BlogPage;
import org.example.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SubscriptionTestCases {

    WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.blink22.com/");
    }

    @Test
    public void verifyFullNamePlaceHolderText() {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();

        //compare
        String expectedResult = "name";
        String actualResult = blogPage.readFullNameBoxPlaceHolder();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyEmailPlaceHolderText() {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();
        //compare
        String expectedResult = "email";
        String actualResult = blogPage.readEmailPlaceHolder();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyUserEnterNameInFullNameBox() {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();
        blogPage.insertFullName("John smith");
        //compare
        String expectedResult = "John smith";
        String actualResult = blogPage.readFullNameBoxText();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyUserEnterEmailInEmailBox() {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();
        blogPage.insertEmail("test@example.com");

        //compare
        String expectedResult = "test@example.com";
        String actualResult = blogPage.readEmailBoxText();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyUserSubmitionWithFullNameBoxEmptyFailed() {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();
        blogPage.insertEmail("test@example.com");
        blogPage.clickOnSubscribe();

        //compare
        String expectedResult = "This field is required.";
        String actualResult = blogPage.readFullNameErrorMessage();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyUserSubmitionWithEmailBoxEmptyFailed() {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();
        blogPage.insertFullName("John smith");
        blogPage.clickOnSubscribe();

        //compare
        String expectedResult = "This field is required.";
        String actualResult = blogPage.readEmailErrorMessage();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyUserSubmitionWithInvalidEmailFailed() {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();
        blogPage.insertFullName("John smith");
        blogPage.insertEmail("abc@com");
        blogPage.clickOnSubscribe();

        //compare
        String expectedResult = "Enter a valid email address.";
        String actualResult = blogPage.readEmailErrorMessage();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));


    }

    @Test
    public void verifyUserSubmitionWithValidData() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = homePage.clickBlogLink();
        Thread.sleep(2000);
        blogPage.insertFullName("John smith");
        blogPage.insertEmail("test@example.com");
        blogPage.clickOnSubscribe();

        //compare
        String expectedResult = "Thanks for signing up!";
        String actualResult = blogPage.readThanksMessage();

        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
