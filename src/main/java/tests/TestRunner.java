package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FirstPage;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Lab2Tests.class);
        System.out.println("Antal tester körda: " + result.getRunCount());
        System.out.println("Antal fel: "+ result.getFailureCount());
        result.getFailures().forEach( e -> System.out.println(e.getMessage()));
     }
}

/**
 * User stories
 * 1. Make a purchase
 * 2. Create an account
 * 3. Add and delete from shopping basket
 * 4. Search for "hum", clear search
 * 5. Contact customer service
 */
