package Poco;

public class AirlineCompanies implements IPoco {
    public long id;
    public String name;
    public int country_id;
    public long user_id;

    public AirlineCompanies() {
    }

    public AirlineCompanies(long id, String name, int country, long user_id) {
        this.id = id;
        this.name = name;
        this.country_id = country;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "AirlineCompanies{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", country=" + this.country_id +
                ", user_id=" + this.user_id +
                '}';
    }
}
