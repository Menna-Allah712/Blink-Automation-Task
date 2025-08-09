package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.BlogPage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class BlogPageSteps {
    WebDriver driver;
    BlogPage blogPage;

    @Given("I am on the Blink22 blog page")
    public void i_am_on_the_blink22_blog_page() {
        driver = Hooks.getDriver();
        driver.get("https://www.blink22.com/");
        HomePage homePage = new HomePage(driver);
        blogPage = homePage.clickBlogLink();
    }

    @When("I check the Full Name placeholder")
    public void i_check_the_full_name_placeholder() {
        String placeholder = blogPage.readFullNameBoxPlaceHolder();
        assertNotNull(placeholder);
    }

    @Then("I should see placeholder with name")
    public void i_should_see_placeholder_with_name() {
        String actual = blogPage.readFullNameBoxPlaceHolder();
        assertTrue(actual.contains("name"));
    }

    @Then("I should see placeholder with email")
    public void i_should_see_placeholder_with_email() {
        String actual = blogPage.readEmailPlaceHolder();
        assertTrue(actual.contains("email"));
    }

    @When("I check the Email placeholder")
    public void i_check_the_email_placeholder() {
        String placeholder = blogPage.readEmailPlaceHolder();
        assertNotNull(placeholder);
    }

    @When("I enter {string} in the Full Name box")
    public void i_enter_in_the_full_name_box(String name) {
        blogPage.insertFullName(name);
    }

    @Then("the Full Name box should contain {string}")
    public void the_full_name_box_should_contain(String expected) {
        assertEquals(expected, blogPage.readFullNameBoxText());
    }

    @When("I enter {string} in the Email box")
    public void i_enter_in_the_email_box(String email) {
        blogPage.insertEmail(email);
    }

    @Then("the Email box should contain {string}")
    public void the_email_box_should_contain(String expected) {
        assertEquals(expected, blogPage.readEmailBoxText());
    }

    @When("I click Subscribe")
    public void i_click_subscribe() {
        blogPage.clickOnSubscribe();
    }

    @Then("I should see Full Name error message {string}")
    public void i_should_see_full_name_error_message(String expected) {
        assertEquals(expected, blogPage.readFullNameErrorMessage());
    }

    @Then("I should see Email error message {string}")
    public void i_should_see_email_error_message(String expected) {
        assertEquals(expected, blogPage.readEmailErrorMessage());
    }

    @Then("I should see Thanks message {string}")
    public void i_should_see_thanks_message(String expected) {
        String actual = blogPage.readThanksMessage();
        assertTrue(actual.contains(expected));
    }
}
