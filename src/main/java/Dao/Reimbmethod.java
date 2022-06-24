package Dao;


import java.sql.SQLException;

public interface Reimbmethod {
//    boolean approverequest() throws SQLException;
boolean approverequest(String man_id,int id) throws SQLException;
    boolean denyrequest(String man_id,int id) throws SQLException;
}
