package StepDefinitions;

import Pages.PimPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PimSteps {

    PimPage pim = new PimPage(DriverManager.getDriver().driver);
    @Given("I search for the user")
    public void searchForUser(DataTable searchInfo) throws InterruptedException {
        List<String> data = searchInfo.transpose().asList(String.class);
        pim.setSearchNameTB(data.get(0));
        pim.setSearchIdTB(data.get(1));
        Actions enter = new Actions(DriverManager.getDriver().driver);
        enter.sendKeys(Keys.ENTER).perform();
    }

    @And("I press the search button")
    public void clickOnSearchButton() {
        pim.clickOnSearch();
    }

    @Then("The first result should be")
    public void verifyResult(DataTable resultInfo) throws InterruptedException{
        List<String> data = resultInfo.transpose().asList(String.class);
        pim.waitForResults();
        Assert.assertEquals(data.get(0),pim.getFirstResultFullName());
        Assert.assertEquals(data.get(1),pim.getFirstResultId());
    }

    @And("I click on recruitment button")
    public void clickOnRecruitmentButton(){ pim.clickOnRecruitButton(); }

    @And("I click on add button")
    public void clickOnAddButton() { pim.clickOnAddButton(); }

    @And("I click on user dropdown")
    public void clickUDD(){ pim.clickOnUserDropdown(); }

    @And("I click on logout")
    public void clickLogout(){ pim.clickOnLogout();}




}
