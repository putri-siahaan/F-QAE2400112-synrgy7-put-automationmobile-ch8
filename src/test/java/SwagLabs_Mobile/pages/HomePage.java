package SwagLabs_Mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    AndroidDriver driver;
    WebDriverWait wait;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    // Locator element
    By productsTitle = AppiumBy.xpath("//*[contains(@text,'PRODUCTS')]");
    By product1 = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    By product2 = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]");



    //Action Method
    public String titleProductsIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).isDisplayed();
        return driver.findElement(productsTitle).getText();
    }

    public void product1IsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(product1)).isDisplayed();
    }

    public void product2IsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(product2)).isDisplayed();
    }
}
