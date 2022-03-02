package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageResultatRecherche {
    WebDriver driver;
    public PageResultatRecherche(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //obtient les lignes du resultat du tableau sans les entetes
@FindBy(xpath="//b[.=\"Product ID\"]/ancestor::tr/following-sibling::tr")
private List<WebElement> lignesResultatRecherche;

    private int accederAUnAnimal(String ceQueJeCherche ){
        int lignecourante=1;
        for (WebElement ligne : lignesResultatRecherche){
              List<WebElement> cellules = ligne.findElements(By.xpath("./td"));
              for (WebElement cellule : cellules){
                  if (cellule.getText().equalsIgnoreCase(ceQueJeCherche)){
                      return lignecourante;
                  }
              }
              lignecourante++;
        }


return -1;
    }

    public PageAnimalQueJeRecherche accederAnimalQueJeRecherche(WebDriver driver, String ceQueJeRecherche){

        int ligneDansLeTableau = accederAUnAnimal(ceQueJeRecherche);
        driver.findElement(By.xpath("(//font[contains(text(), \"K9\")])["+ligneDansLeTableau+"]")).click();


        return  new PageAnimalQueJeRecherche(driver);
    }



}
