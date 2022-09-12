package StepDefinitions;

import Pages.LoginPage;
import Pages.PimPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class LoginSteps {
    LoginPage login = new LoginPage(DriverManager.getDriver().driver);
    PimPage pim = new PimPage(DriverManager.getDriver().driver);

    @Given("I login with the following credentials")
    public void fillLoginCredentials(DataTable loginInfo) throws InterruptedException {
        List<String> data = loginInfo.transpose().asList(String.class);
        login.setUsernameTB(data.get(0));
        login.setPasswordTB(data.get(1));
    }

    @And("I click on login button")
    public void clickLoginButton(){
        login.clickOnLoginButton();
    }

    @Then("Url should be PIM page's")
    public void verifyUrl(){
        //String current = DriverManager.getDriver().driver.getCurrentUrl();
        //Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList",current);
        Assert.assertTrue(pim.verifyInPage());
    }

    @Then("Url should be login page's")
    public void verifySameUrl(){
        String current = DriverManager.getDriver().driver.getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", current);

    }

    @And("banner should be displayed")
    public void verifyBanner(){
        Assert.assertTrue(login.loginLogoDisplayed());
    }
}
