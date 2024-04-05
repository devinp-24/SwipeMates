package delegates;

import model.userModel;

public interface UserLoginDelegate {
    void insertUser(userModel user);
    boolean checkUserId(String userIdInput);
}
