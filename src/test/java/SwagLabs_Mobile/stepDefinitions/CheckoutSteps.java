package SwagLabs_Mobile.stepDefinitions;

import SwagLabs_Mobile.pages.CheckoutPage;
import SwagLabs_Mobile.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class CheckoutSteps {
    protected static AndroidDriver driver;

    @Given("user login with used valid username and password")
    public void userLoginWithValidUsernameAndPassword() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("app","D:/Kuliah/Synrgy-Bootcamp/Chapter 8/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("automationName","UIAutomator2");
        capabilities.setCapability("appPackage","com.swaglabsmobileapp");
        capabilities.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputValidUsername("standard_user");
        loginPage.inputValidPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("user added the first product to the cart")
    public void userAddedTheFirstProductToTheCart() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickAddProduct2();
    }

    @And("user added the second product to the cart")
    public void userAddedTheSecondProductToTheCart() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickAddProduct1();
    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCartIcon();
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();
    }

    @And("user input First Name, Last Name, and Postal Code in the information checkout")
    public void userInputFirstNameInTheInformationCheckout() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputFirstName("Ana");
        checkoutPage.inputLastName("Siahaan");
        checkoutPage.inputPostalCode("12345");
    }


    @And("user click continue button")
    public void userClickContinueButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickContinueOption();
    }

    @When("user click finish button")
    public void userClickFinishButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickFinishButton();
    }

    @Then("validate success checkout")
    public void validateSuccessCheckout() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        //Assert 1 : Validation Text
        String successOrder = checkoutPage.getTextCheckoutStatus();
        Assert.assertEquals("CHECKOUT: COMPLETE!", successOrder);

        //Assert 2 : Validation Image
        boolean isImageDisplayed = checkoutPage.getImageCheckoutComplete();
        Assert.assertTrue(isImageDisplayed, "Checkout completion image is not displayed");

    }
}
