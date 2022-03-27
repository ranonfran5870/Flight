package Poco;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Flight implements IPoco {

    public long id;
    public long airline_company_id;
    public int origin_country_id;
    public int destination_country_id;
    public Timestamp departure_time;
    public Timestamp landing_time;
    public int remaining_tickets;

    public Flight() {
    }

    public Flight(long id, long airline_company_id, int origin_country_id, int destination_country_id, Timestamp departure_time, Timestamp landing_time, int remaining_tickets) {
        this.id = id;
        this.airline_company_id = airline_company_id;
        this.origin_country_id = origin_country_id;
        this.destination_country_id = destination_country_id;
        this.departure_time = departure_time;
        this.landing_time = landing_time;
        this.remaining_tickets = remaining_tickets;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + this.id +
                ", airline_company_id=" + this.airline_company_id +
                ", origin_country_id=" + this.origin_country_id +
                ", destination_country_id=" + this.destination_country_id +
                ", departure_time=" + this.departure_time +
                ", landing_time=" + this.landing_time +
                ", remaining_tickets=" + this.remaining_tickets +
                '}';
    }

}
