package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.util.Password;

public class PageLogin {
    WebDriver driver;


    public PageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this );

    }

    @FindBy(name="username")
    private WebElement champLogin;
    @FindBy(name="password")
    private WebElement champPassword;
    @FindBy(name = "update")
    private WebElement boutonSubmit;



    public PageAcceuil seConnecter(WebDriverWait wait, WebDriver driver, String login, String password){
        wait.until(ExpectedConditions.visibilityOf(champLogin));
        wait.until(ExpectedConditions.visibilityOf(champPassword));
        wait.until(ExpectedConditions.elementToBeClickable(boutonSubmit));
        champLogin.clear();
        champLogin.sendKeys(login);
        champPassword.clear();
        champPassword.sendKeys(password);
        boutonSubmit.click();
        return new PageAcceuil(driver);
    }

    }
