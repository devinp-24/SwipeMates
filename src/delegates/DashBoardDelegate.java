package delegates;

public interface DashBoardDelegate {
    void deleteUser(String userID);
    void updateSocialPageHas(String userID, String newEmailID, String newPhoneNumber, String newInstagramUsername);

}
