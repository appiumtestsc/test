package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class MainScreenPage extends BasePage {

    @AndroidFindBy(id = "com.snapchat.android:id/hova_nav_feed_layout")
    private AndroidElement FriendsButton;

    @Step("Go to friends list")
    public void goToFriendsPage() {
        FriendsButton.click();
    }

}