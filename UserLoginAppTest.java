package appiumtesting;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UserLoginAppTest {

    public static void main(String[] args) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API Baklava");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("appPackage", "com.example.app23");
            capabilities.setCapability("appActivity", ".MainActivity");

            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement usernameField = driver.findElement(By.id("com.example.app23:id/etEmail"));
            WebElement  passwordField = driver.findElement(By.id("com.example.app23:id/etPassword"));
            WebElement loginButton = driver.findElement(By.id("com.example.app23:id/btnLogin"));

            usernameField.sendKeys("test@gmail.com");
            passwordField.sendKeys("123");
            loginButton.click();

            boolean isLoginSuccessful = driver.findElements(By.xpath("//android.widget.Toast[@text='Login Successful']")).size() > 0;

            if (isLoginSuccessful) {
                System.out.println("Test Passed: Login Successful.");
            } else {
                System.out.println("Test Failed: Incorrect credentials.");
            }

            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
    }
}