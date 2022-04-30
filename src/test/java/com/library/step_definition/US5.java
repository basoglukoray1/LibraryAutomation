package com.library.step_definition;

import com.library.pages.BooksPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.DB_Util;
import com.library.utilities.QueryReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US5_step_definitions {

       DashBoardPage dashBoardPage=new DashBoardPage();
       BooksPage booksPage = new BooksPage();
       LoginPage loginPage= new LoginPage();

    @Given("I am in the homepage of library app")
    public void i_am_in_the_homepage_of_library_app() {

        loginPage.login();

    }
    @When("I navigate to Books page")
    public void iNavigateToBooksPage() {

     dashBoardPage.clickToAnyModule("Books");
    }
    @When("I open a book called {string}")
    public void i_open_a_book_called(String bookName) {
        booksPage.search.sendKeys(bookName);

        BrowserUtil.waitFor(2);


    }
    @When("I execute query to get the book information from books table")
    public void i_execute_query_to_get_the_book_information_from_books_table() {
       DB_Util.runQuery(QueryReader.read("us5_book_info"));
    }
    @Then("verify book DB and UI information must match")
    public void verify_book_db_and_ui_information_must_match() {

        DB_Util.runQuery(QueryReader.read("us5_book_info"));

// Verify Book Name UI & DB
        String nameUI = booksPage.bookName.getText();
        String nameDB = DB_Util.getFirstRowFirstColumn();

        System.out.println("nameUI = " + nameUI);
        System.out.println("nameDB = " + nameDB);

        Assert.assertEquals(nameDB,nameUI);


// Verify Author UI & DB

        String authorUI = booksPage.authorName.getText();
        String authorDB =  DB_Util.getCellValue(1,2);
        System.out.println("authorUI = " + authorUI);
        System.out.println("authorDB = " + authorDB);

        Assert.assertEquals(authorDB,authorUI);


// Verify Year UI & DB

        String yearUI = booksPage.year.getText();
        String yearDB = DB_Util.getCellValue(1,3);
        System.out.println("yearUI = " + yearUI);
        System.out.println("yearDB = " + yearDB);

        Assert.assertEquals(yearDB,yearUI);

    }
}
