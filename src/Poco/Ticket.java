package Poco;

public class Ticket implements IPoco{

    public long id;
    public long flight_id;
    public long customer_id;

    public Ticket() {
    }

    public Ticket(long id, long flight_id, long customer_id) {
        this.id = id;
        this.flight_id = flight_id;
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + this.id +
                ", flight_id=" + this.flight_id +
                ", customer_id=" + this.customer_id +
                '}';
    }
}
