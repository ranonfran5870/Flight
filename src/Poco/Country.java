package Poco;

public class Country implements IPoco {
    public int id;
    public String name;
    public String National_Flag;

    public Country() {
    }

    public Country(int id, String name, String national_Flag) {
        this.id = id;
        this.name = name;
        National_Flag = national_Flag;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", National_Flag='" + this.National_Flag + '\'' +
                '}';
    }
}
