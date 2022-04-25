package com.library.step_definition;

import com.library.utilities.ConfigReader;
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

    @Before("@db")
    public void dbSetup() {
        String url = ConfigReader.read("library2.db.url");
        String username = ConfigReader.read("library2.db.username");
        String password = ConfigReader.read("library2.db.password");
        DB_Util.createConnection(url, username, password);
    }

    //for DB
    @After("@db")
    public void dbTearDown() {
        DB_Util.destroy();
    }






}
