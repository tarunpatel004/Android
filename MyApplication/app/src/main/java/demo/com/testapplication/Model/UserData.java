package demo.com.testapplication.Model;

/**
 * Created by nikhil on 17/11/16.
 */

public class UserData {
    private String user_id;
    private String user_activity;
    private String created_at;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUser_activity() {
        return user_activity;
    }

    public void setUser_activity(String user_activity) {
        this.user_activity = user_activity;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
