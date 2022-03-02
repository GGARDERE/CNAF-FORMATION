package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class PageAcceuil {

    WebDriver driver;

    public PageAcceuil(WebDriver driver) {
    this.driver = driver;
        PageFactory.initElements(driver, this);
    }
@FindBy(name = "img_myaccount")
private WebElement boutonMyAccount;

    @FindBy(name = "keyword")
    private WebElement champRecherche;

    public PageCompte accederAuCompte(WebDriverWait wait, WebDriver driver) {

        wait.until(ExpectedConditions.elementToBeClickable(boutonMyAccount));
        boutonMyAccount.click();

        return new PageCompte(driver);
    }

    public PageResultatRecherche accederResultaRecherche(WebDriver driver, String itemRechercher) {

        champRecherche.sendKeys(itemRechercher + Keys.ENTER);

        return new PageResultatRecherche(driver);
    }
}
