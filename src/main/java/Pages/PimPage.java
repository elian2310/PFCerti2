package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimPage {
    WebDriver driver;

    @FindBy(className = "oxd-brand-banner")
    WebElement oxdBanner;
    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userDropdown;

    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement searchNameTB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement searchIdTB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement addEmployeeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div")
    WebElement firstResultName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]/div")
    WebElement firstResultLastName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
    WebElement firstResultId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a")
    WebElement recruitmentButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    WebElement resultsText;



    public PimPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnUserDropdown(){ userDropdown.click(); }
    public void clickOnLogout(){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
    public void setSearchNameTB(String username){ searchNameTB.sendKeys(username); }
    public void setSearchIdTB(String id){ searchIdTB.sendKeys(id); }
    public void clickOnSearch(){ searchButton.click(); }
    public String getFirstResultFullName(){
        String res = firstResultName.getText() + " " +firstResultLastName.getText();
        return res;
    }
    public String getFirstResultId(){
        String res = firstResultId.getText();
        return res;
    }

    public void waitForResults(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(resultsText));
    }

    public void clickOnAddButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(resultsText));
        addEmployeeButton.click();
    }

    public void clickOnRecruitButton(){ recruitmentButton.click(); }

    public boolean verifyInPage(){
        boolean res = oxdBanner.isDisplayed();
        return res;
    }
}
