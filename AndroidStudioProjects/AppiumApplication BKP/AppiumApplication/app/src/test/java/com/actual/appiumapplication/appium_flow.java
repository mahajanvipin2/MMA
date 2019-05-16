package com.actual.appiumapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class appium_flow {

    //WebDriver driver;

    //  static RemoteWebDriver driver =null;
    AndroidDriver androidDriver=null;

    //public  static AndroidDriver ad;
    //  public  static AndroidElement Ae;
    //  private AndroidDriver andriver;
    @Before
    public void setUp() throws MalformedURLException {
      //  call_excel obj = new call_excel();
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "Emulator");

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
        // driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        androidDriver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //driver = androidDriver;
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        //  ad= new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
    }

    @Test
    public void fun_mehr() {

        // Next line clicks on ich habe verstanden button

        androidDriver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]"))).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Next line clicks on the Close button
        androidDriver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView"))).click();

        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Next line clicks on Mehr link
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.Button")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        String visibleText = "Developer Settings";
        //Next line scrolls till "Developer Settings" is visible and then clicks on it
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();

        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        visibleText = "Deactivate InfoFlash";
        //Next line scrolls till "Deactivate InfoFlash" is visible
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
        //Next 2 lines gets the coordinates of "Deactivate InfoFlash" text and stores in X and Y
        int X = androidDriver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\")").getLocation().getX();
        int Y = androidDriver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\")").getLocation().getY();
        System.out.println(X);
        System.out.println(Y);
        //Next 2 lines gets the coordinates of toggle button
        int xPoint = X+1250;
        int yPoint = Y+38;
        TouchAction touchAction=new TouchAction(androidDriver);
        //Next line tabs the toggle button corresponding to "Deactivate InfoFlash"
        touchAction.tap(xPoint, yPoint).perform();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
      //  System.out.println(Y);
        //Next line clicks on Back button on the emulator
        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        String vis_Text = "Einstellungen";
        //Next line scrolls till "Einstellungen" text is visible and then clicks on it
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + vis_Text + "\").instance(0))").click();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        //Next line gets the coordinates of "Einstellungen" text and stores in X and Y

        vis_Text="Persönliche Mitteilungen";
  //      androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + vis_Text + "\").instance(0))");
        X = androidDriver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+vis_Text+"\")").getLocation().getX();
        Y = androidDriver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+vis_Text+"\")").getLocation().getY();
        System.out.println("New X"+X);
        System.out.println("New Y"+Y);
        xPoint = X+1259;
        yPoint = Y+38;
        if (yPoint>2392)
        {
            yPoint=2392;
        }
        System.out.println("Next line will click on toggle button of Persönliche Mitteilungen");
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        touchAction.tap(xPoint,yPoint).perform();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);

        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")).click();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
            for (int h=1;h<=4;)
            {
                if (androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout['"+h+"']/android.widget.CheckBox")).isEnabled())
                {
                    System.out.println(h+ " toggle is already selected");
               } else {
                    System.out.println("It is not selected");
                    androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout['"+h+"']/android.widget.CheckBox")).click();
                }
                h++;
            }

        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[3]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[1]")).clear();
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[1]")).sendKeys("ct458");
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[2]")).clear();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[2]")).sendKeys("start123");
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button")).click();
        androidDriver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
    }

    @After
    public void End() {
        // driver.quit();
       androidDriver.quit();
    }
}