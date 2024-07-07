package SwagLabs_Mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    AndroidDriver driver;
    WebDriverWait wait;

    // Locator atau element
    By usernameField = AppiumBy.xpath("//*[@content-desc='test-Username']");
    By passwordField = AppiumBy.accessibilityId("test-Password");
    By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    By errorMessage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView\n");

    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Action method

    //Positive Case
    public void inputValidUsername(String validUsername){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(validUsername);
    }

    public void inputValidPassword(String validPassword){
        driver.findElement(passwordField).sendKeys(validPassword);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }





    //Negative Case
    public void inputInvalidPassword(String invalidPassword){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(invalidPassword);
    }

    public void stayOnLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

    public String getTextErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }


}
