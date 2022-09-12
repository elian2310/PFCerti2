package Pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimAddPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]")
    WebElement listButton;

    @FindBy(name = "firstName")
    WebElement firstNameTB;

    @FindBy(name = "lastName")
    WebElement lastNameTB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    WebElement idTB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")
    WebElement createdName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")
    WebElement createdId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    WebElement PIMbutton;

    public PimAddPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameTB(String firstName){
        firstNameTB.sendKeys(firstName.replaceAll("\"",""));
    }
    public void setLastNameTB(String lastName){
        lastNameTB.sendKeys(lastName.replaceAll("\"",""));
    }
    public void setIdTB(String Id){
        idTB.sendKeys(Keys.CONTROL,"a");
        idTB.sendKeys(Keys.DELETE);
        idTB.sendKeys(Id.replaceAll("\"",""));
    }
    public void clickOnSave(){ saveButton.click(); }
    public void clickOnList(){ listButton.click(); }

    public void waitForAdd(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }
    public String getCreatedFullName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(createdName));
        String res = createdName.getText();
        return res;
    }
    public String getCreatedId(){
        String res = createdId.getText();
        return res;
    }

    public void clickOnPIMButton(){ PIMbutton.click(); }
}
