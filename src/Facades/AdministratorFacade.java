package Facades;
import DAO.*;
import Login.LoginToken;
import Poco.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorFacade extends AnonymousFacade{

    private LoginToken loginToken;
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final AirlineCompaniesDAO a1 = new AirlineCompaniesDAO();
    private final FlightDAO flightDAO = new FlightDAO();
    private final TicketDAO ticketDAO = new TicketDAO();
    private final UserDAO userDAO = new UserDAO();
    private List<Customer> CustomerList = new ArrayList<>();

    public AdministratorFacade(LoginToken loginToken) {
        this.loginToken = loginToken;
        System.out.println("Permissions -> " + loginToken.getRole() + "\n Welcome Back : " + loginToken.getName());
    }
    //Checking if Token isValid

    public List<Customer> get_all_customer(){
        if (isValidToken(this.loginToken)) {
            return customerDAO.getAll();
        }
        return CustomerList;
    }
    //Get all customers from Sql if token isVaild

    public boolean  add_airline(User user, Country country,String name){
        if (isValidToken(this.loginToken)) {
            AirlineCompanies ar = new AirlineCompanies();
            ar.user_id = user.id;
            ar.country_id = country.id;
            ar.name = name;
            a1.Add(ar);
            return true;
        }
        return false;
    }
    //Change user to Airline Role new airline

    public boolean  remove_airline(AirlineCompanies airlineCompanies){
        if (isValidToken(this.loginToken)) {
            var flightListT = flightDAO.get_flights_by_airline_id(airlineCompanies.user_id).stream()
                    .map(test -> test.id)
                    .toList();
            var fRemove = new Flight();
            for (long num : flightListT) {
                fRemove.id = num;
                ticketDAO.RemoveTicketsByFlightId(num);
                flightDAO.Remove(fRemove);
            }
            a1.Remove(airlineCompanies);

            return true;
        }
        return false;
    }


    /*Remove airline
    Get airline flights
    remove all the ticket+flight airline
     */

    public boolean  adminAddCustomer(User user,Customer customer){
        if (isValidToken(this.loginToken)) {
            addCustomer(user, customer);
            UserDAO userDAO = new UserDAO();
            User newUser = userDAO.get_user_by_username(user.username);
            if (newUser != null) {
                if (customerDAO.get_customer_by_username(newUser.username) != null) {
                    System.out.println("Congratulations, you have successfully registered!");
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    //Use AnonymousFacade(addCustomer(user, customer)) Add new user Role=Customer

    public boolean  adminAddAmin(User user,Customer customer){
        if (isValidToken(this.loginToken)) {
            addCustomer(user, customer);
            UserDAO userDAO = new UserDAO();
            User newUser = userDAO.get_user_by_username(user.username);
            if (newUser != null) {
                if (customerDAO.get_customer_by_username(newUser.username) != null) {
                    userDAO.addRoleUser(user.username, 3);
                    System.out.println("Congratulations, you have successfully registered!");
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    //Use AnonymousFacade(addCustomer(user, customer)) Add new user Role=Admin

    public boolean  adminRemoveCustomer(Customer customer) {
        if (isValidToken(this.loginToken)) {
            var ticketRemove = new Ticket();
            ticketRemove.customer_id = customer.id;
            ticketDAO.Remove(ticketRemove);
            customerDAO.Remove(customer);
            var userRemove = new User();
            userRemove.id = customer.userId;
            userDAO.Remove(userRemove);
            return true;
        }
        return false;
    }

    //Remove Customer+tickets + User id Done
}
