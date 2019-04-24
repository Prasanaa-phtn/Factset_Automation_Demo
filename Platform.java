import java.io.File;

import exceptions.HigiException;

public interface Platform {

    void launch();

    void logOut();

    File takeScreenshot();

    void navigateToLogin();

    void login(String username, String password);

    void validateLogIn();

    void validateLogOut();

}
