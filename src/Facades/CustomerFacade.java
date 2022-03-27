package Facades;
import DAO.CustomerDAO;
import DAO.FlightDAO;
import DAO.TicketDAO;
import Login.LoginToken;
import Poco.Customer;
import Poco.Flight;
import Poco.Ticket;
import java.util.ArrayList;
import java.util.List;

public class CustomerFacade extends AnonymousFacade{


    private LoginToken loginToken;
    private List<Flight> FlightList = new ArrayList<>();
    private List<Ticket> TicketList = new ArrayList<>();
    private final TicketDAO ticketDAO = new TicketDAO();
    private final FlightDAO f1 = new FlightDAO();
    private final CustomerDAO cu = new CustomerDAO();

    public CustomerFacade(LoginToken loginToken) {
        this.loginToken = loginToken;
        System.out.println("Permissions -> " + loginToken.getRole() + "\n Welcome Back : " + loginToken.getName());
    }


    public boolean  update_customer(Customer customer){
        customer.id = cu.getById(loginToken.getId()).id;
        customer.userId = loginToken.getId();
        if (!ConfirmedCustomer(customer)){
            System.out.println("Customer : more of the details is invalid");
            return false;}

        if (!cu.get_customer_by_username(loginToken.getName()).credit_card_no.equals(customer.credit_card_no) || !cu.get_customer_by_username(loginToken.getName()).phone_no.equals(customer.phone_no))
            if (!cu.CrditPhone(customer.phone_no, customer.credit_card_no)) {
                System.out.println("Credit Card/Phone Nomber already exists");
                return false;
            }
        if (isValidToken(this.loginToken)) {
                cu.Update(customer);
                return true;
        }
        return false;
    }
    /*
    Step1 = Allows customer update only his own details
    Step2 = Confirmation Customer valid -> true/false
    Step3 = check if Card/Phone already exists in MyDB
    Step4 = Update
     */


    public List<Ticket> get_my_ticket(){
        if (isValidToken(this.loginToken)) {
            return ticketDAO.get_tickets_by_customer(loginToken.getId());
        }
        System.out.println("Access Denied");
        return TicketList;
    }


    public boolean remove_ticket(Ticket ticket){
        if (isValidToken(this.loginToken)) {
            if (!ticketDAO.get_tickets_by_customer(loginToken.getId()).isEmpty()) {
                if (ticket.customer_id == loginToken.getId()) {
                    ticketDAO.RemoveTickesCustomer(ticket);
                    f1.flightCounterTickes(ticket.flight_id, "+1");
                    return true;
                }
            }
        }
        System.out.println("Access Denied");
        return false;
    }
    /*
    Step1 = Cheack if list have tickets in the list
    Step2 = Cheack if the customer ticket equals to the login token
    Step3 = Remove ticket by ticket_id
    Step4 = Flight count temp -1
     */

    public boolean add_ticket(Ticket ticket){
        if (isValidToken(this.loginToken)) {
            var tickListT = ticketDAO.get_tickets_by_customer(loginToken.getId()).stream()
                    .map(test -> test.flight_id)
                    .toList();
            var flightListT = get_all_flights().stream()
                    .map(test -> test.id)
                    .toList();
            if (!tickListT.contains(ticket.flight_id)) {
                System.out.println("here");
                if (flightListT.contains(ticket.flight_id) && get_flight_by_id(ticket.flight_id).remaining_tickets > 0) {
                    ticket.customer_id = cu.get_customer_by_username(loginToken.getName().toLowerCase()).id;
                    ticketDAO.Add(ticket);
                    f1.flightCounterTickes(ticket.flight_id, "-1");
                    return true;

                }
            }
        }
        return false;
    }
    /*
    Step1 = Checks if already has a flight ticket -> break
    Step1 = Checking if there flight -> break
    Step2 = Checking remaining_tickets -> break
    Step3 = add ticket
    Step4 = dsafdsd
     */


    public List<Flight> get_my_flight(){
        if (isValidToken(this.loginToken)) {
            return f1.getFlightsByCustomer(loginToken.getId());
        }
        System.out.println("Access Denied");
        return FlightList;
    }
    //return all customer flight

}
