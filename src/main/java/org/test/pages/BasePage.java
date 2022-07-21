package org.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getElementColor(By selector) {
        return driver.findElement(selector).getCssValue("color");
    }

    public String getElementBackground(By selector) {
        return driver.findElement(selector).getCssValue("background-image");
    }

    public void moveToElement(By selector) {
        Actions action = new Actions(driver);
        waitForElementVisible(selector);
        action.moveToElement(driver.findElement(selector)).perform();
    }

    public WebElement waitForElementVisible(By selector) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(selector));
        } catch (TimeoutException exception){
            exception.printStackTrace();
        }
        return driver.findElement(selector);
    }

    public WebElement waitForElementClickable(By selector) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(selector));
        } catch (TimeoutException exception){
            exception.printStackTrace();
        }
        return driver.findElement(selector);
    }

    public void click(By elementBy) {
        waitForElementClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    public void assertColorOnMouseover(By selector) {
        String colorOriginal = getElementColor(selector);
        moveToElement(selector);
        String changedColor = getElementColor(selector);
        Assert.assertNotEquals(colorOriginal, changedColor);
    }

    public void assertBackgroundOnMouseover(By selector) {
        String colorOriginal = getElementBackground(selector);
        moveToElement(selector);
        String changedColor = getElementBackground(selector);
        Assert.assertNotEquals(colorOriginal, changedColor);
    }

    public void scrollToElement(By selector) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(selector));
    }

    public List<WebElement> getElementsList(By selector) {
        return driver.findElements(selector);
    }
}
