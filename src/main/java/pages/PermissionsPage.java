package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import java.util.List;
import java.util.NoSuchElementException;

public class PermissionsPage extends BasePage {

    @AndroidFindBy(id = "com.snapchat.android:id/turn_on_button")
    private AndroidElement overlay;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private List<AndroidElement> allowButton;
    @AndroidFindBy(id = "com.android.packageinstaller:id/current_page_text")
    private AndroidElement count;

    public PermissionsPage allowClick() {
        try {
            allowButton.get(0).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }

    public int getPermissionsCount() {
        return Integer.valueOf(count.getText().replaceAll(".* ", ""));
    }

    public boolean overlayIsDisplayed() {
        return waitingForElementVisible(overlay);
    }

    public boolean allowButtonIsDisplayed() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allowButton.size() > 0;
    }

    public PermissionsPage overlayClick() {
        overlay.click();
        return this;
    }

    @Step("Allow all permissions")
    public void allowAll() {
        if (overlayIsDisplayed()) {
            overlayClick();
            for (int i = 0; i < 10; i++) {
                allowClick();
                if (!allowButtonIsDisplayed()) {
                    return;
                }
            }
        }
    }

}

