package Facades;
import DAO.*;
import Login.Permissions;
import Poco.AirlineCompanies;
import Poco.Country;
import Poco.Flight;
import Poco.User;

import java.util.List;

public abstract class FacadeBase {
    private final FlightDAO flight = new FlightDAO();
    private final AirlineCompaniesDAO airlineCompanies = new AirlineCompaniesDAO();
    private final CountryDAO countryDAO = new CountryDAO();
    private final UserDAO userDAO = new UserDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    //-> Flight

    public List<Flight> get_all_flights(){
        return this.flight.getAll();
    }

    public Flight get_flight_by_id(long _id){
        return this.flight.getById(_id);
    }

    public Flight get_flights_by_parameters(int _origin_country_id,int _destination_country_id,String _date){
        return this.flight.get_flights_by_parameters(_origin_country_id,_destination_country_id,_date);
    }

    //-> AirlineCompanies
    public List<AirlineCompanies> get_all_airlines(){
        return this.airlineCompanies.getAll();
    }

    public AirlineCompanies get_airlines_by_id(long _id){
        return this.airlineCompanies.getById(_id);
    }

    //-> Country
    public List<Country> get_all_countries(){
        return this.countryDAO.getAll();
    }

    public Country get_country_by_id(int _id){
        return this.countryDAO.getById(_id);
    }


    protected boolean createNewUser(User user){
        user.user_role = 1;
        if (user.thumbnail == null || user.thumbnail.trim().isEmpty())
            user.thumbnail = "https://cdn.pixabay.com/photo/2020/07/01/12/58/icon-5359553_1280.png";
        System.out.println(user);
        userDAO.Add(user);
        return true;
    }

    /*
    Auto roll default = customer,
    Auto thumbnail if Null/Empty,
    UserDAO Try create new User
     */

    protected boolean facadesPermissions(Permissions permissions,String facade){
        switch (facade){
            case "class Facades.CustomerFacade" -> {
                if (permissions == Permissions.Customer)
                    return true;
            }
            case "class Facades.AdministratorFacade" -> {
                if (permissions == Permissions.Admin)
                return true;
            }
            case "class Facades.AirlineFacade" -> {
                if (permissions == Permissions.Airline)
                    return true;
            }
        }
        return false;
    }
    /*
    The function checks permissions user to current facade
     */
}
