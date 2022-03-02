package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageIndex {
    WebDriver driver;


    public PageIndex(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name ="img_signin")
    private WebElement boutonSignIn;


    public PageLogin selectionnerBoutonSingIn(WebDriverWait wait, WebDriver driver){
        wait.until(ExpectedConditions.elementToBeClickable(boutonSignIn));

        boutonSignIn.click();
        return new PageLogin(driver);

    }



}
