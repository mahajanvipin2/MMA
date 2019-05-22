package com.actual.appiumapplication;

import org.apache.commons.io.FileUtils;
import android.support.v7.app.AppCompatActivity;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.FileHandler;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;



public class CommonFunctions {
    AndroidDriver androidDriver = null;
    DesiredCapabilities capabilities = null;
    ExcelLib excel_Device = null;
    public static MobileElement mobileElement;


    public AndroidDriver scroll(String text) {
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))").click();
        return androidDriver;
    }

    public AndroidDriver app_launch() throws IOException, BiffException {

        //Below statement creates an Object Reference of DesiredCapabilities class
        capabilities = new DesiredCapabilities();
        //Below statement creates a reference of ExcelLib class and provide input excel Workbook and sheet name
        excel_Device = new ExcelLib("C:\\input_File_Selenium\\Appium_excel.xls", "DeviceDetails");
        // Set android deviceName desired capability. Set your device name by reading from input sheet "DeviceDetails"
        capabilities.setCapability(excel_Device.ReadCell(0, 0), excel_Device.ReadCell(0, 1));
        // Set android platformName desired capability by reading from input sheet "DeviceDetails". It's Android in our case here.
        capabilities.setCapability(excel_Device.ReadCell(1, 0), excel_Device.ReadCell(1, 1));
        // Set your application's appPackage by reading from input sheet "DeviceDetails"
        capabilities.setCapability(excel_Device.ReadCell(2, 0), excel_Device.ReadCell(2, 1));
        // Set your application's appActivity by reading from input sheet "DeviceDetails"
        capabilities.setCapability(excel_Device.ReadCell(3, 0), excel_Device.ReadCell(3, 1));

        // Launch the application with the URL mentioned in input sheet "DeviceDetails" and with object of DesiredCapabilities
        androidDriver = new AndroidDriver(new URL(excel_Device.ReadCell(4, 1)), capabilities);
        return androidDriver;
    }


    public void appendLog(String text) {
        File logFile = new File("C:/Log/log.file");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now = new Date();
            String strDate = sdf.format(now);
            buf.append(strDate + ":");
            buf.append(text);
            buf.newLine();
            buf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void screenCapture(AndroidDriver ad) throws IOException {
        File srcFile= ad.getScreenshotAs(OutputType.FILE);
        File screenshotName= new File("C:\\Log\\screenshots");
        FileUtils.copyFile(srcFile,screenshotName);
        Reporter.log("<br><img src='"+screenshotName+"' height='400' width='400'/>");
    }
}

