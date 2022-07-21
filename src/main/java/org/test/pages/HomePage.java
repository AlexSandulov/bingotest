package org.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    static final String PAGELINK = "https://www.pragmaticplay.com/en/";

    By menuItemHome = By.xpath("//*[@id=\"menu-item-1185\"]/a");
    By menuItemProducts = By.xpath("//*[@id=\"menu-item-200\"]/a/div");
    By menuItemClientHub = By.xpath("//*[@id=\"menu-item-23582\"]/a");
    By menuItemCompany = By.xpath("//*[@id=\"menu-item-57201\"]/a/div");
    By menuItemNews = By.xpath("//*[@id=\"menu-item-9841\"]/a");
    By menuItemContact = By.xpath("//*[@id=\"menu-item-1820\"]/a");
    By menuItemLanguageFlag = By.xpath("//*[@id=\"menu-item-7419\"]/a/div");
    By menuProductsSubmenuBingo = By.xpath("//*[@id=\"menu-item-11081\"]/a");
    By popup = By.id("game_pop");
    By popupConfirmButton = By.className("top-btn");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage popupClose() {
        if (driver.findElement(popup).isDisplayed()) {
            waitForElementClickable(popupConfirmButton);
            click(popupConfirmButton);
        }
        return this;
    }

    public HomePage assertHomeColorOnMouseover() {
        assertColorOnMouseover(menuItemHome);
        return this;
    }

    public HomePage assertProductsColorOnMouseover() {
        assertBackgroundOnMouseover(menuItemProducts);
        return this;
    }

    public HomePage assertProductsBingoColorOnMouseover() {
        moveToElement(menuItemProducts);
        assertColorOnMouseover(menuProductsSubmenuBingo);
        return this;
    }

    public HomePage assertClientHubColorOnMouseover() {
        assertColorOnMouseover(menuItemClientHub);
        return this;
    }

    public HomePage assertCompanyColorOnMouseover() {
        assertBackgroundOnMouseover(menuItemCompany);
        return this;
    }

    public HomePage assertNewsColorOnMouseover() {
        assertColorOnMouseover(menuItemNews);
        return this;
    }

    public HomePage assertContactColorOnMouseover() {
        assertColorOnMouseover(menuItemContact);
        return this;
    }

    public HomePage assertFlagColorOnMouseover() {
        assertBackgroundOnMouseover(menuItemLanguageFlag);
        return this;
    }

    public BingoPage goToBingoPage() {
        moveToElement(menuItemProducts);
        click(menuProductsSubmenuBingo);
        return new BingoPage(driver);
    }

    public HomePage openPage() {
        driver.get(PAGELINK);
        return this;
    }

}