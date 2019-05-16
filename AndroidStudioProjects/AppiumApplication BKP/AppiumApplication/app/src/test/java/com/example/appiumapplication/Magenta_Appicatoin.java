package com.example.appiumapplication;
import com.actual.appiumapplication.CommonFunctions;
import com.actual.appiumapplication.ExcelLib;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import jxl.read.biff.BiffException;

public class Magenta_Appicatoin {
    //WebDriver driver;
    //  static RemoteWebDriver driver =null;
    AndroidDriver androidDriver = null;
    ExcelLib excel_Device = null;
    CommonFunctions cap = null;
    int flag = 0;
    String visibleText = "";

   //  private AndroidDriver andriver;
    @Before
    public void setUp() throws IOException, BiffException {
        //Below statement creates an Object Reference of CommonFunctions class
        cap = new CommonFunctions();
        //Below statement calls a function in CommonFunctions class to set the Capabilities parameters
        androidDriver = cap.app_launch();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @Test
    public void deviceisRooted()
    {
        // Below statement clicks on ich habe verstanden button
        androidDriver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]"))).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void MMATourClosing()
    {
        //click on the Close button to close the MMA Tour
        androidDriver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView"))).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @Test
    public void MehrOptionen()
    {
        //click on Mehr button
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.Button")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        visibleText = "Developer Settings";
        //Below statement calls a function in CommonFunctions class to scroll to the test passed by function and click on it.
        androidDriver = cap.scroll(visibleText);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        visibleText = "Deactivate InfoFlash";
        //Below statement calls a function in CommonFunctions class to scroll to the test passed by function and click on it
        androidDriver = cap.scroll(visibleText);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Next line clicks on Back button on the emulator
        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        visibleText = "Einstellungen";
        //Below statement calls a function in CommonFunctions class to scroll to the test passed by function and click on it
        androidDriver = cap.scroll(visibleText);
        androidDriver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
    }

    @Test
    public void person_mitteilung() throws IOException, BiffException, InterruptedException {
        visibleText = "Persönliche Mitteilungen";
        //Below statement will click on toggle button of "Persönliche Mitteilungen" link
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.CheckBox")).click();
        androidDriver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        //Below statement will click on "LOS GEHT'S"
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Below statement will click on WEITER button
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Below statement will click on OK button
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Below for loop will verify if the 4 toggle buttons are enabled or not

        System.out.println("Context: " + androidDriver.getContext());
        androidDriver.context("NATIVE_APP");
        System.out.println("Context: " + androidDriver.getContext());

        for (int h = 1; h <= 4; ) {
            if (androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout['" + h + "']/android.widget.CheckBox")).isEnabled()) {
                System.out.println(h + " toggle is already selected");
            } else {
                System.out.println("It is not selected");
                //Below statement will enable the corresponding toggle button
                androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout['" + h + "']/android.widget.CheckBox")).click();
            }
            h++;
        }
        //Below statement will click on Back button of emulator
        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        //Below statement will click on Back button of emulator
        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }

    @Test
    public void login()
    {
        //Below statement will click on Login button
        androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[3]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        //Below statement to store the value of one of the component on screen to check the relevant screen
        String str = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
        //Below if block checks if below mentioned string is available on the screen
        if (str.equals("Konto auswählen")) {
            //Below statement will click on radio button related to ct458
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RadioGroup/android.widget.RadioButton[1]")).click();
            androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            //Below statement will click on OK button
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")).click();
        }
        //Below Else block will be executed if "Konto auswählen" string is not visible on the page
        else {
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[1]")).clear();
            //Below statement will enter User ID in the text box
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[1]")).sendKeys("ct458");
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[2]")).clear();
            androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            //Below statement will enter Password in the text box
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText[2]")).sendKeys("start123");
            //Below statement will click on OK button
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button")).click();
        }

//        Boolean isVisible = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")).isEnabled();
        int totalWait = 0;


        while (true) {
            //Boolean isVisible = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[1]")).is();
            Boolean isVisible = cap.isElementPresent(androidDriver, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView");
            if (isVisible) {
                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
                androidDriver.pressKeyCode(AndroidKeyCode.ENTER);
                System.out.println("Inside try ");
                flag = 1;
                break;
            } else {
                System.out.println("Waiting");
                androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                totalWait = +10;
                if (totalWait == 50) {
                    flag = 0;
                    break;
                }
            }
        }

/*
        Boolean isVisible = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[1]")).isEnabled();
        int totalWait = 0;

        while (true) {
            if (isVisible) {
                System.out.println("Inside try ");
                break;
            } else {
                System.out.println("Waiting");
                androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                totalWait = +10;
                if (totalWait == 90) {
                    break;
                }
            }
        }*/

        if (flag == 0) {
            androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[2]")).click();
            String Handset = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
            String customer_number = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
            String kundennummber = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")).getText();
            String KunderKonto = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText();
            String Vertrag_number = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).getText();

            System.out.println("Handset is : " + Handset);
            System.out.println("customer_number is : " + customer_number);
            System.out.println("kundennummber is : " + kundennummber);
            System.out.println("KunderKonto is : " + KunderKonto);
            System.out.println("Vertrag_number is : " + Vertrag_number);


     /*   List arrObj = new ArrayList();

        arrObj    = androidDriver.findElements(By.partialLinkText("magenta"));*/

        }
    }
    @After
    public void End() {
        // driver.quit();
        androidDriver.quit();
    }
}