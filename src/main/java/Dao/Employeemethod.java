package Dao;

import model.Employee;
import model.Reimb;

import java.sql.SQLException;
import java.util.List;

public interface Employeemethod {
     boolean login(String id, String pwd) throws SQLException;
     boolean update(Employee employee) throws SQLException;
    // boolean update() throws SQLException;
     List<String[]> allpending(String id) throws SQLException;
     boolean submit(Reimb rem ) throws SQLException;
     List<String[]>allresolved(String id);
     List<String[]>viewinfo(String id);

}
