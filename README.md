Description for the test task:
- Java, Maven, JUnit/TestNG, Selenium, PageObject
	Plus the use of PageFactory, logging, testreport, multibrowsers, and other features.Link to

	Test Case 1:
		1. Open a browser in full-screen mode.
		2. Go to https://www.pragmaticplay.com/en.
		3. Check if all header menu items (Home, Products, Client Hub, Company, News, Contact) are changing color on mouseover.
		4. Check if "Bingo" option in "Products" menu is changing color on mouseover.

	Test Сase 2:
		1. Open a browser in full-screen mode (or use the browser that it already opened).
		2. Navigate to https://www.pragmaticplay.com/en
		3. Select "Bingo" in the "Products" menu.
		4. Scroll down to the "Our bingo variants" section
		5. Verify that there are 9 Bingo themes.
		6. Verify that the elements aren't duplicated.
		7. Verify that the link to the image contains a theme's name (i.e. Rock'n'Swing, Bingo Blast, Boombox, etc.).
		8. Close a browser.


	Expected result:
		- The project is hosted in git-repository.
		- The project is run using maven
		- All tests passed successfully
		- The execution result must not contain unhandled exceptions
    
    
What has been done:
     - Java, Maven, TestNG, Selenium, PageObject, PageFactory, testreport (Surefire), WebDriverManager (support for next browsers: Chrome, Firefox, Edge, Safari). Current implementation has only one cofigured (initialized) browser (Chrome)
     
     Tests can be executed using maven (mvn test)
     
     NOTE: Test Case2 cannot be passed successful as the 7th step fails - link doesn't contain theme's name (more details after run in surefire-report)
