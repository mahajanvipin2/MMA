package com.example.mma;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;

public class commonFunctions {
    AndroidDriver androidDriver=null;
    DesiredCapabilities capabilities=null;
    ExcelLib excel_Device = null;
    public static MobileElement mobileElement;


    public AndroidDriver scroll(String text){
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
        return androidDriver;
    }

    public AndroidDriver app_launch() throws IOException, BiffException {

        //Below statement creates an Object Reference of DesiredCapabilities class
        capabilities = new DesiredCapabilities();
        //Below statement creates a reference of ExcelLib class and provide input excel Workbook and sheet name
        excel_Device=new ExcelLib("C:\\input_File_Selenium\\Appium_excel.xls","DeviceDetails");
        // Set android deviceName desired capability. Set your device name by reading from input sheet "DeviceDetails"
        capabilities.setCapability(excel_Device.ReadCell(0,0), excel_Device.ReadCell(0,1));
        // Set android platformName desired capability by reading from input sheet "DeviceDetails". It's Android in our case here.
        capabilities.setCapability(excel_Device.ReadCell(1,0),excel_Device.ReadCell(1,1));
        // Set your application's appPackage by reading from input sheet "DeviceDetails"
        capabilities.setCapability(excel_Device.ReadCell(2,0),excel_Device.ReadCell(2,1));
        // Set your application's appActivity by reading from input sheet "DeviceDetails"
        capabilities.setCapability(excel_Device.ReadCell(3,0),excel_Device.ReadCell(3,1));

        // Launch the application with the URL mentioned in input sheet "DeviceDetails" and with object of DesiredCapabilities
        androidDriver= new AndroidDriver(new URL(excel_Device.ReadCell(4,1)),capabilities);
        return androidDriver;
    }


    public boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, String targetResourceId){
        Boolean isElementPresent;
        try{
            mobileElement =  (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+targetResourceId+"\")");
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        }catch(Exception e){
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        } }

    public boolean isElementPresent(AndroidDriver driver, String strxpath) {

        try {

            driver.findElement(By.xpath(strxpath));
            return true;

        } catch (NoSuchElementException e) {

            return false;
        }



    }
}

