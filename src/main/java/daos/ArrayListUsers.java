package daos;



import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oscarsoto on 12/15/16.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public class ArrayListUsers implements Users{
    private List<User> users;

    public ArrayListUsers() {
        users = new ArrayList<>();

        User user = new User();
        user.setUsername("admin");
        user.setPassword("password");

        users.add(user);
    }

    @Override
    public User withUsername(String username) {
        for (User user: users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }
}
