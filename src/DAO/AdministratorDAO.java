package DAO;

import Poco.Administrator;
import Poco.Country;
import SqlConnection.SqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDAO implements IDAO<Administrator,Integer>{

    List<Administrator> AdministratorList = new ArrayList<>();
    SqlConnection sqlConnection = new SqlConnection();
    Connection connection = sqlConnection.getConnection();
    Statement stm = sqlConnection.getStatement();
    //----getAll
    @Override
    public List<Administrator> getAll() {
        String query = "SELECT * FROM Administrators";
        try {
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                AdministratorList.add(new Administrator
                        (result.getInt("id"),
                                result.getString("first_name")
                                , result.getString("last_name")
                                , result.getLong("user_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AdministratorList;
    }

    //----getById
    @Override
    public Administrator getById(Integer _id) {
        String query = "SELECT * FROM Administrators WHERE id=";
        Administrator administrator=null;
        try {
            var result = stm.executeQuery
                    (query + _id);
            result.next();
            administrator=new Administrator(result.getInt("id")
                    ,result.getString("first_name")
                    ,result.getString("last_name")
                    , result.getLong("user_id"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrator;
    }

    @Override
    public void Add(Administrator administrator) {

        try {
            stm.executeUpdate("INSERT INTO Administrators (\"First_Name\",\"Last_Name\",\"User_id\") " +
                    "VALUES " +
                    "('"+administrator.first_name+"','"+administrator.last_name+"','"+administrator.user_id+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Remove(Administrator administrator) {

        try {
            stm.executeUpdate("DELETE from Administrators WHERE id = "+administrator.id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Administrator administrator) {

        try {
            stm.executeUpdate("UPDATE Administrators SET " +
                    "\"First_Name\"= '"+administrator.first_name+"', " +
                    "\"Last_Name\"='"+ administrator.last_name+"', " +
                    "\"User_id\"='"+ administrator.user_id+
                    "' where id="+administrator.id+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
