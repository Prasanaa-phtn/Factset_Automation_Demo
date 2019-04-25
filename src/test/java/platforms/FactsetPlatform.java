package platforms;

import java.io.File;

public interface FactsetPlatform {

    void launch() throws Exception;

    void logOut() throws Exception;;

    File takeScreenshot() throws Exception;;

    void navigateToLogin() throws Exception;;

    void login() throws Exception;;

    void validateLogIn() throws Exception;;

    void validateLogOut() throws Exception;;
    
    void enterEmailAndPassword(String email, String password) throws Exception;;
    
    void validateUnsuccessfulLogin(String error) throws Exception;;

}