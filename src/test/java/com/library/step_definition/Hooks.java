package com.library.step_definition;

import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    //for ui
    @Before
    public void uiSetup() {

    }

    //for ui
    @After
    public void uiTearDown(Scenario scenario) {

        // check if scenario failed or not
        if(scenario.isFailed()){
            //this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            // scenario.attach(screenshot,"image/png","what ever we want");
            scenario.attach(screenshot,"image/png","Image for failed step");
        }
        Driver.closeBrowser();
    }

    //for DB
    @Before
    public void dbSetup() {

    }

    //for DB
    @After
    public void dbTearDown() {
        DB_Util.destroy();
    }






}
