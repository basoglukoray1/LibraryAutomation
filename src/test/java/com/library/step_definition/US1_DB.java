package com.library.step_definition;

import com.library.utilities.ConfigReader;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US1_DB {

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        System.out.println("Database Connection is done inside the Hooks");

    }

    List<String> actualIDs;

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

        DB_Util.runQuery("select id from users");

        actualIDs = DB_Util.getColumnDataAsList(1);
    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        DB_Util.runQuery("SELECT DISTINCT id from users");

        List<String> expectedIDs = DB_Util.getColumnDataAsList(1);

        Assert.assertEquals(expectedIDs, actualIDs);
    }


}
