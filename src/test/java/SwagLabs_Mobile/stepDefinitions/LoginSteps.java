package SwagLabs_Mobile.stepDefinitions;

import SwagLabs_Mobile.pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import SwagLabs_Mobile.pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    protected static AndroidDriver driver;

    // Successfully Login

    @Given("user open the app and go to the login page")
    public void user_go_to_login_page() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("app","D:/Kuliah/Synrgy-Bootcamp/Chapter 8/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("automationName","UIAutomator2");
        capabilities.setCapability("appPackage","com.swaglabsmobileapp");
        capabilities.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }

    @And("user input valid username with {string}")
    public void userInputValidUsername(String validUsername) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputValidUsername(validUsername);
    }

    @And("user input valid password with {string}")
    public void userInputValidPassword(String validPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputValidPassword(validPassword);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        HomePage homePage = new HomePage(driver);
        homePage.titleProductsIsDisplayed();
    }

    @And("user is able to see all products")
    public void userIsAbleToSeeTitleProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.product1IsDisplayed();
        homePage.product2IsDisplayed();
    }




    // Failed Login With Wrong Password

    @And("user input invalid password with {string}")
    public void userInputInvalidPassword(String invalidPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputInvalidPassword(invalidPassword);
    }

    @Then("user is on the login page")
    public void userIsOnTheLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.stayOnLoginPage();
    }

    @And("user is able to see error message {string}")
    public void userIsAbleToSeeErrorMessage(String errorMessageForLogin) {
        LoginPage loginPage = new LoginPage(driver);
        String actualErrorMessage = loginPage.getTextErrorMessage();
        assertEquals(errorMessageForLogin, actualErrorMessage, "Error message does not match.");

    }
}
