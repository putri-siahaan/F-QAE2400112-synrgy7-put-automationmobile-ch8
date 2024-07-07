package SwagLabs_Mobile.testing;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import SwagLabs_Mobile.pages.HomePage;
import SwagLabs_Mobile.pages.LoginPage;

public class ValidLoginTest {

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
    public static void testLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputValidUsername("standard_user");
        loginPage.inputValidPassword("secret_sauce");
        loginPage.clickLoginButton();


        //Assertion Success on HomePage
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.titleProductsIsDisplayed(),"PRODUCTS");
        homePage.product1IsDisplayed();
        homePage.product2IsDisplayed();
    }


    @AfterTest
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
