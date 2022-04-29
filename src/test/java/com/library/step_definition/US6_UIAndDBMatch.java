package com.library.step_definition;

import com.library.pages.BooksPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.ConfigReader;
import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class US6_UIAndDBMatch {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    BooksPage booksPage=new BooksPage();
    List<String> actualData=new ArrayList<>();

    @Given("I log in as a librarian")
    public void i_log_in_as_a_librarian() {
        loginPage.login();
    }
    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String string) {
        BrowserUtil.waitFor(5);
        dashBoardPage.clickToAnyModule("Books");
    }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        BrowserUtil.waitFor(5);
        actualData=booksPage.bookCategories();
    }



    List<String> expectedData = new ArrayList<>();

    @When("I execute a query to get book categories")
    public void i_execute_a_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");
        expectedData=DB_Util.getColumnDataAsList("name");
    }
    @Then("verify book categories must match the book_categories table from DB.")
    public void verify_book_categories_must_match_the_book_categories_table_from_db() {
        Assert.assertEquals(expectedData, actualData);
    }
}