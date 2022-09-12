package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitAddPage {
    WebDriver driver;

    @FindBy(name = "firstName")
    WebElement firstNameTB;

    @FindBy(name = "lastName")
    WebElement lastNameTB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div")
    WebElement vacancySelect;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    WebElement emailTB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a")
    WebElement recruitmentButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[8]/button[2]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]")
    WebElement candidatesButton;

    public RecruitAddPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameTB(String fname){ firstNameTB.sendKeys(fname); }
    public void setLastNameTB(String lname){ lastNameTB.sendKeys(lname); }
    public void setEmailTB(String email){ emailTB.sendKeys(email); }
    public void clickOnSave(){ saveButton.click(); }

    public void clickOnRecruit(){ recruitmentButton.click(); }

    public void selectVacancy(){
        vacancySelect.click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,Keys.ENTER)).perform();
    }
}
