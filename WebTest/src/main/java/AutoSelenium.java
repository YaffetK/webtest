import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class AutoSelenium {



    public void initializeDriver(String websiteURL, String chromeWebDriver, String chromeWebDriverPath,
                                 ChromeDriver safariDriver) {
        System.setProperty(chromeWebDriver, chromeWebDriverPath);
        safariDriver.navigate().to(websiteURL);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void clickButton(String findElementById, ChromeDriver chromeDriver){
        WebElement m=chromeDriver.
                findElement(By.id(findElementById));
        m.click();
    }

    public String gettingTextFromWebsite(String findElementById, ChromeDriver chromeDriver){
        String text = chromeDriver.findElement(By.id(findElementById)).getText();
        return text;
    }

    public void writeInForm(String findElementById, String inputText,ChromeDriver chromeDriver){
        chromeDriver.findElement(By.id(findElementById)).sendKeys(inputText);
    }

    public void usingThreadSleep(int millisSecond){
        try{
            Thread.sleep(millisSecond);
        } catch (InterruptedException e){
            System.out.println("something went wrong");
        }
    }

    public void closeDriver(ChromeDriver chromeDriver){
        if (chromeDriver != null)
        {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println("something went wrong");
            }
            chromeDriver.quit();
        }
    }

    public void makeItFullScreen(ChromeDriver chromeDriver){
        chromeDriver.manage().window().maximize();
    }


}