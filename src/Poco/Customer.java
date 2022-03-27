package Poco;

public class Customer implements IPoco {
    public long id;
    public String first_name;
    public String last_name;
    public String address;
    public String phone_no;
    public String credit_card_no;
    public long userId;

    public Customer() {
    }

    public Customer(long id, String first_name, String last_name, String address, String phone_no, String credit_card_no, long userId) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone_no = phone_no;
        this.credit_card_no = credit_card_no;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + this.id +
                ", first_name='" + this.first_name + '\'' +
                ", last_name='" + this.last_name + '\'' +
                ", address='" + this.address + '\'' +
                ", phone_no='" + this.phone_no + '\'' +
                ", credit_card_no='" + this.credit_card_no + '\'' +
                ", userId=" + this.userId +
                '}';
    }
}
