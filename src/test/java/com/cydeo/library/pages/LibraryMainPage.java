package com.cydeo.library.pages;

import com.cydeo.library.utilities.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cydeo.utilities.Driver;

public class LibraryMainPage {

    public LibraryMainPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(id = "user_avatar")
    public WebElement userAvatar;

    @FindBy(xpath = "//a[@role='button']/span")
    public WebElement name;

    @FindBy(xpath = "(//span[@class='title'])[2]")
    public WebElement usersButton;


    public void assertCount(int expectedCount, String str){
        WebElement element = Driver.getDriver().findElement(By.xpath("//h6[.='" + str + "']/../h2"));
        WaitUtils.waitText(element, "" + expectedCount);
        Assert.assertEquals("" + expectedCount,element.getText());
    }




}
