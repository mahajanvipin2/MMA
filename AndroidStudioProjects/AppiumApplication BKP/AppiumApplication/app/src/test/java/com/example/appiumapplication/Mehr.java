package com.example.appiumapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Mehr {

    WebDriver driver;

    public  static AndroidDriver ad;
public  static AndroidElement Ae;

    @Before
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "Emulator");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        //capabilities.setCapability(CapabilityType.VERSION, "6.0.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "de.telekom.android.customercenter");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "de.telekom.android.customercenter.ui.activities.SplashActivity");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

      //  ad= new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
    }

    @Test
    public void fun_mehr() {

        // Click on ich habe verstanden button
        driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]"))).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //click on the Close button
        driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView"))).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //click on Mehr button
       driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.Button")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

       driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")).click();
//driver.findElement(By.xpath("\t/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView")).click();
       // String temp = driver.findElements(By.className("android.widget.TextView")).get(6).getText();
        for (int i = 0; i <2 ; i++) {
         //   driver.findElement(By.id("de.telekom.android.customercenter:id/tabbar_menu_more_information_header")).sendKeys(Keys.DOWN);
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")).sendKeys(Keys.TAB);

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")).sendKeys(Keys.TAB);
            //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")).sendKeys(Keys.DOWN);
        }
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.ImageView")).click();
        // do {
         //   Boolean flag = driver.findElement(By.linkText("Developer Settings")).isDisplayed();
           // if (flag)
            //{
              //  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.ImageView")).click();
                //break;
            //}
            //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")).sendKeys(Keys.ARROW_DOWN);
        //}while (true);

        //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.ImageView")).click();

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //String visibleText = "Developer Settings";

       // ad.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();

       // driver.findElement(MobileBy.AndroidUIAutomator(
        //        "new UiScrollable(new UiSelector().resourceId(\"de.telekom.android.customercenter:id/left_menu_fragment_list_item_title\")).getChildByText("
         //               + "new UiSelector().className(\"android.widget.TextView\"), \"Developer Settings\")")).click();

       // ((AppiumDriver) driver).     .scrollToExact("Developer Settings");

       // TouchAction action = new TouchAction((PerformsTouchActions) driver);
        //action.press(100,100).moveTo(447,1745).release().perform();



//Perform the action on the element

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        }





    @After
    public void End() {
        driver.quit();
    }
}