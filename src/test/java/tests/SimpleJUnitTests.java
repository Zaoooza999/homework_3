package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SimpleJUnitTests {

    @Test
    void parametrisedTest() {
    String environment = System.getProperty("environment","prod");
        System.out.println("Test environment is: " + environment);
    }

@Test
    void parametrisedTest1() {
        String name = System.getProperty("name");
        System.out.println("name is: " + name);
    }

    @Test
    @Tag("test1")
    void propertyBrowserTest() {
        String browser = System.getProperty("browser","chrome");
        System.out.println("Browser is: " + browser);
    }

}
