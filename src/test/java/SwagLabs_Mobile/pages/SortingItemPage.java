package SwagLabs_Mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SortingItemPage {

    AndroidDriver driver;
    WebDriverWait wait;

    // Locator atau element
    By filterIcon = AppiumBy.xpath("//*[@content-desc='test-Modal Selector Button']");
    By priceLowToHigh = AppiumBy.xpath("//*[@text='Price (low to high)']");
    By leftProduct = AppiumBy.xpath("(//android.widget.TextView[contains(@text, '$')])[1]");
    By rightProduct = AppiumBy.xpath("(//android.widget.TextView[contains(@text, '$')])[2]");

    public SortingItemPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Action method
    public void clickFilterIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterIcon)).click();
    }

    public void chooseLowToHighPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceLowToHigh)).click();
    }

    public String getPriceOfLeftProduct(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(leftProduct)).getText();
    }

    public String getPriceOfRightProduct(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(rightProduct)).getText();
    }


}
