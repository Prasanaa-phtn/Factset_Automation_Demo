package platforms;

import java.io.File;

public interface FactsetPlatform {

    void launch();

    void logOut();

    File takeScreenshot();

    void navigateToLogin();

    void login(String username, String password);

    void validateLogIn();

    void validateLogOut();
    
    void enterEmailAndPassword(String email, String password);
    
    void validateUnsuccessfulLogin(String error);

}