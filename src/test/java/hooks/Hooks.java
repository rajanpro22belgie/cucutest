package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.test.driver.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
