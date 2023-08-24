package org.ime;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://imejob.com/");
        driver.findElement(By.xpath("//div[@class=' css-ackcql']/input")).sendKeys("Java");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div.css-1tje9e2-option"))));
        WebElement listelement = driver.findElement(By.cssSelector("div.css-1tje9e2-option")); ////div[@id='react-select-5-listbox']/div/div
        listelement.click();
        // driver.findElement(By.id("react-select-2-input")).click();
        driver.findElement(By.xpath("//div[@class='search-area']/button")).click();
        try {
            Thread.sleep(5000);
        }
        catch(Exception e){
            System.out.println(e);
        }
       // WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(25));
       // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div.css-1tje9e2-option"))));


        List<WebElement> jobList1 = driver.findElements(By.xpath("//div[@class='oppening-con ']/h2"));
        for(WebElement item : jobList1){
            System.out.println(item.getText());
        }



    }
}