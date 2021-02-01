package com.davies.group.pages;

import com.davies.group.constants.PageTitleConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SolutionsPage extends BasePage {

    private WebDriverWait wait;

    private String title = "//h2[contains(.,'%s')]";

    @FindBy(xpath = "//*[@id='main-menu']//*[@class='menu header-menu show-for-large']//*[.='Solutions']")
    private WebElement solutionsLink;

    @FindBy(xpath = "//*[contains(@class,'dg-cases-section dg-cases-section--solutions')]//p[.='View All']")
    private WebElement viewAllLink;

    @FindBy(xpath = "//*[@id='select2--container']")
    private WebElement searchBox;



    public SolutionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void untilPageLoads() {
        title = String.format(title, PageTitleConstants.SOLUTIONS_PAGE);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(title)));
    }

    public void untilCasestudyPageloads(){
        title = String.format(title, PageTitleConstants.CASE_STUDY_PAGE);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(title)));
    }

    public void clickSolutionsLink() {
        click(solutionsLink);
    }

    public void clickViewallLink() {
        click(viewAllLink);
    }

    public void clickSearchBox(){
        mouseClick(searchBox);
    }

}
