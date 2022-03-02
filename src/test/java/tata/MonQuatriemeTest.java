package tata;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.PageAcceuil;
import pageObject.PageIndex;
import pageObject.PageLogin;

import java.util.concurrent.TimeUnit;

public class MonQuatriemeTest {

@Test
    public void test() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Interaction classique je vais sur une URL
        driver.get("http://127.0.0.1:8080/jpetstore-1.0.5-env2/");


        PageIndex pageIndex = new PageIndex(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        PageLogin pageLogin = pageIndex.selectionnerBoutonSingIn(wait, driver);
        PageAcceuil pageAcceuil = pageLogin.seConnecter(wait, driver, "j2ee", "j2ee");
    }

}
