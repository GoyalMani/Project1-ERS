package Dao;

import model.Employee;
import model.Reimb;

import java.sql.SQLException;
import java.util.List;

public interface Managermethod {
    boolean login(String id, String pwd) throws SQLException;


    List<String[]> displayall() throws SQLException;

//    boolean getempbyid(String id) throws SQLException;
     Reimb getempbyid(String id) throws SQLException;

    List<String[]> allpending() throws SQLException;
    List<String[]>allresolved();

}
