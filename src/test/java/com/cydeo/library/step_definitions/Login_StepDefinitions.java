package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LibraryLoginPage;
import com.cydeo.library.pages.LibraryMainPage;
import com.cydeo.library.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Login_StepDefinitions {
    LibraryLoginPage loginPage = new LibraryLoginPage();
    LibraryMainPage mainPage = new LibraryMainPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("http://library1.cydeo.com/login.html");
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.inputEmail.sendKeys("librarian1@library");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.inputPassword.sendKeys("rs4BNN9G" + Keys.ENTER);
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        Assert.assertTrue(mainPage.userAvatar.isDisplayed());
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        loginPage.inputEmail.sendKeys("student1@library");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        loginPage.inputPassword.sendKeys("i2A9TgXa" + Keys.ENTER);
    }

    @When("user enters librarian username {string}")
    public void userEntersLibrarianUsername(String userName) {
        loginPage.inputEmail.sendKeys(userName);
    }

    @And("user enters librarian password {string}")
    public void userEntersLibrarianPassword(String password) {
        loginPage.inputPassword.sendKeys(password + Keys.ENTER);
    }

    @When("user enters student username {string}")
    public void userEntersStudentUsername(String userName) {
        loginPage.inputEmail.sendKeys(userName);
    }

    @And("user enters student password {string}")
    public void userEntersStudentPassword(String password) {
        loginPage.inputPassword.sendKeys(password + Keys.ENTER);
    }

    @Given("I am on the login page")
    public void ıAmOnTheLoginPage() {
        user_is_on_the_login_page();
    }

    @When("I login using {string} and {string}")
    public void ıLoginUsingAnd(String userName, String password) {
        loginPage.inputEmail.sendKeys(userName);
        loginPage.inputPassword.sendKeys(password + Keys.ENTER);
    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String name) {
        WaitUtils.waitVisibilityOfElement(mainPage.name);
        Assert.assertEquals(name, mainPage.name.getText());
    }

    @Then("dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        user_should_see_the_dashboard();
    }

    @And("there should be {int} {string}")
    public void thereShouldBeUsers(int count, String str) {
        mainPage.assertCount(count, str);
    }

    @And("I login as a librarian")
    public void ıLoginAsALibrarian() {
        ıLoginUsingAnd("librarian6@library", "n6Pt4ocG");
    }
}
