package platforms;
public interface FactsetPlatform {

    void launch();

    void logOut();

    File takeScreenshot();

    void navigateToLogin();

    void login(String username, String password);

    void validateLogIn();

    void validateLogOut();

}