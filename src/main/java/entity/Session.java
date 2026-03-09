package entity;

public class Session {
    private User currentUser;

    public Session(){
        this.currentUser = null;
    }

    public User getCurrentUser() { return currentUser; }
    public void setCurrentUser(User user) { this.currentUser = user; }
    public boolean isAuthenticated() { return currentUser != null; }
}