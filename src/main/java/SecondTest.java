import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class SecondTest {
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
    public void FacebookLoginTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("Facebook");
        searchTextBox.submit();
        Thread.sleep(5000);
        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")
                );
        testLink.click();
        Thread.sleep(5000);
        WebElement emailTextBox= driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailTextBox.sendKeys("leon.koruznjak@gmail.com");
        Thread.sleep(5000);
        WebElement passwordTextBox= driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        passwordTextBox.sendKeys("krivasifra123");
        Thread.sleep(5000);
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"));
        Thread.sleep(5000);
        loginButton.click();
        Thread.sleep(5000);
        Thread.sleep(5000);
        WebElement check= driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]"));
        Thread.sleep(5000);

        Assert.assertEquals(check.getText(), "The email you entered isn’t connected to an account. Find your account and log in.");
        System.out.print(check.getText());
    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
