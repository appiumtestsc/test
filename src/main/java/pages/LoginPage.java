package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'login_button')]")
    private AndroidElement loginButton;
    @AndroidFindBy(id = "com.snapchat.android:id/username_or_email_field")
    private AndroidElement userField;
    @AndroidFindBy(id = "com.snapchat.android:id/password_field")
    private AndroidElement passField;
    @AndroidFindBy(id = "com.snapchat.android:id/button_text")
    private AndroidElement submitButton;

    @Step("Enter login")
    public LoginPage setUserValue(final String value) {
        userField.sendKeys(value);
        return this;
    }

    @Step("Enter password")
    public LoginPage setPasswordValue(final String value) {
        passField.sendKeys(value);
        return this;
    }

    @Step("Click on button SingIn")
    public void clickOnSignIn() {
        loginButton.click();
    }

    @Step("Click on button Submit")
    public void clickOnSubmit() {
        submitButton.click();
    }

    @Step("User authorization - {user}")
    public void logIn(final String user, final String pass) {
        clickOnSignIn();
        setUserValue(user);
        setPasswordValue(pass);
        clickOnSubmit();
        waitingForElementUnVisible(userField);

    }

}

