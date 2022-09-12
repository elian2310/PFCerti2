package StepDefinitions;

import Pages.PimPage;
import Pages.RecruitPage;
import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class Hooks {

    @After("@NeedLogout")
    public void AfterScenarios(){
        PimPage pim = new PimPage(DriverManager.getDriver().driver);
        pim.clickOnUserDropdown();
        pim.clickOnLogout();
    }
    /*@After("Recruitment")
    public void afterScenarioRecruitment(){
        RecruitPage recruitPage = new RecruitPage(DriverManager.getDriver().driver);
        recruitPage.clickOnUserScrollDown();
        recruitPage.clickOnLogoutButton();
    }*/

    @AfterAll
    public static void AfterAllScenarios(){
        DriverManager.getDriver().driver.close();
    }

}
