import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaLoginTest {

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
        Thread.sleep(5000);

        //Test 1. Verify that the user has input the right url and is on the right webpage
        String expectedUrl = "konga.com";
        if (driver.getCurrentUrl().contains(expectedUrl)) {
            System.out.println("Correct Webpage");
        } else {
            System.out.println("Wrong Webpage");
        }
    }

    @Test(priority = 0)
    public void getPageTitle() throws InterruptedException {
        //4. Locate page title (All Categories) and confirm that it's present
        WebElement pageTitle = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]"));

        //Test 2. Verify that the item searched for is present.
        String expectedItemName = "All Categories";
        String actualItemName = pageTitle.getText();
        if (expectedItemName.equals(actualItemName)) {
            //pass
            System.out.println("Page Title Is Present");
        } else {
            //fail
            System.out.println("Page Title Not Found");
        }
        pageTitle.getText();
        Thread.sleep(5000);
    }

    //5. Click on the Login/Signup button
    @Test(priority = 1)
    public void loginButton() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(4000);

        //Test 3. Verify that when user clicks on the signin button, user is directed to the login screen
        WebElement pageItemTitle = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/h5"));
        String expectedItemName = "Login";
        String actualItemName = pageItemTitle.getText();
        if (expectedItemName.equals(actualItemName)) {
            System.out.println("Directed to Login Screen");
        } else {
            System.out.println("Not Login Page");
        }
        //pageItemTitle.getText();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void negativeSigninInvalidEmail() throws InterruptedException {
        String loginPage = "https://www.konga.com";

        //6. Locate the Email Address or Phone Number field and Input your email address
        driver.findElement(By.id("username")).sendKeys("junn@com");
        //7. Locate the password field and Input your password
        driver.findElement(By.id("password")).sendKeys("@Test01");
        //8. Click on the Login button to submit
        driver.findElement(By.xpath("//section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);

        //Test 4. Verify that user cannot log in with invalid email address
                 // Verifying if an error message is displayed
        WebElement emailValidation = driver.findElement(By.id("username"));
        String actualValidationErrorMessage = emailValidation.getAttribute("validationMessage");
        if (emailValidation.isDisplayed()) {
            System.out.println("Login failed");
        } else {
            System.out.println("Login successful");
        }
    }

    @Test(priority = 2)
    public void negativeLoginInvalidPassword() throws InterruptedException {
        String loginPage = "https://www.konga.com";
//       if (driver.getCurrentUrl().equals(loginPage)) {
//            //Refresh the page to reset all input fields
//            driver.navigate().refresh();
//        } else {
//            driver.navigate().to(loginPage);
//        }
        //6. Locate the Email Address or Phone Number field and Input your email address
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys("junn@gmail.com");
        //7. Locate the password field and Input your password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("@");
        //8. Click on the Login button to submit
        driver.findElement(By.xpath("//section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);

        //Test 5. Verify that user cannot log in with invalid password
                 // Verifying if an error message is displayed
        WebElement passwordValidation = driver.findElement(By.id("password"));
        String actualValidationErrorMessage = passwordValidation.getAttribute("validationMessage");
        if (passwordValidation.isDisplayed()) {
            System.out.println("Login failed");
        } else {
            System.out.println("Login successful");
        }
    }

    @Test(priority = 3)
    public void negativeLoginEmptyField() throws InterruptedException {
        String loginPage = "https://www.konga.com";

        //6. Locate the Email Address or Phone Number field and Input your email address
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys("");
        //7. Locate the password field and Input your password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("@Test01");
        //8. Click on the Login button to submit
        driver.findElement(By.xpath("//section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);

        //Test 6. Verify that user cannot log in with an empty field
                 // Verifying if an error message is displayed
        WebElement emailValidation = driver.findElement(By.id("username"));
        String actualValidationErrorMessage = emailValidation.getAttribute("validationMessage");
        if (emailValidation.isDisplayed()) {
            System.out.println("Login failed");
        } else {
            System.out.println("Login successful");
        }
    }

    @Test(priority = 4)
    public void negativeLoginEmptyFields() throws InterruptedException {
        String loginPage = "https://www.konga.com";

        //6. Locate the Email Address or Phone Number field and Input your email address
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys("");
        //7. Locate the password field and Input your password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("");
        //8. Click on the Login button to submit
        driver.findElement(By.xpath("//section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);

        //Test 7. Verify that user cannot log in with both fields empty
               // Verifying if an error message is displayed
        WebElement emailValidation = driver.findElement(By.id("username"));


        String actualValidationErrorMessage = emailValidation.getAttribute("validationMessage");
        if (emailValidation.isDisplayed()) {
            System.out.println("Login failed");
        } else {
            System.out.println("Login successful");
        }

        WebElement passwordValidation = driver.findElement(By.id("password"));
        String actualPasswordValidationErrorMessage = passwordValidation.getAttribute("validationMessage");
        if (passwordValidation.isDisplayed()) {
            System.out.println("Login Failed");
        } else  {
            System.out.println("Login Successful");
        }
    }

        @Test(priority = 5)
    public void positiveLogin() throws InterruptedException {
        String loginPage = "https://www.konga.com";

        //6. Locate the Email Address or Phone Number field and Input your email address
       WebElement usernameField = driver.findElement(By.id("username"));
               usernameField.clear();
               usernameField.sendKeys("junninc@gmail.com");
        //7. Locate the password field and Input your password
        WebElement passwordField = driver.findElement(By.id("password"));
               passwordField.clear();
               passwordField.sendKeys("********");
        //8. Click on the Login button to submit
        driver.findElement(By.xpath("//section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);

        //Test 8. Verify that user can log in with valid email address and password
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.konga.com/";
        if (expectedURL.equals(actualURL)) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Login unsuccessful");
        }
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void searchElement() throws InterruptedException {

        WebElement searchedItem = driver.findElement(By.xpath("//div[1]/div/div/div[4]/div/a/span"));

        //Test 9. Verify that the user logged in successfully.
        String expectedItemName = "My Account";
        String actualItemName = searchedItem.getText();
        if (expectedItemName.equals(actualItemName)){
            System.out.println("My Account is clickable");
        } else {
            System.out.println("My Account is not clickable");
        }

        //Click on the searched Item to view its content
        searchedItem.click();
        Thread.sleep(5000);
    }


   @Test(priority = 7)
    public void searchTitle() throws InterruptedException {

        WebElement searchedItem = driver.findElement(By.xpath("//div[1]/div/h1"));

        //Test 10. Verify that the item searched for is present.
        String expectedItemName = "Account Information";
        String actualItemName = searchedItem.getText();
        if (expectedItemName.equals(actualItemName)){
            System.out.println("Account Info is present");
        } else {
            System.out.println("Account Info is not present");
        }

        //Select the searched Item
        searchedItem.getText();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void searchItem() throws InterruptedException {

        WebElement searchedItem = driver.findElement(By.xpath("//div[1]/div/div/div[4]/div/a/span"));

        //Test 9. Verify that logout button is available and that the user can log out.
        String expectedItemName = "My Account";
        String actualItemName = searchedItem.getText();
        if (expectedItemName.equals(actualItemName)){
            System.out.println("Logout button is available");
        } else {
            System.out.println("Logout button is not available");
        }
        Thread.sleep(5000);
    }

    @Test (priority = 9)
    public void logoutSuccessfully() throws InterruptedException {
       driver.findElement(By.xpath("//div[1]/div/div/div[4]/div/ul/li[7]/a")).click();

        String expectedUrl = "https://konga.com";
        //Test 10. Verify that the user has logged out successfully
        if (driver.getCurrentUrl().equals(expectedUrl)) {
            //pass
            System.out.println("Not Logged Out");
        } else {
            //fail
            System.out.println("Logged Out Successfully");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
