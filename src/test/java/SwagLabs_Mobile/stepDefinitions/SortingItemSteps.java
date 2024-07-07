package SwagLabs_Mobile.stepDefinitions;

import SwagLabs_Mobile.pages.LoginPage;
import SwagLabs_Mobile.pages.SortingItemPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.testng.AssertJUnit.assertTrue;

public class SortingItemSteps {
    protected static AndroidDriver driver;

    @Given("user login with valid username and password")
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

    @And("user click the filter button")
    public void userClickTheFilterButton() {
        SortingItemPage sortingItem = new SortingItemPage(driver);
        sortingItem.clickFilterIcon();
    }

    @When("user choose price from low to high option")
    public void userChoosePriceFromLowToHighOption() {
        SortingItemPage sortingItem = new SortingItemPage(driver);
        sortingItem.chooseLowToHighPrice();
    }

    @Then("validate the price of the item on the left is lower than the price of the item on the right")
    public void validateThePriceOfTheItemOnTheLeftIsLowerThanThePriceOfTheItemOnTheRight() {
        SortingItemPage sortingItem = new SortingItemPage(driver);
        String leftPriceText = sortingItem.getPriceOfLeftProduct();
        String rightPriceText = sortingItem.getPriceOfRightProduct();

        double leftPrice = Double.parseDouble(leftPriceText.replace("$", ""));
        double rightPrice = Double.parseDouble(rightPriceText.replace("$", ""));

        assertTrue("Left product price should be less than right product price", leftPrice < rightPrice);
    }
}
