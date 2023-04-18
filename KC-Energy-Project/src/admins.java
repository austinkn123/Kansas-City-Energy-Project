public class admins {
    private int adminID;
    private String UserName;
    private String Password;

    public admins(int adminID, String UserName, String Password) {
        this.adminID = adminID;
        this.UserName = UserName;
        this.Password = Password;
    }

    private void setAdminID(int adminID) { this.adminID = adminID; }
    public int getAdminID() { return adminID; }

    private void setUserName(String UserName) { this.UserName = UserName; }
    public String getUserName() { return UserName; }

    private void setPassword(String Password) { this.Password = Password; }
    public String getPassword() { return Password; }

}
