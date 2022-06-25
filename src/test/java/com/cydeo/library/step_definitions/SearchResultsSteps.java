package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LibraryLoginPage;
import com.cydeo.library.pages.LibraryMainPage;
import com.cydeo.library.pages.UsersManagementPage;
import com.cydeo.library.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class SearchResultsSteps {

    LibraryLoginPage loginPage = new LibraryLoginPage();
    LibraryMainPage mainPage = new LibraryMainPage();
    UsersManagementPage usersManagementPage = new UsersManagementPage();

    @And("I click on Users link")
    public void ıClickOnUsersLink() {
        mainPage.usersButton.click();
    }

    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<String> expectedColumnNames) {

        List<String> actualColumnNames = BrowserUtils.getElementsText(usersManagementPage.tableColumns);
        Assert.assertEquals(expectedColumnNames, actualColumnNames);
    }

}
