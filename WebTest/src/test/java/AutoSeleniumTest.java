
import org.junit.jupiter.api.*;

import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSeleniumTest {

        private static final String chromeWebDriver = "webdriver.chrome.driver";
        private static final String CHROME_WEBDRIVER_PATH = "C:\SeleniumDriver\chromedriver";
        private static ChromeDriver chromeDriver;
        private AutoSelenium autoSelenium;



        @BeforeEach
        public void setUp(){
            System.setProperty(chromeWebDriver, CHROME_WEBDRIVER_PATH);
            autoSelenium = new AutoSelenium();
            chromeDriver = new ChromeDriver();

            autoSelenium.initializeDriver
                    ("youtube.com",chromeWebDriver, CHROME_WEBDRIVER_PATH,
                            chromeDriver);
            autoSelenium.makeItFullScreen(chromeDriver);
        }

        @Test
        public void testWriteASearchOnYoutube(){
            autoSelenium.writeInForm("search", "Virgil van dijk",chromeDriver);
        }

        @Test
        public void testButtonOnYoutube(){
            autoSelenium.clickButton("search-icon-legacy", chromeDriver);
        }

        @Test
        public void gettingTextFromYoutube(){
            String expectedTextFromYoutube ="YouTube";

            String textFromYoutube = autoSelenium.gettingTextFromWebsite("logo-icon", chromeDriver);
            Assertions.assertEquals(expectedTextFromYoutube, textFromYoutube);
            }

        @AfterEach
        public void closeDriver (){
            autoSelenium.closeDriver(chromeDriver);
        }
    }

