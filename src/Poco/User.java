package Poco;

public class User implements IPoco {
    public long id;            ////////////////if have problem cheack
    public String username;
    public String password;
    public String email;
    public int user_role;
    public String thumbnail;

    public User() {
    }

    public User(int id, String username, String password, String email, int user_role, String thumbnail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.user_role = user_role;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", username='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                ", email='" + this.email + '\'' +
                ", user_role=" + this.user_role +
                ", thumbnail='" + this.thumbnail + '\'' +
                '}';
    }
}
