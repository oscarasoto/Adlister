package models;

import java.io.Serializable;

/**
 * @author oscarsoto on 12/15/16.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public class User implements Serializable{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
