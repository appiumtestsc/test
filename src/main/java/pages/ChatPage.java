package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static utils.DriverManager.getDriver;

public class ChatPage extends BasePage {

    @AndroidFindBy(id = "com.snapchat.android:id/chat_input_text_field")
    private AndroidElement chatInput;
    @AndroidFindBy(id = "com.snapchat.android:id/chat_message_user_text")
    private List<AndroidElement> messagesList;
    @AndroidFindBy(id = "com.snapchat.android:id/chat_friends_name")
    private AndroidElement friendsName;

    @Step("Send text on ChatInput field and press Enter")
    public void sendText(final String text) {
        chatInput.sendKeys(text);
        getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Step("Get last message text")
    public String getSentText() {

        if (messagesList.size() != 0) {
            return messagesList.get(messagesList.size() - 1).getText();
        } else {
            throw new NoSuchElementException("Message not found");
        }
    }

    @Step("Get selected friend")
    public String getFriendName() {
        return friendsName.getText();
    }
}

