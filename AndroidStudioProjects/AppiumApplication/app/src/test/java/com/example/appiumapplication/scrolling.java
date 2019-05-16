/*package com.example.appiumapplication;

import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;
import android.util.Log;
import android.widget.ToggleButton;

import com.actual.appiumapplication.CommonFunctions;
import com.actual.appiumapplication.ExcelLib;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.stream.StreamSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;

import static android.content.Context.ACCOUNT_SERVICE;
import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.content.Context.WIFI_SERVICE;
import static android.support.v4.content.ContextCompat.getSystemService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class scrolling extends JunitTestReporter
{
    AndroidDriver androidDriver = null;
    ExcelLib excel_Device = null;
    CommonFunctions cap = null;
    int flag = 0;
    String visibleText;

    @Before
    public void setUp() throws IOException, BiffException {
        //Below statement creates an Object Reference of CommonFunctions class
        cap = new CommonFunctions();
        //Below statement calls a function in CommonFunctions class to set the Capabilities parameters
        androidDriver = cap.app_launch();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Date Dt = new Date();
/*        String fileName = "C:/Log/output" + ".txt";
        System.setOut(new PrintStream(new FileOutputStream(fileName)));*/

      /*  WifiManager w;
        w = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        w.setWifiEnabled(false);*/




//Turn off Wifi
/*

        androidDriver.setConnection(Connection.NONE);
        assertEquals(Connection.ALL, androidDriver.getConnection());

*/

//Turn on data and Wifi
        // androidDriver.setConnection(Connection.ALL);
        //assertEquals(Connection.All, androidDriver.getConnection());

//Turn just Data on
        //androidDriver.setConnection(Connection.DATA);
      //  assertEquals(Connection.DATA, androidDriver.getConnection());

//    }

/*


    @Test
    public void identifyVersion() throws IOException, BiffException, InterruptedException {
//        androidDriver.findElementByAccessibilityId("Apps").click();
        //      androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.google.android.googlequicksearchbox:id/icon')])")).click();

        androidDriver.findElement((By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'de.telekom.android.customercenter:id/closeButton')]"))).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        //Below statement clicks on Mehr
        androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'de.telekom.android.customercenter:id/main_activity_tabbar_more')]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        visibleText = "Impressum & Datenschutz";
        //Below statement calls a function in CommonFunctions class to scroll to the test passed by function and click on it.
        androidDriver = cap.scroll(visibleText);
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Next line will pring the Version number of MeinMegenta
        String versionNum = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/legal_information_fragment_version')]")).getText();
        System.out.println("Version Number of MeinMeganta is :" + versionNum);
        cap.appendLog("Version Number of MeinMeganta is :" + versionNum);
        assertEquals("Version 8.0 (1895)",versionNum);
    }

    @Test
    public void mitteilungen() throws IOException, BiffException, InterruptedException {
        //Next line clicks on Back button on the emulator
        androidDriver.findElement((By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'de.telekom.android.customercenter:id/closeButton')]"))).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'de.telekom.android.customercenter:id/main_activity_tabbar_more')]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        visibleText = "Einstellungen";
        //Below statement calls a function in CommonFunctions class to scroll to the test passed by function and click on it
        androidDriver = cap.scroll(visibleText);
        androidDriver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

     /*   ArrayList<AndroidElement> switchesText = new ArrayList<AndroidElement>();
        switchesText.addAll(androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'de.telekom.android.customercenter:id/view_switch_item_label')]")));
*/
        //String str= (androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'de.telekom.android.customercenter:id/view_switch_item_label')]")).get(3).toString());

/*
        ArrayList<AndroidElement> switches12 = new ArrayList<AndroidElement>();
        switches12.addAll(androidDriver.findElements(By.xpath("//android.widget.CheckBox[contains(@resource-id,'de.telekom.android.customercenter:id/')]")));
       if(switches12.size()>2)
       {
           cap.appendLog("Toggle of Persönliche Mitteilungen is Enabled and must be Enabled");
           cap.appendLog("Toggle of Angebote für Sie is Enabled and must be Enabled");
           cap.appendLog("Toggle of Störungsmeldungen is Enabled and must be Enabled");
           cap.appendLog("Toggle of Infos zu Ihrem Vertrag is Enabled and must be Enabled");
           cap.appendLog("Toggle of Hilfe und Service is Enabled and must be Enabled");
       }

       else {
           visibleText = "Persönliche Mitteilungen";
           //Below statement will click on toggle button of "Persönliche Mitteilungen" link
           androidDriver.findElement(By.xpath("//android.widget.CheckBox[contains(@resource-id,'de.telekom.android.customercenter:id/infoflash_setting_option_switch')]")).click();

           androidDriver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
           //Below statement will click on "LOS GEHT'S"
           // androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
           androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'de.telekom.android.customercenter:id/button_go')]")).click();

           androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
           //Below statement will click on WEITER button
           androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'de.telekom.android.customercenter:id/button_go')]")).click();
           androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
           //Below statement will click on OK button
           androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'de.telekom.android.customercenter:id/button')]")).click();
           androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

           ArrayList<AndroidElement> switches = new ArrayList<AndroidElement>();
           switches.addAll(androidDriver.findElements(By.xpath("//android.widget.CheckBox[contains(@resource-id,'de.telekom.android.customercenter:id/view_switch_item_option_switch')]")));

           ArrayList<AndroidElement> switchesText = new ArrayList<AndroidElement>();
           switchesText.addAll(androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'de.telekom.android.customercenter:id/view_switch_item_label')]")));

           System.out.println(switches.size());

           for (int h = 0; h < switches.size(); ) {
//            String flag = switches.get(h).getAttribute("checked");
               System.out.println("Toggle of " + switchesText.get(h).getText() + " is disabled but must be Enabled");
               System.out.println("Enabling Toggle of " + switchesText.get(h).getText());
               cap.appendLog("Enabling Toggle of " + switchesText.get(h).getText());
               switches.get(h).click();
               h++;
           }

       }
        assertTrue(1 == 1);
    }

    @Test
    public void nochData() {
//Below statement will click on Back button of emulator
        androidDriver.findElement((By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'de.telekom.android.customercenter:id/closeButton')]"))).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        //Below statement will click on Start button
        androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/main_activity_tabbar_start')]")).click();
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //Below statement will print MSISDN number
        String msisdn = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/card_consumption_header_phone_number')]")).getText();
        System.out.println("MSISDN is :" + msisdn);
        assertNotNull(msisdn);
        cap.appendLog("MSISDN is :" + msisdn);
        //Below statement will print Type of Sim Card
        String simType = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_pass_speedon_name')]")).getText();
        System.out.println("Type of Sim is :" + simType);
        assertNotNull(simType);
        cap.appendLog("Type of Sim is :" + simType);
        //Below statement will print remaining Data
        String availableData = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_left_text')] ")).getText();
        System.out.println("Available Data is :" + availableData);
        assertNotNull(availableData);
        cap.appendLog("Available Data is :" + availableData);
        String data = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_center_text')] ")).getText();
        System.out.print(" " + data);
        assertNotNull(data);
        cap.appendLog(" " + data);
        String measure = androidDriver.findElement(By.xpath("//*[contains(@resource-id,'de.telekom.android.customercenter:id/primary_right_tex')]")).getText();
        System.out.print(" " + measure);
        assertNotNull(measure);
        cap.appendLog(" " + measure);
    }

    @After
    public void End() {
        androidDriver.quit();
    }

}
*/