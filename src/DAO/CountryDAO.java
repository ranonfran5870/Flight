package DAO;
import Poco.Country;
import SqlConnection.SqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements IDAO<Country,Integer>{
    List<Country> CountryList = new ArrayList<>();
    SqlConnection sqlConnection = new SqlConnection();
    Connection connection = sqlConnection.getConnection();
    Statement stm = sqlConnection.getStatement();

    //----getAll
    @Override
    public List<Country> getAll() {
        String query = "SELECT * FROM Countries";
        try {
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                CountryList.add(new Country
                        (result.getInt("id"),
                                result.getString("name")
                                , result.getString("national_Flag")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CountryList;
    }

    //----getById
    @Override
    public Country getById(Integer _id) {
        String query = "SELECT * FROM Countries WHERE id=";
        Country country=null;
        try {
            var result = stm.executeQuery
                    (query + _id);
            result.next();
            country=new Country(result.getInt("id")
                    ,result.getString("name")
                    ,result.getString("national_Flag"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    //----Add
    @Override
    public void Add(Country country) {
        try {
            stm.executeUpdate("INSERT INTO Countries (\"Name\",\"National_Flag\") " +
                    "VALUES " +
                    "('"+country.name+"','"+country.National_Flag+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //----Remove
    @Override
    public void Remove(Country country) {

        try {
            stm.executeUpdate("DELETE from Countries WHERE id = "+country.id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    //----Update
    @Override
    public void Update(Country country) {
        try {
            stm.executeUpdate("UPDATE Countries SET " +
                    "\"Name\"= '"+country.name+"', " +
                    "\"National_Flag\"='"+ country.National_Flag+
                    "' where id="+country.id+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //----getAirlinesByCountry
    public List<Country> getAirlinesByCountry() {
        String query = "SELECT * FROM Countries";
        try {
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                CountryList.add(new Country
                        (result.getInt("id"),
                                result.getString("name")
                                , result.getString("national_Flag")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CountryList;
    }


}
