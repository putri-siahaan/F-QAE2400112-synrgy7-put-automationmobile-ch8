package SwagLabs_Mobile.testing;

import SwagLabs_Mobile.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvalidLoginTest {
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
        loginPage.inputValidPassword("12345");
        loginPage.clickLoginButton();


        //Assertion Stay On Login Page
        Assert.assertEquals(loginPage.getTextErrorMessage(),"Username and password do not match any user in this service.");
    }


    @AfterTest
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
