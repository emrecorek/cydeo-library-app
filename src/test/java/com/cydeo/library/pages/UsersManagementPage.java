package com.cydeo.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cydeo.utilities.Driver;

import java.util.List;

public class UsersManagementPage {

    public UsersManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//thead//th")
    public List<WebElement> tableColumns;
}
