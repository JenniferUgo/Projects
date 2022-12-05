import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MonosnapWebTest {

    //Import selenium webdriver
private WebDriver driver;

@BeforeTest
public void setUp() throws InterruptedException {
    //locate where the chromedriver is and set it up
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //1. Open new Chrome browser
    driver = new ChromeDriver();
    //2. Input the URL you're testing
    driver.get("https://konga.com");
    //3. Maximize window
    driver.manage().window().maximize();
    Thread.sleep(4000);

    //Test 1. Verify that the user has input the right url and is on the right webpage
    String expectedUrl = "https://konga.com";
    if (driver.getCurrentUrl().contains(expectedUrl)) {
        //pass
        System.out.println("Correct Webpage");
    } else {
        //fail
        System.out.println("Wrong Webpage");
    }
}
    @Test (priority = 0)
            public void getPageTitle() throws InterruptedException {
        //4. Locate page title (TAKE SCREENSHOTS IN ONE CLICK) and confirm that it's present
        WebElement pageTitle = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]"));

        //Test 2. Verify that the item searched for is present.
        String expectedItemName = "All Categories";
        String actualItemName = pageTitle.getText();
        if (expectedItemName.equals(actualItemName)) {
            System.out.println("Page Title Is Present");
        }else {
            System.out.println("Page Title Not Found");
        }
        pageTitle.getText();
        Thread.sleep(4000);
    }

    //5. Click on the Login/Signup button
    @Test (priority = 1)
           public void login() throws InterruptedException {

    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
    Thread.sleep(4000);

    //Test 3. Verify that when user clicks on the signin button, user is directed to the login screen
        WebElement pageItemTitle = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/h5"));
        String expectedItemName = "Login";
        String actualItemName = pageItemTitle.getText();
        if (expectedItemName.equals(actualItemName)) {
            System.out.println("Login Screen");
        } else {
            System.out.println("Not Login Page");
        }
        pageItemTitle.getText();
        Thread.sleep(4000);


    }


    @AfterTest
    public void closeBrowser(){
    driver.quit();
    }


}
