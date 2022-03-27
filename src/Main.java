import DAO.AirlineCompaniesDAO;
import DAO.CustomerDAO;
import DAO.UserDAO;
import Facades.AdministratorFacade;
import Facades.AirlineFacade;
import Facades.AnonymousFacade;
import Facades.CustomerFacade;
import Poco.*;

import java.sql.Timestamp;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {

        var anonymousFacade = new AnonymousFacade();
        //----------------------------------------------------------------------
        //Admin
        var loginTest = anonymousFacade.login("Walt","kjukuj88");
        System.exit(0);
        //Customers
        //var loginTest = anonymousFacade.login("Ludwig","898kj99");
        //----------------------------------------------------------------------
        //Add-Ticket
        //----------------------------------------------------------------------
        //var ticket = new Ticket(0,14,0);
        //System.out.println(((CustomerFacade) loginTest).add_ticket(ticket));
        //----------------------------------------------------------------------

        //AdministratorFacade = Tests
        //Remove Airline
        AirlineCompaniesDAO airlineCompaniesDAO = new AirlineCompaniesDAO();
        //System.out.println(airlineCompaniesDAO.get_airline_by_username("Leonardo".toLowerCase()));
        AirlineCompanies airlineCompanies = new AirlineCompanies();
//        System.out.println(((AdministratorFacade) loginTest)
//                .adminRemoveAirline(airlineCompaniesDAO.get_airline_by_username("Leonardo".toLowerCase())));
        //Remove customers
//        var customerDAO = new CustomerDAO();
//        System.out.println(((AdministratorFacade) loginTest)
//                .adminRemoveAirline(customerDAO.get_customer_by_username("rachell".toLowerCase())));
//        System.out.println(((AdministratorFacade) loginTest)
//                .adminRemoveCustomer(customerDAO.get_customer_by_username("rachell".toLowerCase())));
        //Remove Airline
        //--------------------------------
//        var airlineCompaniesDAO = new AirlineCompaniesDAO();
//        System.out.println(((AdministratorFacade) loginTest)
//                .remove_airline(airlineCompaniesDAO
//                        .get_airline_by_username("Indira".toLowerCase())));
        //--------------------------------
        //Add Airline fixx here
//        var user = new User();
//        user.id=4;
//        user.user_role = 2;
//        var country = new Country();
//        country.id=1;
//        System.out.println(((AdministratorFacade) loginTest)
//                .add_airline(user,country,"TestFlight"));
        //----------------------------
        //add_customer (RoleSet)
//        var us1 = new User(1,"rachell","Amdk8888@","rachell@walla.com",2,"");
//        var cs2dasdsa = new Customer(1111,"rachellddsa","rashvi","dsad 89","0594848148","8888-8888",22);
//        System.out.println(((AdministratorFacade) loginTest)
//                .adminAddCustomer(us1,cs2dasdsa));
        //------------------------------------------------------


        System.exit(0);




//        FlightDAO dasdas = new FlightDAO();
//        System.out.println(dasdas.getById(1));
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//        var mdsa = new AnonymousFacade();
//        var dsfdsad = mdsa.login("R1osa","1111");


        //System.out.println(Pattern.matches(regexEmail, "tast@gmail.com"));


        var dsadsadsam = new AnonymousFacade();
        var dsdasdad = dsadsadsam.login("Rosa","1111");
        var tdsai = new Ticket(1,7,2);
        System.out.println(((CustomerFacade) dsdasdad).add_ticket(tdsai));
        System.exit(0);



        var mdsad = new AnonymousFacade();
        AirlineCompaniesDAO a1 = new AirlineCompaniesDAO();
        var dsadsadd = mdsad.login("Walt","kjukuj88");
        var us11111 = new User(4,null,null,null,2,null);
        var cu = new Country(1,null,null);
        System.out.println(((AdministratorFacade) dsadsadd).add_airline(us11111,cu,"AstaLavista"));

        System.exit(0);
        var ai = new AirlineCompanies(2,"sdasa",8,8);
        System.out.println(((AirlineFacade) dsadsadd).get_my_flight());
        System.exit(0);
        var Timestamp1 = java.sql.Timestamp.valueOf("2022-4-23 10:10:10");
        var Timestamp2 = java.sql.Timestamp.valueOf("2024-11-23 10:10:10");
        //var fl = new Flight(88,9,1,3,Timestamp1,Timestamp2,88);
        var fl = new Flight(9,9,2,3,Timestamp1,Timestamp2,88);


        System.out.println(((AirlineFacade) dsadsadd).remove_flight(fl));
        System.exit(0);
        //var fldsada = new Flight(8,9,1,3,Timestamp1,Timestamp2,88);

        var cs2 = new Customer(1111,"Rodsadssa8888","Parks","DSAA 89","+97254828559","444114-5555",22);

        System.exit(0);
        System.out.println(((CustomerFacade) dsadsadd).get_my_flight());
        var ti = new Ticket(1,7,2);
        System.out.println(((CustomerFacade) dsadsadd).add_ticket(ti));

        CustomerDAO dsdsadsa = new CustomerDAO();
        UserDAO dsadasddas = new UserDAO();

        //System.out.println(dsdsadsa.CrditPhone("+9729898591","98-2424-44-541"));
        //System.exit(0);
        var m = new AnonymousFacade();
        //var test = m.login("Rosa","1111");
//        var us1 = new User(1,"David8888114511","Amdk8888@","davi41151d@walla.com",8,"");
//        var cs2dasdsa = new Customer(1111,"davidDavid8888114511","halili","DSAA 89","665656615","44414-5555",22);
//        //dsdsadsa.Add(cs2);
        //var test = m.addCustomer(us1,cs2);
        System.exit(0);
        //System.out.println(((CustomerFacade) test).get_my_ticket());
        //System.out.println(((CustomerFacade) test).get_my_ticket());
        //AirlineCompanies c1 = new AirlineCompanies(7,"test2",2,4);
        //m.Remove(c1);
        //System.out.println(m.get_all_flights());
//        User c1 = new User(1,"Leonardo","dsAdsa1@","dsadas",2,"");
//        System.out.println(m.addCustomer(c1));
        var dsad = m.login("Rosa","1111");
        System.out.println("dsadsa");

        //dsad.up
        var mc = new Customer(1,"Dsad","Dsad","Dsad","Dsad","Dsad",88);

        //CustomerFacade xa = (CustomerFacade) dsad;
        System.out.println(((CustomerFacade) dsad).get_my_ticket());
        //System.out.println(((AdministratorFacade) dsad).update_customer(mc));
        //var ma = new CustomerFacade(dsad);
        //Date x = '2022-03-20 18:22:44';
        String regex = "^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$";
        //System.out.println(Pattern.matches(regex,"AaAa##1"));

    }
}
