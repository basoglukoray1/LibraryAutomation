package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    public DashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void clickToAnyModule(String modName){

        modName=modName.toLowerCase();

        WebElement locateAnyModule=Driver.getDriver().findElement(By.xpath("//li[@class='nav-item']//a[@href='#"+modName+"']"));
        locateAnyModule.click();

    }
}
