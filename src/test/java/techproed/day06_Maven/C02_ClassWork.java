package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        Thread.sleep(1000);

        //3.Login alanine “username” yazdirin
        WebElement login =driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username"+Keys.TAB);
        Thread.sleep(1000);

        //4.Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");
        Thread.sleep(1000);

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        Thread.sleep(1000);

        //Guvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();
        Thread.sleep(1000);

        //6.Online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1000);

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amaunt = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amaunt.sendKeys("100"+ Keys.TAB);
        Thread.sleep(1000);

        //8.tarih kismina “2020-09-10” yazdirin
        WebElement tarih = driver.findElement(By.xpath("//input[@id='sp_date']"));
        tarih.sendKeys("2020-09-10");
        Thread.sleep(1000);

        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        Thread.sleep(1000);

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement kontrol =driver.findElement(By.xpath("//div[@id='alert_content']"));
        //kontrol.getText().contains("The payment was successfully submitted."
        if (kontrol.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        Thread.sleep(1000);

        //sayfayi kapatalim
        driver.close();

    }
}
