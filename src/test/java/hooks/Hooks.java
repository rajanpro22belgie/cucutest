package hooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.test.driver.DriverFactory;
import com.test.reporting.ReportManager;
import com.test.utils.ScreenshotUtils;
import io.cucumber.java.*;

public class Hooks {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest extentTest = ReportManager.getReporter().createTest(scenario.getName());
        test.set(extentTest);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshot = ScreenshotUtils.captureScreenshot();
            test.get().fail("Step failed").addScreenCaptureFromBase64String(screenshot);
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().log(Status.FAIL, "Scenario failed");
        } else {
            test.get().log(Status.PASS, "Scenario passed");
        }
        DriverFactory.quitDriver();
    }

    @AfterAll
    public static void afterAll() {
        ReportManager.getReporter().flush();
    }
}
