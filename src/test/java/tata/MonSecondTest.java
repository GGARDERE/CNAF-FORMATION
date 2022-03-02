package tata;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MonSecondTest {

    @Test
    public void deuxiemeTest(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();


        //Interaction classique je vais sur une URL
        driver.get("https://www.lemonde.fr");

        String titreDeLaPage = driver.getTitle();
        System.out.println(titreDeLaPage);
        Assert.assertEquals("le titre de la page n'est pas bon", "Le Monde.fr - Actualités et Infos en France et dans le monde",titreDeLaPage);
//        Assert.assertEquals("le titre de la page n'est pas bon", 1,1);
driver.quit();
    }

}
