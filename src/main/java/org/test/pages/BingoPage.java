package org.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.*;

public class BingoPage extends BasePage {

    By bingoVariantsSection = By.className("games");
    By bingoVariantsCarouselActiveItems = By.className("slick-active");
    By getBingoVariantsCarouselActiveItemsImg = By.xpath("//div[contains(@class, 'slick-active')]//img");
    By carouselButtonNext = By.xpath("//div[@class='right-arrow slick-arrow']");

    public BingoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BingoPage scrollToOurBingoVariantsSection() {
        scrollToElement(bingoVariantsSection);
        return this;
    }

    private HashMap<String, String> takeElementFromCarousel() {

        HashMap<String, String> mapElements = new HashMap<>();

        List<String> itemText = new ArrayList<>();
        List<String> itemLink = new ArrayList<>();

        itemText.add(getElementsList(bingoVariantsCarouselActiveItems).get(0).getText());
        itemLink.add(getElementsList(getBingoVariantsCarouselActiveItemsImg).get(0).getAttribute("src"));

        while (true) {
            click(carouselButtonNext);
            waitForElementVisible(bingoVariantsCarouselActiveItems);
            String text = getElementsList(bingoVariantsCarouselActiveItems).get(0).getText();
            if (Objects.equals(text, itemText.get(0))) {
                break;
            }
            itemText.add(text);
            itemLink.add(getElementsList(getBingoVariantsCarouselActiveItemsImg).get(0).getAttribute("src"));
        }

        for (int i = 0; i <= itemText.size() - 1; i++) {
            mapElements.put(itemText.get(i), itemLink.get(i));
        }
        return mapElements;
    }

    public BingoPage verifyNumberOfThemes(int expectedResult) {
        Assert.assertEquals(expectedResult, takeElementFromCarousel().size());
        return this;
    }

    public BingoPage verifyElementsUnique(int expectedResult) {
        Assert.assertEquals(expectedResult, takeElementFromCarousel().values().stream().distinct().count());
        return this;
    }

    public BingoPage verifyThemesLinkHasThemesName() {
        HashMap<String, String> temporaryMap;
        temporaryMap = takeElementFromCarousel();
        for (Map.Entry<String, String> entry : temporaryMap.entrySet()) {
            String value = entry.getValue();
            String nameFromValue = value.substring(value.lastIndexOf("nail-") + 5).replace("-", " ");
            Assert.assertEquals(entry.getKey(), nameFromValue.substring(0, nameFromValue.length() - 4));
        }
        return this;
    }

}
