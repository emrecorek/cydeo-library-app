package com.cydeo.library.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cydeo.utilities.Driver;

public class Hooks {

    @After
    public void tearDownScenario(Scenario scenario) {

        if (scenario.isFailed()){
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenShot, "image/png", scenario.getName());
        }
         Driver.closeDriver();
    }




}
