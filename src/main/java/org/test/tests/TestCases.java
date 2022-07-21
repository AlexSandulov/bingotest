package org.test.tests;

import org.test.pages.HomePage;
import org.testng.annotations.Test;

public class TestCases extends BaseTest {

    @Test
    public void testOne() {
        HomePage homePage = new HomePage(driver);

        homePage.openPage()
                .popupClose()
                .assertHomeColorOnMouseover()
                .assertProductsColorOnMouseover()
                .assertProductsBingoColorOnMouseover()
                .assertClientHubColorOnMouseover()
                .assertCompanyColorOnMouseover()
                .assertNewsColorOnMouseover()
                .assertContactColorOnMouseover()
                .assertFlagColorOnMouseover();
    }

    @Test
    public void testTwo() {
        HomePage homePage = new HomePage(driver);
        int numberOfBingoThemes = 9;

        homePage.goToBingoPage()
                .scrollToOurBingoVariantsSection()
                .verifyNumberOfThemes(numberOfBingoThemes)
                .verifyElementsUnique(numberOfBingoThemes)
                .verifyThemesLinkHasThemesName(); //this step fails because - "Reels Room" !== "Release The Kraken"

    }
}
