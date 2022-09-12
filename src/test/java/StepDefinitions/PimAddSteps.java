package StepDefinitions;

import Pages.PimAddPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class PimAddSteps {
    PimAddPage pimAdd = new PimAddPage(DriverManager.getDriver().driver);

    @And("I fill the spaces with")
    public void setNewUser(DataTable userInfo) throws InterruptedException{
        List<String> data = userInfo.transpose().asList(String.class);
        pimAdd.waitForAdd();
        pimAdd.setFirstNameTB(data.get(0));
        pimAdd.setLastNameTB(data.get(1));
        pimAdd.setIdTB(data.get(2));
    }

    @And("I click on save button")
    public void clickOnSaveButton(){ pimAdd.clickOnSave(); }

    @And("I click on list button")
    public void clickOnListButton(){ pimAdd.clickOnList(); }

    @Then("Should be displayed")
    public void verifyCreated(DataTable createdInfo) throws InterruptedException{
        List<String> data = createdInfo.transpose().asList(String.class);
        Assert.assertEquals(data.get(0).replaceAll("\"",""),pimAdd.getCreatedFullName());
        Assert.assertEquals(data.get(1).replaceAll("\"",""),pimAdd.getCreatedId());
    }

    @And("I click on PIM button")
    public void clickOnPIMButton(){ pimAdd.clickOnPIMButton(); }
}
