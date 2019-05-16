package com.actual.appiumapplication;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;

public class capabilities {
    AndroidDriver androidDriver=null;
    DesiredCapabilities capabilities=null;
    ExcelLib excel_Device = null;

    public AndroidDriver capab() throws IOException, BiffException {

        capabilities = new DesiredCapabilities();

        excel_Device=new ExcelLib("C:\\input_File_Selenium\\Appium_excel.xls","DeviceDetails");


        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability(excel_Device.ReadCell(0,0), excel_Device.ReadCell(0,1));

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability(excel_Device.ReadCell(1,0),excel_Device.ReadCell(1,1));
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability(excel_Device.ReadCell(2,0),excel_Device.ReadCell(2,1));

        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability(excel_Device.ReadCell(3,0),excel_Device.ReadCell(3,1));

        androidDriver= new AndroidDriver(new URL(excel_Device.ReadCell(4,1)),capabilities);
        return androidDriver;
    }
}
