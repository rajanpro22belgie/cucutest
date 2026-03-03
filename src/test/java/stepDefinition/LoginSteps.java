package stepDefinition;

import com.test.driver.DriverFactory;
import com.test.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.open();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @When("user clicks login")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        // Add assertion here
    }
    
    @Then("user should see an error message") 
    public void user_should_see_error_message() { String msg = loginPage.getErrorMessage(); 
    if (!msg.toLowerCase().contains("invalid") && !msg.toLowerCase().contains("incorrect") && !msg.toLowerCase().contains("error")) 
    { throw new AssertionError("Expected error message, but got: " + msg); } 
    }
}
