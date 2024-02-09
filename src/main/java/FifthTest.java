import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class FifthTest {
    //-------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.imdb.com/title/tt0094226/?ref_=vp_close";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
//Create a new ChromeDriver
        driver = new ChromeDriver();
//Go to www.swtestacademy.com
        driver.navigate().to(testURL);
        driver.manage().window().maximize();
    }
    @Test
    public void ImbdVideoTest() throws InterruptedException {
        Thread.sleep(5000);
        WebElement videoLink= driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[3]/div[1]/div[2]/div[2]/a[2]/div"));
        videoLink.click();
        Thread.sleep(5000);
        WebElement startStopButton= driver.findElement(By.xpath("//*[@id=\"imdbnext-vp-jw-single\"]/div[2]/div[4]/video"));
        Thread.sleep(5000);
        startStopButton.click();
        WebElement muteButton= driver.findElement(By.xpath(" //*[@id=\"imdbnext-vp-jw-single\"]/div[2]/div[12]/div[4]/div[2]/div[4]"));
        muteButton.click();
        WebElement fullscreenButton= driver.findElement(By.xpath("//*[@id=\"imdbnext-vp-jw-single\"]/div[2]/div[12]/div[4]/div[2]/div[15]"));
        fullscreenButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(startStopButton.isDisplayed() && muteButton.isDisplayed() && fullscreenButton.isDisplayed(), "Buttons aren't available");

    }

    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}