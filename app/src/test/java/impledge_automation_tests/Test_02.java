package impledge_automation_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_02 {
    static WebDriver driver;
    public static void setDriver(){
    WebDriverManager.chromedriver().timeout(30).setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException{
        setDriver();
        driver.get("https://ecs-qa.kloudship.com");
        Thread.sleep(3000);
        //STEP-1  login with the given credentials
        WebElement user = driver.findElement(By.id("login-email"));
        user.sendKeys("kloudship.qa.automation@mailinator.com");
        WebElement pwd = driver.findElement(By.id("login-password"));
        pwd.sendKeys("Password1");
        WebElement button = driver.findElement(By.id("login-btn"));
        button.click();
        System.out.println("Login is done"); 
        Thread.sleep(3000);
        
        //STEP-2 Navigate to the package
        WebElement pack = driver.findElement(By.xpath("//div[@class='row count-card-wrapper']//span[text()='Packages']"));
        pack.click();
        WebElement newPackage = driver.findElement(By.xpath("//div[text()=' Etika 7 x 8 x 9 ']"));
        Thread.sleep(2000);
        if(newPackage.isSelected()){
            newPackage.click();
        }
        System.out.println("package is visible");
        
        WebElement deleteBtn = driver.findElement(By.xpath("//mat-icon[text()='delete']"));
        Thread.sleep(2000);
        deleteBtn.click();
        
        //STEP-3 Delete the new added package
        WebElement deletePackage = driver.findElement(By.xpath("//span[text()=' Delete Package Type']"));
        deletePackage.click();

        WebElement threeBtn = driver.findElement(By.xpath("//mat-icon[text()='more_vert']"));
        if(threeBtn.isDisplayed()){
            threeBtn.click();
        }
        Thread.sleep(3000);
        
        //STEP-04 Clicking on LOGOUT button
        WebElement logoutBtn = driver.findElement(By.xpath("//div[contains(@class,'mat-menu-content')]//mat-icon[text()='power_settings_new']"));
        logoutBtn.click();
        System.out.println("LogOut is done");

        driver.close();
        driver.quit();
    }
}
