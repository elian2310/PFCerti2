package StepDefinitions;

import Pages.RecruitPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RecruitSteps {
    RecruitPage recruitPage = new RecruitPage(DriverManager.getDriver().driver);

    @Given("I search for the vacancy")
    public void searchVacancy(DataTable vacancyInfo) throws InterruptedException{
        List<String> data = vacancyInfo.transpose().asList(String.class);
        recruitPage.fillNameTB(data.get(0));
        recruitPage.fillDateTB(data.get(1));
        recruitPage.fillDate2TB(data.get(2));
        recruitPage.clickOnVacancy();
        recruitPage.setSelectVacancy();
        Actions enter = new Actions(DriverManager.getDriver().driver);
        enter.sendKeys(Keys.ENTER).perform();
    }

    @And("I click on search button")
    public void clickOnSearchButton(){ recruitPage.clickOnSearch(); }

    @Then("The first result needs to be")
    public void verifySearchResult(DataTable resultInfo) throws InterruptedException{
        List<String> data = resultInfo.transpose().asList(String.class);
        recruitPage.waitForResults();
        Assert.assertEquals(data.get(0),recruitPage.getFirstResultName());
        Assert.assertEquals(data.get(1),recruitPage.getFirstResultVacancy());
    }
    @And("I press add button")
    public void pressAddButton() { recruitPage.clickOnAdd(); }

    @And("I search for the new vacancy of {string}")
    public void searchFor(String name){
        recruitPage.fillNameTB(name);
        recruitPage.clickOnVacancy();
        recruitPage.setSelectVacancy2();
        Actions enter = new Actions(DriverManager.getDriver().driver);
        enter.sendKeys(Keys.ENTER).perform();
    }

    @Then("The first result needs to be {string}")
    public void verifyNameResult(String name){
        recruitPage.waitForResults();
        Assert.assertEquals(name, recruitPage.getFirstResultName());
    }
}
