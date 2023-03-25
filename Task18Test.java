import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task18Test {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //1. Locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        //2. Input Selenium Demo Page URL(https://selenium-blog.herokuapp.com
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1. Verify the user input the right url and he's on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
        //3.Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test7 Verify user can signup with valid username and details
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("faith52");
        //6. input email in the email field
        driver.findElement(By.id("user_email")).sendKeys("faith52@mailinator.com");
        //7. Locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("Faith@007");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(15000);
    }

    @Test(priority = 1)
    public void clickMeaghanItem() throws InterruptedException {
        //9. Click on Meaghan item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2. verify that user is directed to the signup page by clicking the signup button
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct Webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(10000);
    }
    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (Using Python with Selenium) and confirm that it is present
        driver.findElement(By.xpath("//html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test9. verify that an item (Using Python with Selenium) is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Page Contains Item");
        else
            //fail
            System.out.println("Page does not contain Item");
        Thread.sleep(10000);
    }

    @Test (priority = 3)
    public void logoutSuccessfully () throws InterruptedException {

        //11. CLick on logout
        //Test10 verify that user is directed to Homepage when User logs out
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(10000);
        String expectedTitle = "https://selenium-blog.herokuapp.com/signup                           ";
        String actualTitle = driver.getCurrentUrl();
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("User directed to homepage");
        else
            //fail
            System.out.println("USer not directed to Homepage");
    }

    @Test(priority = 4)
    public void negativeSignup() throws InterruptedException {
        //Click on the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
        //Test3 Verify user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Fa");
        //6. input email in the email field
        driver.findElement(By.id("user_email")).sendKeys("fa35@mailinator.com");
        //7. Locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("Faith@007");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }

}
