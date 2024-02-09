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
public class FourthTest {
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
//Go to www.swtestacademy.com
        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("imdb");
        searchTextBox.submit();

        Thread.sleep(5000);

        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")
                );
        testLink.click();
        Thread.sleep(5000);

        WebElement search =
                driver.findElement(By.xpath("//*[@id=\"suggestion-search\"]")
                );
        search.sendKeys("untochables");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);

        String expectedText = "The Untouchables";
        WebElement movieName = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[2]/div[1]/h1/span"));


        Assert.assertEquals(movieName.getText(), "The Untouchables");
        System.out.print(movieName.getText());
    }

    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}