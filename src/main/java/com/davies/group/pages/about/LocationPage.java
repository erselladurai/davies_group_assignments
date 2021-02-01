package com.davies.group.pages.about;

import com.davies.group.constants.PageTitleConstants;
import com.davies.group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocationPage extends BasePage {

    private WebDriverWait wait;

    private String title = "//h1[contains(.,'%s')]";
    private String locationMarkers = "//h2[contains(.,'%s')]/following-sibling::div//*[contains(@class,'location__marker')]";

    @FindBy(xpath = "//*[contains(@class,'location__description') and contains(@class,'show')]")
    private WebElement locationdescription;

    @FindBy(xpath = "//*[@id='main-menu']//*[@class='menu header-menu show-for-large']//*[.='About']")
    private WebElement AboutLink;

    @FindBy(xpath = "//*[@id='main-menu']//*[@class='menu header-menu show-for-large']//*[.='About']/..//*[contains(text(),'Locations')]")
    private WebElement locationsLink;

    public LocationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void untilPageLoads() {
        title = String.format(title, PageTitleConstants.SOLUTIONS_PAGE);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(title)));
    }

    public void clickLocationsLink() throws InterruptedException {
        mouseOver(AboutLink);
        jsClick(locationsLink);
    }

    public void captureStokeOfficeAddresses(String region, String locationtext) throws Exception {
        // UK & Ireland
        String xpath = String.format(locationMarkers, region);
        List<WebElement> elementlist = findAll(xpath);
        List<String> listLocationDescription = new ArrayList<>();
        elementlist.forEach(element->
        {
            jsClick(element);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(locationdescription.getText().toLowerCase().contains(locationtext)){
                listLocationDescription.add(locationdescription.getText());
            }
        });

//        List<String> listLocationDescription = elementlist.stream().peek(this::jsClick)
//               .peek(a-> {
//                   try {
//                       Thread.sleep(1000);
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();
//                   }
//               })
//                .map(a -> locationdescription.getText())
//                .filter(a -> a.toLowerCase().contains("stroke"))
//                .collect(Collectors.toList());

        if (listLocationDescription.size() > 0) {
            listLocationDescription.forEach(System.out::println);
        } else {
            throw new Exception("No location found matching the " + locationtext);
        }
    }

}
