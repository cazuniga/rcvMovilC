package ve.com.vr.rcvmovilc.model;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    public String email;
    public String password;

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "email:" + this.email +  ",password:" + this.password;
    }
}