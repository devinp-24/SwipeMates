package controller;

import database.DatabaseConnectionHandler;
import delegates.LoginWindowDelegate;
import delegates.UserLoginDelegate;
import model.listerModel;
import model.seekerModel;
import model.userModel;
import ui.LoginWindow;
import ui.UserLogin;

import java.util.List;

public class Main implements LoginWindowDelegate, UserLoginDelegate {
    private DatabaseConnectionHandler dbHandler = null;
    private LoginWindow loginWindow = null;
    private UserLogin userLogin = null;



    public static void main(String[] args) {
        Main mainController = new Main();
        mainController.start();
    }

    private void start() {
        loginWindow = new LoginWindow();
        loginWindow.showFrame(this);
        dbHandler = new DatabaseConnectionHandler();
        userLogin = new UserLogin();
    }

    @Override
    public void login(String username, String password) {
        boolean didConnect = dbHandler.login(username, password);

        if (didConnect) {
            // Once connected, remove login window and start text transaction flow
            loginWindow.dispose();
            userLogin.showFrame(this);


        } else {
            loginWindow.handleLoginFailed();

            if (loginWindow.hasReachedMaxLoginAttempts()) {
                loginWindow.dispose();
                System.out.println("You have exceeded your number of allowed attempts");
                System.exit(-1);
            }
        }
    }

    @Override
    public void insertUser(userModel user) {
        dbHandler.insertUser(user);
    }

    @Override
    public boolean checkUserId(String userIdInput) {
        return dbHandler.checkUserId(userIdInput);
    }

    @Override
    public List<String> getResIdsName() {
        return dbHandler.getResIdsName();
    }

    @Override
    public void insertLister(listerModel lister) {
        dbHandler.insertLister(lister);
    }

    @Override
    public void insertSeeker(seekerModel seeker) {
        dbHandler.insertSeeker(seeker);
    }


}
