package com.epam.dev_ecommerce.cucumber_tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/com/epam/dev_ecommerce/features",tags= "@checkOutWithMoreThanOne")
public class TestRunner extends AbstractTestNGCucumberTests{
		
		
}
