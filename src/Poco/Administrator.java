package Poco;

public class Administrator implements IPoco {
    public int id;
    public String first_name;
    public String last_name;
    public long user_id;

    public Administrator(){};
    public Administrator(int id, String first_name, String last_name, long user_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + this.id +
                ", first_name='" + this.first_name + '\'' +
                ", last_name='" + this.last_name + '\'' +
                ", user_id=" + this.user_id +
                '}';
    }
}
