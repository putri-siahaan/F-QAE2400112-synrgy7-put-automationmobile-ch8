package SwagLabs_Mobile.testing;

import SwagLabs_Mobile.pages.HomePage;
import SwagLabs_Mobile.pages.LoginPage;
import SwagLabs_Mobile.pages.SortingItemPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SortingItemTest {
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
        SortingItemPage sortingItem = new SortingItemPage(driver);

        loginPage.inputValidUsername("standard_user");
        loginPage.inputValidPassword("secret_sauce");
        loginPage.clickLoginButton();


        //Assertion 1 Success on HomePage
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.titleProductsIsDisplayed(),"PRODUCTS");

        sortingItem.clickFilterIcon();
        sortingItem.chooseLowToHighPrice();

        // Memanggil metode untuk mendapatkan harga produk kiri dan kanan
        String leftPriceText = sortingItem.getPriceOfLeftProduct();
        String rightPriceText = sortingItem.getPriceOfRightProduct();

        // Mengkonversi harga dari String ke double dan menghilangkan simbol dolar
        double leftPrice = Double.parseDouble(leftPriceText.replace("$", ""));
        double rightPrice = Double.parseDouble(rightPriceText.replace("$", ""));

        //Assertion 2 Validate Price of Left Product Is Lower than Right Product
        Assert.assertTrue(leftPrice < rightPrice, "Left product price should be less than right product price");
    }


    @AfterTest
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
