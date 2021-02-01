package com.tests;

import com.davies.group.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ListenerClass.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setupDriver(ITestContext ctx) {
        this.driver = DriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void quitDriver(){
        this.driver.quit();
    }
}
