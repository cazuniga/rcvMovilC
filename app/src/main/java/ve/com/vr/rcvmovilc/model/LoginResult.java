package ve.com.vr.rcvmovilc.model;

public class LoginResult {

    private Boolean error;
    private String message;
    private String jwt;


    /**
     *
     * @return
     * The error
     */
    public Boolean getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(Boolean error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The Token
     */
    public String getJwt() {
        return jwt;
    }

    /**
     *
     * @param jwt
     * The Token
     */
    public void setJwt(String jwt) {
        this.jwt= jwt;
    }

}