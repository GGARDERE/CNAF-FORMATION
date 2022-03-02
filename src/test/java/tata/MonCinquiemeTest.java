package tata;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.PageAcceuil;
import pageObject.PageCompte;
import pageObject.PageIndex;
import pageObject.PageLogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonCinquiemeTest {

    @Test
    public void test(){
        //initialisation du driver
        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //gestion de l'implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Interaction classique je vais sur une URL
        driver.get("http://127.0.0.1:8080/jpetstore-1.0.5-env2/");
        //gestion d'un explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 5);

        PageIndex pageIndex = new PageIndex(driver);
        PageLogin pageLogin = pageIndex.selectionnerBoutonSingIn(wait, driver);

        PageAcceuil pageAcceuil = pageLogin.seConnecter(wait, driver, "j2ee", "j2ee");

        PageCompte pageCompte = pageAcceuil.accederAuCompte(wait, driver);

        pageCompte.selectionnerOptionLanguePref("japanese");
        pageCompte.selectionnerCategoriePrefAnnimal("reptiles");

        boolean valeurCaseACocherEnableMyBaner = pageCompte.recupValeurCaCEnableMyBaner();
        boolean valeurCaseACocherEnableMyList = pageCompte.recupValeurCaCEnableMyList();
        Assert.assertTrue("My banner n'est pas selectionner", valeurCaseACocherEnableMyBaner);
        Assert.assertTrue("My list n'est pas selectionner", valeurCaseACocherEnableMyList);
        Assert.assertTrue("l'une des deux checkbox n'a pas le bon status", valeurCaseACocherEnableMyBaner&&valeurCaseACocherEnableMyList);
        pageCompte.selectionnerCheckBoxMyList();
        boolean valeurCaseACocherEnableMyList2 = pageCompte.recupValeurCaCEnableMyList();
        Assert.assertFalse("la checkbox est toujours selecitonner", valeurCaseACocherEnableMyList2);
    }

}
