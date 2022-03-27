package Facades;
import DAO.AirlineCompaniesDAO;
import DAO.FlightDAO;
import DAO.TicketDAO;
import Login.LoginToken;
import Poco.AirlineCompanies;
import Poco.Flight;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirlineFacade extends AnonymousFacade{
    private LoginToken loginToken;
    private List<AirlineCompanies> airlineList = new ArrayList<>();
    private final AirlineCompaniesDAO a1 = new AirlineCompaniesDAO();
    private final FlightDAO f1 = new FlightDAO();
    private final TicketDAO ticketDAO = new TicketDAO();
    private List<Flight> FlightList = new ArrayList<>();


    public AirlineFacade(LoginToken loginToken) {
        this.loginToken = loginToken;
        System.out.println("Permissions -> " + loginToken.getRole() + "\n Welcome Back : " + loginToken.getName());
    }

    public boolean update_airline (AirlineCompanies airlineCompanies){
        if (isValidToken(this.loginToken)) {
            var countryListT = get_all_countries().stream()
                    .map(test -> test.id)
                    .toList();
            if (countryListT.contains(airlineCompanies.country_id)) {
                airlineCompanies.user_id = loginToken.getId();
                airlineCompanies.id = a1.get_airline_by_username(loginToken.getName().toLowerCase()).id;
                a1.Update(airlineCompanies);
                return true;
            } else
                System.out.println("Not possible Country  id");
        }

        return false;
    }

    public boolean add_flight (Flight flight){
        if (isValidToken(this.loginToken)) {
            if (!confirmedFlight(flight)) {
                System.out.println("This flight is illegal");
                return false;
            }
            flight.airline_company_id = a1.get_airline_by_username(loginToken.getName().toLowerCase()).id;
            f1.Add(flight);
            return true;
        }
        return false;
    }
    /*
    this function
    Checks that all information is correct and logical use (confirmedFlight()) and add new flight
     */

    public boolean remove_flight (Flight flight){
        if (isValidToken(this.loginToken)) {

            if (get_flight_by_id(flight.id).airline_company_id == a1.get_airline_by_username(loginToken.getName().toLowerCase()).id) {
                ticketDAO.RemoveTicketsByFlightId(flight.id);
                f1.Remove(flight);
                return true;
            }
            System.out.println("You can only update your available flights");
            return false;
        }return false;
    }

    public List<Flight> get_my_flight(){
        if (isValidToken(this.loginToken)) {
            System.out.println(this.loginToken.getId());
            return f1.get_flights_by_airline_id(a1.get_airline_by_username(loginToken.getName().toLowerCase()).id);
        }
        System.out.println("Access Denied");
        return FlightList;
    }


    public boolean update_flight (Flight flight){
        if (isValidToken(this.loginToken)) {
            if (get_flight_by_id(flight.id).airline_company_id == a1.get_airline_by_username(loginToken.getName().toLowerCase()).id) {
                if (!confirmedFlight(flight)) {
                    System.out.println("This flight is illegal");
                    return false;
                }
                flight.airline_company_id = a1.get_airline_by_username(loginToken.getName().toLowerCase()).id;
                f1.Update(flight);
                return true;
            }
            System.out.println("You can only update your available flights");
            return false;
        }
        return false;
    }
    /*
    this function get 'flight'
    Checks that all information is correct and logical use (confirmedFlight()) and update
     */

    private boolean confirmedFlight(Flight flight){
        var countryListT = get_all_countries().stream()
                .map(test -> test.id)
                .distinct()
                .toList();
        Date date = new Date();
        String sDeparture_time = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(flight.departure_time);
        String sLanding_time = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(flight.landing_time);
        int stempVsNoww = sDeparture_time.compareTo(String.valueOf(new Timestamp(date.getTime())));
        int timestempCheack = sDeparture_time.compareTo(sLanding_time);
        return timestempCheack != 0 && timestempCheack <= 0 && flight.origin_country_id != flight.destination_country_id && flight.remaining_tickets > 0 && countryListT.contains(flight.origin_country_id) && countryListT.contains(flight.destination_country_id) && stempVsNoww >= 0;
    }
    //This function get flight and Checks that all information is correct and logical
}
