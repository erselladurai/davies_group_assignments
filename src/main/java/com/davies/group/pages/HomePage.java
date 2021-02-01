package com.davies.group.pages;

import com.davies.group.constants.PageTitleConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@href,'https://www.linkedin.com/company/daviesgroup')]")
    private WebElement davisGrouplinkedXpath;

    @FindBy(name = "//*[contains(@href,'https://twitter.com/Davies_Group')]")
    private WebElement davisGroupTwitterXpath;

    @FindBy(name = "//*[.='Davies Group']")
    private List<WebElement> davisGroupTwitterPageXpath;

    private String title = "//p[contains(.,'%s')]";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void untilPageLoads() {
        title = String.format(title, PageTitleConstants.HOME_PAGE);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(title)));
    }

    public void clickTwitterLink() {
        jsClick(davisGroupTwitterXpath);
    }

    public void clickLinkedInLink() {
        jsClick(davisGrouplinkedXpath);
    }

    public void verifyDaviesLinkedInPage() throws Exception {
        switchWindowBasedOnTitle("Sign Up | LinkedIn");
        Assert.assertTrue(getCurrentUrl().contains("sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fdaviesgroup%2F"));
        switchToDefaultwindow();
    }
    public void verifyDaviesTwitterPage() throws Exception {
        switchWindowBasedOnTitle("Sign Up | LinkedIn");
        Assert.assertTrue(davisGroupTwitterPageXpath.size()>0);
        switchToDefaultwindow();
    }
}
