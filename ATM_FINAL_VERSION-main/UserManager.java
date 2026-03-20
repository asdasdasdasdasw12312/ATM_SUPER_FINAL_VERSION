import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}