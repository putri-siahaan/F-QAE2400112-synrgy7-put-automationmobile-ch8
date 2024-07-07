package SwagLabs_Mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    AndroidDriver driver;
    WebDriverWait wait;

    // Locator atau element
    By addToCartProduct1 = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]");
    By addToCartProduct2 = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[2]");
    By cartIcon = AppiumBy.xpath("//*[@content-desc='test-Cart']");
    By checkoutButton = AppiumBy.xpath("//*[@content-desc='test-CHECKOUT']");
    By firstNameField = AppiumBy.xpath("//*[@content-desc='test-First Name']");
    By lastNameField = AppiumBy.xpath("//*[@content-desc='test-Last Name']");
    By postalCodeField = AppiumBy.xpath("//*[@content-desc='test-Zip/Postal Code']");
    By continueOption = AppiumBy.xpath("//*[@text='CONTINUE']");
    By finishButton = AppiumBy.xpath("//*[@content-desc='test-FINISH']");
    By textSuccessOrder = AppiumBy.xpath("//*[@text='CHECKOUT: COMPLETE!']");
    By imageSuccessOrder = AppiumBy.xpath("//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.ImageView");



    public CheckoutPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Action method
    public void clickAddProduct1(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartProduct1)).click();
    }
    public void clickAddProduct2(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartProduct2)).click();
    }
    public void clickCartIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon)).click();
    }
    public void swipeToElementWithTextCheckout(String checkout) {
        By byText = AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",
                        checkout
                )
        );
        driver.findElement(byText);
    }
    public void clickCheckoutButton(){
        swipeToElementWithTextCheckout("CHECKOUT");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).click();
    }

    public void inputFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    public void clickContinueOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueOption));
        driver.findElement(continueOption).click();
    }

    public void swipeToElementWithTextFinish(String finish) {
        By byText = AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",
                        finish
                )
        );
        driver.findElement(byText);
    }
    public void clickFinishButton(){
        swipeToElementWithTextFinish("FINISH");
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton)).click();
    }

    //validation Success To Page Checkout Is Complete
    public String getTextCheckoutStatus(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textSuccessOrder)).isDisplayed();
        return driver.findElement(textSuccessOrder).getText();
    }

    //validation Success Order
    public boolean getImageCheckoutComplete(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(imageSuccessOrder));
            return driver.findElement(imageSuccessOrder).isDisplayed();
        } catch (Exception e) {
            return false;  // Mengembalikan false jika gambar tidak ditemukan atau error lainnya.
        }
    }
}
