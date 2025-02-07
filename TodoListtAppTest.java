package appsd;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TodoListtAppTest {

    public static void main(String[] args) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API Baklava");
        caps.setCapability("appPackage", "com.example.todolisttapp");
        caps.setCapability("appActivity", "com.example.todolisttapp.MainActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {
            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            
            Thread.sleep(3000);  

            WebElement addButton = driver.findElement(By.id("com.example.todolisttapp:id/fab_add"));
            addButton.click();
            Thread.sleep(2000);  

            WebElement titleField = driver.findElement(By.id("com.example.todolisttapp:id/edit_text_task"));
            titleField.sendKeys("Cycling");
            Thread.sleep(1000);  

        
            WebElement descField = driver.findElement(By.id("com.example.todolisttapp:id/edit_text_task_desc"));
            descField.sendKeys("Exercise");
            Thread.sleep(1000);  

            WebElement saveButton = driver.findElement(By.id("com.example.todolisttapp:id/btn_add_task"));
            saveButton.click();
            Thread.sleep(2000);  

          
            WebElement taskText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Cycling')]"));
            WebElement descText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Exercise')]"));

            if (taskText.isDisplayed() && descText.isDisplayed()) {
            	System.out.println("Successfully navigated to AddTaskFragment!!!");
                System.out.println("Task & Description added Successfully!");
            } else {
                System.out.println("Task or Description was NOT added.");
            }

            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}