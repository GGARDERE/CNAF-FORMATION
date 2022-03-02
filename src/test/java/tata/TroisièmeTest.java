package tata;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TroisièmeTest {

    @Test
    public void test(){

        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Interaction classique je vais sur une URL
        driver.get("http://127.0.0.1:8080/jpetstore-1.0.5-env2/");

//        driver.findElement(By.xpath("//*[@name=\"img_signin\"]")).click();
        driver.findElement(By.name("img_signin")).click();


        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement champUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

//        WebElement champUsername = driver.findElement(By.name("username"));
        WebElement champPassword = driver.findElement(By.name("password"));
        champUsername.clear();
        champUsername.sendKeys("j2ee");

        champPassword.clear();
        champPassword.sendKeys("j2ee");

        driver.findElement(By.name("update")).click();


        driver.findElement(By.xpath("//img[contains(@src, \"fish_icon.gif\")]")).click();

        driver.findElement(By.xpath("//td[.=\"Tiger Shark\"]/preceding-sibling::td//font")).click();

        driver.findElement(By.xpath("//img[contains(@src, \"button_add_to_cart\")]")).click();

String prixAutreMethode= driver.findElement(By.xpath("//td[contains(text(), \"Shark\")]/following-sibling::td[4]")).getText();
        String prixtotal1 = driver.findElement(By.xpath("//b[contains(text(), \"Sub Total\")]")).getText();

        Assert.assertEquals("Sub Total: $18,50", prixtotal1);
        WebElement champNombreTigerShark = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        champNombreTigerShark.clear();
        champNombreTigerShark.sendKeys("2");

        driver.findElement(By.xpath("//input[contains(@src, \"button_update_cart\")]")).click();

        String prixtotal = driver.findElement(By.xpath("//b[contains(text(), \"Sub Total\")]")).getText();

        Assert.assertEquals("Sub Total: $37,00", prixtotal);



    }


}
