package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BooksPage {

    @FindBy(xpath = "//select[@id='book_categories']")
    public WebElement dropDownBookCategories;

    public List<String> bookCategories(){

    Select select=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='book_categories']")));
    List<WebElement> webElList= select.getOptions();
       webElList.remove(0);
    List<String> result=new ArrayList<>();

        for (WebElement each : webElList) {
        result.add(each.getText());
    }

        return result;

}
}
