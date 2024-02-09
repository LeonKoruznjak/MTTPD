import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class ThirdTest {
    //-------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "http://www.google.com";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }
    @Test
    public void FeritYoutubeTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("Ferit");
        searchTextBox.submit();
        Thread.sleep(5000);
        WebElement feritlink= driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));
        feritlink.click();
        Thread.sleep(5000);
        WebElement youtubeLink =
                driver.findElement(By.xpath("//*[@id=\"izbornik\"]/div[1]/div/ul/li[10]/a"));


        String mainWindowHandle = driver.getWindowHandle();
        youtubeLink.click();


        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        Thread.sleep(5000);
        WebElement youtubePageName= driver.findElement(By.xpath("//*[@id=\"text\"]"));
        Thread.sleep(5000);


        Assert.assertEquals(youtubePageName.getText(), "TvUnios");
        System.out.print(youtubePageName.getText());
    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
