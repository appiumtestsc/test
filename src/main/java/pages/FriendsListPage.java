package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static utils.DriverManager.getDriver;

public class FriendsListPage extends BasePage {

    @AndroidFindBy(id = "com.snapchat.android:id/neon_header_new_chat_button")
    private AndroidElement NewChatButton;

    @Step
    public void createNewChat() {
        NewChatButton.click();
    }

    @Step("Select user {user}")
    public void selectUser(final String user) {
        String xpath = ".//android.widget.TextView[@text='" + user + "']";
        getDriver().findElement(By.xpath(xpath)).click();
    }
}

