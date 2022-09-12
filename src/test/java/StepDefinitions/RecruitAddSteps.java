package StepDefinitions;

import Pages.RecruitAddPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RecruitAddSteps {
    RecruitAddPage recruitAddPage = new RecruitAddPage(DriverManager.getDriver().driver);

    @And("I fill the vacancy info with")
    public void fillVacancyInfo(DataTable vacInfo) throws InterruptedException{
        List<String> data = vacInfo.transpose().asList(String.class);
        recruitAddPage.setFirstNameTB(data.get(0));
        recruitAddPage.setLastNameTB(data.get(1));
        recruitAddPage.setEmailTB(data.get(2));
        recruitAddPage.selectVacancy();
        Actions enter = new Actions(DriverManager.getDriver().driver);
        enter.sendKeys(Keys.ENTER).perform();
    }

    @And("I press the save button")
    public void pressSave(){ recruitAddPage.clickOnSave(); }

    @And("I press the recruitment button")
    public void pressRecruit(){ recruitAddPage.clickOnRecruit(); }


}
