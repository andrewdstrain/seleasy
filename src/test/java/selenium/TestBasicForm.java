package selenium;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assume.assumeTrue;

public class TestBasicForm {

    WebDriver driver;
    String expected;
    String actual;
    Browser browser;
    BasicFormPOM basicForm;

    @Given("I am on the page")
    public void i_am_on_the_page_and_i_enter_a_message() {

        browser = Browser.CHROME;

        if (browser.equals(Browser.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

        basicForm = new BasicFormPOM(driver);

    }

    @And("I enter a message")
    public void i_enter_message() {
        basicForm.setMessageInput("This is my message");
    }

    @When("I click the button")
    public void i_click_the_button() {
        assumeTrue(browser.equals(Browser.CHROME));
        basicForm.clickMessageButton();

    }
    @Then("I should have the message returned to me")
    public void i_should_have_the_message_returned_to_me() {
        actual = basicForm.getReturnedMessage();
        expected = "This is my message";
        assertThat(actual, equalTo(expected));
    }

    @After
    public void tearDown(){
        driver.close();
    }


}
