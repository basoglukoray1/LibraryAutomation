package com.library.step_definition;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US3 {

    String mostPopularBookGenre;
    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                " inner join books b on bb.book_id = b.id\n" +
                " inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc");
        mostPopularBookGenre = DB_Util.getFirstRowFirstColumn();

        System.out.println(mostPopularBookGenre);

    }
    @Then("verify that {string} is the most popular book genre.")
    public void verify_that_is_the_most_popular_book_genre(String expectedBookGenre) {
        Assert.assertEquals(mostPopularBookGenre, expectedBookGenre);
    }
}
