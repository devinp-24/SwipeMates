package controller;

import database.DatabaseConnectionHandler;
import delegates.LoginWindowDelegate;
import ui.LoginWindow;

public class Main implements LoginWindowDelegate {
    private DatabaseConnectionHandler dbHandler = null;
    private LoginWindow loginWindow = null;



    public static void main(String[] args) {
        Main mainController = new Main();
        mainController.start();
    }

    private void start() {
        loginWindow = new LoginWindow();
        loginWindow.showFrame(this);
        dbHandler = new DatabaseConnectionHandler();
    }

    @Override
    public void login(String username, String password) {
        boolean didConnect = dbHandler.login(username, password);

        if (didConnect) {
            // Once connected, remove login window and start text transaction flow
            loginWindow.dispose();

        } else {
            loginWindow.handleLoginFailed();

            if (loginWindow.hasReachedMaxLoginAttempts()) {
                loginWindow.dispose();
                System.out.println("You have exceeded your number of allowed attempts");
                System.exit(-1);
            }
        }
    }
}
