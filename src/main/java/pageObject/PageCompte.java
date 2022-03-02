package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCompte {

  WebDriver driver;

    public PageCompte(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (name = "account.languagePreference")
    private WebElement listeDeroulanteLangue;

    @FindBy(name = "account.favouriteCategoryId")
    private WebElement listeDeroulanteAnimalPref;

    @FindBy(name = "account.bannerOption")
    private WebElement checkBoxBannerOption;

    @FindBy(name="account.listOption")
    private WebElement checkBoxListOption;


    /**
     * Cette methode me permet de selectionner le langage de l'application
     * @param langage valeur acceptées: japanese    english
     */
    public void selectionnerOptionLanguePref(String langage){
        Select select = new Select(listeDeroulanteLangue);
        select.selectByValue(langage);

    }

    /**
     * cette methode permet de selectionner sa categorie preferée pour un animal de compagnie osef de la case c'est gerer dans la mehtode
     * @param animal dogs cats fish birds reptiles
     */
    public void selectionnerCategoriePrefAnnimal(String animal){
        Select select = new Select(listeDeroulanteAnimalPref);
        select.selectByValue(animal.toUpperCase());

    }


    public boolean recupValeurCaCEnableMyBaner() {

        return checkBoxBannerOption.isSelected();
    }
    public boolean recupValeurCaCEnableMyList() {

        return checkBoxListOption.isSelected();
    }

    public void selectionnerCheckBoxMyList() {
        checkBoxListOption.click();
    }
}
