package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FirstPage;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Lab2Tests.class);
        System.out.println("#######################################################################");
        System.out.println("Antal tester körda: " + result.getRunCount());
        System.out.println("Tid för att köra testerna: " + result.getRunTime()/1000 + " sekunder.");
        System.out.println("Antal fel: "+ result.getFailureCount());
        result.getFailures().forEach( e -> System.out.println(e.getMessage()));
        System.out.println("#######################################################################");

     }
}

