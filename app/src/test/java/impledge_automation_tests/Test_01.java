package impledge_automation_tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_01 {
    static WebDriver driver;
    public static void setDriver(){
     WebDriverManager.chromedriver().timeout(30).setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
        public static void main(String[] args) throws InterruptedException{
        setDriver();
        //STE- 01 Login with the credentials
        driver.get("https://ecs-qa.kloudship.com");
        Thread.sleep(3000);

        WebElement user = driver.findElement(By.id("login-email"));
        user.sendKeys("kloudship.qa.automation@mailinator.com");
    
        WebElement pwd = driver.findElement(By.id("login-password"));
        pwd.sendKeys("Password1");
       
        WebElement button = driver.findElement(By.id("login-btn"));
        button.click();
        System.out.println("Login is done");

        //STEP-02 and STEP-03 Navigate to package and add
        WebElement pack = driver.findElement(By.xpath("//div[@class='row count-card-wrapper']//span[text()='Packages']"));
        pack.click();
        WebElement plusBtn = driver.findElement(By.xpath("//mat-toolbar[contains(@class,'ng-star-inserted')]//mat-icon[text()='add']"));
        plusBtn.click();
        Thread.sleep(2000);
        
        //STEP-04 Adding the package details
        WebElement enterName = driver.findElement(By.id("mat-input-1"));
        enterName.sendKeys("Etika");
        
        Thread.sleep(3000);
        WebElement length = driver.findElement(By.id("mat-input-2"));
        length.clear();
        length.sendKeys("7");
        Thread.sleep(3000);
       
        WebElement width = driver.findElement(By.id("mat-input-3"));
        width.clear();
        width.sendKeys("8");
        Thread.sleep(3000);
        
        WebElement hight = driver.findElement(By.id("mat-input-4"));
        hight.clear();
        hight.sendKeys("9");
        
        //STEP-05 Clicking on checkout button 
        WebElement checkButton = driver.findElement(By.xpath("//mat-icon[text()='check']"));
        checkButton.click();
        Thread.sleep(2000);
        WebElement threeBtn = driver.findElement(By.xpath("//mat-icon[text()='more_vert']"));
        threeBtn.click();
        Thread.sleep(3000);
        //STEP-06 Clicking on LOGOUT button
        WebElement logoutBtn = driver.findElement(By.xpath("//div[contains(@class,'mat-menu-content')]//mat-icon[text()='power_settings_new']"));
        logoutBtn.click();
        System.out.println("LogOut is done");

        driver.close();
        driver.quit();
    }
}
 