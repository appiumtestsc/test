package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverManager.getDriver;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public static final int TIME_OUT_IN_SECONDS = 20;

    @Step("Wait for element is visible")
    public boolean waitingForElementVisible(final MobileElement field) {
        try {
            (new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)).until(ExpectedConditions.visibilityOf(field));
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Step("Wait for element is invisible")
    public boolean waitingForElementUnVisible(final MobileElement field) {
        try {
            (new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)).until(ExpectedConditions.invisibilityOf(field));
        } catch (Exception e) {
        }
        return false;
    }

    @Step("Close app")
    public static void close() {
        getDriver().closeApp();
        getDriver().close();
    }
}
