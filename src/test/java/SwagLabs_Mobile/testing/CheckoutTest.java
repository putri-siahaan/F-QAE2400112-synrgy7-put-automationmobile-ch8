package SwagLabs_Mobile.testing;

import SwagLabs_Mobile.pages.CheckoutPage;
import SwagLabs_Mobile.pages.HomePage;
import SwagLabs_Mobile.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutTest {
    protected static AndroidDriver driver;

    @BeforeTest
    public static void setUp(){
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

    @Test
    public static void testCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.inputValidUsername("standard_user");
        loginPage.inputValidPassword("secret_sauce");
        loginPage.clickLoginButton();


        //Assertion 1 Success on HomePage
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.titleProductsIsDisplayed(),"PRODUCTS");

        // Add products to cart
        checkoutPage.clickAddProduct2();
        checkoutPage.clickAddProduct1();


        // Go to cart and proceed to checkout
        checkoutPage.clickCartIcon();
        checkoutPage.clickCheckoutButton();

        // Enter checkout information
        checkoutPage.inputFirstName("Ana");
        checkoutPage.inputLastName("Siahaan");
        checkoutPage.inputPostalCode("12345");
        checkoutPage.clickContinueOption();

        // Finish checkout
        checkoutPage.clickFinishButton();

        // Assertion 1: verify success message
        String successOrder = checkoutPage.getTextCheckoutStatus();
        Assert.assertEquals("CHECKOUT: COMPLETE!", successOrder);

        // Assertion 2: Validate success with image
        boolean isImageDisplayed = checkoutPage.getImageCheckoutComplete();
        Assert.assertTrue(isImageDisplayed, "Checkout completion image is not displayed");

    }


    @AfterTest
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
