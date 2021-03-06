package com.example.appiumapplication;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstTimeLogin {

    WebDriver driver;

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


    }

    @Test
    public void Login() {


        // Click on DELETE/CLR button to clear result text box before running test.
       // Click on ich habe verstanden
driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]"))).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //click on the Close button
driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView"))).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //click on the Login button
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[3]")).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//click on the UserID textbox and enter the value of UserID
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[1]")).sendKeys("ct458");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//click on the Password textbox and enter the value of Password
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[2]")).sendKeys("start123");

//click on the Login button
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button")).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @After
    public void End() {
        driver.quit();
    }
}