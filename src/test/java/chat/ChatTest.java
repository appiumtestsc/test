package chat;

import entity.Data;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.ChatPage;
import pages.FriendsListPage;
import pages.LoginPage;
import pages.MainScreenPage;
import pages.PermissionsPage;
import utils.PropertyLoader;
import utils.RandomData;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("Chat")
public class ChatTest {

    private static final String USER = PropertyLoader.loadUser().getLogin();
    private static final String PASS = PropertyLoader.loadUser().getPassword();
    private static final String TARGET_USER = "sol_marl";

    private FriendsListPage friends = new FriendsListPage();
    private ChatPage chat = new ChatPage();
    private LoginPage loginPage = new LoginPage();
    private PermissionsPage permissionsPage = new PermissionsPage();
    private MainScreenPage mainScreenPage = new MainScreenPage();

    @Test
    @Feature("Send Message")
    public void scTest() {

        loginPage.logIn(USER, PASS);
        permissionsPage.allowAll();
        mainScreenPage.goToFriendsPage();

        friends.createNewChat();
        friends.selectUser(TARGET_USER);
        assertEquals(TARGET_USER, chat.getFriendName(), "Check friend");

        String msg = getMessageText();
        chat.sendText(msg);
        assertEquals(msg, chat.getSentText(), "Check sent text");

    }

    private String getMessageText() {
        Data randomData = RandomData.getRandomData();
        return randomData.getEmail() + randomData.getTimeZoneOffset() + randomData.getTimeZoneDescr();
    }

    @AfterEach
    public void afterTest() {
        BasePage.close();
    }
}