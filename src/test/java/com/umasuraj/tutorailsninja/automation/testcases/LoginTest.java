package com.umasuraj.tutorailsninja.automation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    @Test
    public void verifyLoginWithValidCredentials() {
        // System.setProperty("webdriver.chrome.driver", "D:\\ITGuru\\Selenium\\ChromeDriver\\111.0.5563.64\\chromedriver.exe");WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String expectedMessage = "Edit your account information";
        String actualMessage = driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        driver.quit();
    }
}
