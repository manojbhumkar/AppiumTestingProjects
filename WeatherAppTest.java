package appiumtesting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WeatherAppTest {
    public static void main(String[] args) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API Baklava");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            capabilities.setCapability("appPackage", "com.example.weatherapp");
            capabilities.setCapability("appActivity", "com.example.weatherapp.MainActivity"); // Update if needed

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          
            WebElement EnterCityNameField = driver.findElement(By.id("com.example.weatherapp:id/etCity"));
            driver.findElement(By.id("com.example.weatherapp:id/btnFetchWeather")).click();
            Thread.sleep(3000);
            EnterCityNameField.sendKeys("London");
          
            String weatherText = driver.findElement(By.id("com.example.weatherapp:id/tvWeather")).getText();
            System.out.println("Weather Data: " + weatherText);

  
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}