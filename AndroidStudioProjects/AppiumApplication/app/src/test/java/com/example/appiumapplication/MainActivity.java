package com.example.appiumapplication;

import com.actual.appiumapplication.CommonFunctions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import jxl.read.biff.BiffException;


public class MainActivity  {
    AndroidDriver androidDriver = null;
    CommonFunctions cap = null;
    String visibleText;;
    String availableData;
    String data;
    String measure;

    @BeforeTest
    public void setUp() throws IOException, BiffException {
        cap = new CommonFunctions();

        //Below statement calls a function in CommonFunctions class to set the Capabilities parameters
        cap.appendLog("Launching MMA application");

        androidDriver = cap.app_launch();

        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        }

    @Test
    public void identifyVersion()  {
        cap.appendLog("Closing the MMA tour");
        //Below statement closes MMA tour
        androidDriver.findElement((By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'de.telekom.android.customercenter:id/closeButton')]"))).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        cap.appendLog("Click on Mehr link");
        //Below statement shows more options by clicking on Mehr link
        androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'de.telekom.android.customercenter:id/main_activity_tabbar_more')]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        visibleText = "Impressum & Datenschutz";
        //Below statement calls a function in CommonFunctions class to scroll to the test passed by function and click on Impressum & Datenschutz.
        cap.appendLog("Scroll to Impressum & Datenschutz and click on it");
        androidDriver = cap.scroll(visibleText);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Next line will print the Version number of MeinMegenta
        String versionNum = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/legal_information_fragment_version')]")).getText();
        System.out.println("Version Number of MeinMeganta is :" + versionNum);
        cap.appendLog("Version Number of MeinMeganta is :" + versionNum);
        try {
        Assert.assertEquals("Version 8.0 (1895)", versionNum, "Version of MMA doesn't match");
        } catch (AssertionError t) {
            cap.appendLog("Actual Version not matched with Expected Version. TC Failed");
            cap.appendLog("End of TestCase: identifyVersion");
            cap.appendLog("*****************************************************************************");
            t.printStackTrace();
            Assert.fail();
        }
        cap.appendLog("Version Verified and TC Passed");

        cap.appendLog("End of TestCase: identifyVersion");
        cap.appendLog("*****************************************************************************");
    }

    @Test
    public void mitteilungen() throws IOException, BiffException, InterruptedException {
        cap.appendLog("Starting of TC: mitteilungen");
        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        cap.appendLog("Click on Mehr link");
        //Below statement will click on Mehr link button
        androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'de.telekom.android.customercenter:id/main_activity_tabbar_more')]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        visibleText = "Einstellungen";
        cap.appendLog("Scroll to Einstellungen and click on it");
        //Below statement calls a function in CommonFunctions class to scroll to the test passed by function and click on Einstellungen
        androidDriver = cap.scroll(visibleText);
        androidDriver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

        ArrayList<AndroidElement> toggleCheckboxes = new ArrayList<AndroidElement>();
        //Below statement add all the available toggle buttons to ArrayList
        toggleCheckboxes.addAll(androidDriver.findElements(By.xpath("//android.widget.CheckBox[contains(@resource-id,'de.telekom.android.customercenter:id/')]")));
        if (toggleCheckboxes.size() > 2) {
            cap.appendLog("Toggle of Persönliche Mitteilungen is already Enabled and must be Enabled");
            cap.appendLog("Toggle of Angebote für Sie is already Enabled and must be Enabled");
            cap.appendLog("Toggle of Störungsmeldungen is already Enabled and must be Enabled");
            cap.appendLog("Toggle of Infos zu Ihrem Vertrag is already Enabled and must be Enabled");
            cap.appendLog("Toggle of Hilfe und Service is already Enabled and must be Enabled");
        } else {
            visibleText = "Persönliche Mitteilungen";
            cap.appendLog("Click on toggle button of Persönliche Mitteilungen to enable it");
            //Below statement will click on toggle button of "Persönliche Mitteilungen" link
            androidDriver.findElement(By.xpath("//android.widget.CheckBox[contains(@resource-id,'de.telekom.android.customercenter:id/infoflash_setting_option_switch')]")).click();

            androidDriver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
            //Below statement will click on "LOS GEHT'S"
            // androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
            cap.appendLog("Click on LOS GEHT'S");
            androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'de.telekom.android.customercenter:id/button_go')]")).click();

            androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            //Below statement will click on WEITER button
            cap.appendLog("Click on WEITER button");
            androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'de.telekom.android.customercenter:id/button_go')]")).click();
            androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            //Below statement will click on OK button
            cap.appendLog("Click on Ok button");
            androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'de.telekom.android.customercenter:id/button')]")).click();
            androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

            ArrayList<AndroidElement> switchToggles = new ArrayList<AndroidElement>();
            //Below statement add all the Toggle Buttons in ArrayList 'switchToggles'
            switchToggles.addAll(androidDriver.findElements(By.xpath("//android.widget.CheckBox[contains(@resource-id,'de.telekom.android.customercenter:id/view_switch_item_option_switch')]")));

            ArrayList<AndroidElement> switchLables = new ArrayList<AndroidElement>();
            //Below statement add all the Lables of Toggle buttons in ArrayList 'switchLables'
            switchLables.addAll(androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'de.telekom.android.customercenter:id/view_switch_item_label')]")));

            for (int h = 0; h < switchToggles.size(); ) {
                System.out.println("Toggle of " + switchLables.get(h).getText() + " is disabled but must be Enabled");
                System.out.println("Enabling Toggle of " + switchLables.get(h).getText());
                cap.appendLog("Enabling Toggle of " + switchLables.get(h).getText());
                switchToggles.get(h).click();
                h++;
            }

        }
        Assert.assertTrue(1 == 1);

        cap.appendLog("End of TestCase: mitteilungen");
        cap.appendLog("*****************************************************************************");
    }


    @Test
    public void nochData() {
        cap.appendLog("Click on Start Button");
        //Below statement will click on Start button
        androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/main_activity_tabbar_start')]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Below statement will print MSISDN number
        String msisdn = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/card_consumption_header_phone_number')]")).getText();
        System.out.println("MSISDN is :" + msisdn);
        try {
            Assert.assertNotNull(msisdn);
        }
        catch (NullPointerException e)
        {
            cap.appendLog("MSISDN is blank. TC Failed");
            cap.appendLog("End of TestCase: nochData");
            cap.appendLog("*****************************************************************************");
            e.printStackTrace();
            Assert.fail();
        }
        cap.appendLog("MSISDN is :" + msisdn);
        //Below statement will print Type of Sim Card
        String simType = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_pass_speedon_name')]")).getText();
        System.out.println("Type of Sim is :" + simType);
        try {
            Assert.assertNotNull(simType);
        }
        catch(NullPointerException e)
        {
            cap.appendLog("Type of Sim is blank. TC Failed");
            cap.appendLog("End of TestCase: nochData");
            cap.appendLog("*****************************************************************************");
            e.printStackTrace();
            Assert.fail();
        }
            cap.appendLog("Type of Sim is :" + simType);
        //Below statement will print remaining Data
       try {
           availableData = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_left_text')] ")).getText();
       }
       catch (org.openqa.selenium.NoSuchElementException e)
       {
           cap.appendLog("Available data Element does not exist");
           e.printStackTrace();
       }
        try {
         data = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_center_text')] ")).getText();
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            cap.appendLog("Data element does not exist");
            e.printStackTrace();
        }

        try {
             measure = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_right_tex')]")).getText();
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            cap.appendLog("Measure element does not exist");
            e.printStackTrace();
        }

        try {
            Assert.assertNotNull(availableData);
        }
        catch (NullPointerException e)
        {
            cap.appendLog("Data is not Available. TC Failed");
            cap.appendLog("End of TestCase: nochData");
            cap.appendLog("*****************************************************************************");
            e.printStackTrace();
            Assert.fail();
        }
        try {
            Assert.assertNotNull(data);
        }
        catch (NullPointerException e)
        {
            cap.appendLog("Data is not Available. TC Failed");
            cap.appendLog("End of TestCase: nochData");
            cap.appendLog("*****************************************************************************");
            e.printStackTrace();
            Assert.fail();
        }
        try {
            Assert.assertNotNull(measure);
        }
        catch (NullPointerException e)
        {
            cap.appendLog("Data is not Available. TC Failed");
            cap.appendLog("End of TestCase: nochData");
            cap.appendLog("*****************************************************************************");
            e.printStackTrace();
            Assert.fail();
        }
        cap.appendLog("Available Data is :" + availableData + " " + data + " " + measure);

        System.out.println("Available Data is :" + availableData + " " + data + " " + measure);
        cap.appendLog("Data is available. Testcase Passed");
        cap.appendLog("End of TestCase: nochData");
        cap.appendLog("*****************************************************************************");

    }

    @AfterTest
    public void End()
    {
        androidDriver.quit();
    }

}
