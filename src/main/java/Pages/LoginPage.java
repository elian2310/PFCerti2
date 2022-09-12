package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username")
    WebElement usernameTB;

    @FindBy(name = "password")
    WebElement passwordTB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    WebElement loginButton;

    @FindBy(className = "orangehrm-login-logo")
    WebElement logo;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitLoginClickable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }
    public void setUsernameTB(String username){ usernameTB.sendKeys(username); }
    public void setPasswordTB(String psw){ passwordTB.sendKeys(psw); }
    public void clickOnLoginButton(){ loginButton.click(); }

    public boolean loginLogoDisplayed(){
        boolean res = logo.isDisplayed();
        return res;
    }
}
