package Dao.impl;

import Dao.Employeemethod;
import model.Employee;
import model.Reimb;
import util.Connectionfac;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employeemethodimpl implements Employeemethod {
    Connection con;

    public Employeemethodimpl() {
        this.con = Connectionfac.getConnection();
    }

    //running for employee
    @Override
    public boolean login(String id, String pwd) throws SQLException {
        Employee employee = new Employee();
        String sql = "(select emp_id,emp_pwd from employee where emp_id='" + id + "' and emp_pwd='" + pwd + "')";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            System.out.println("Login successfully");
            return true;
        } else {
            System.out.println("Login failed");
            return false;
        }

    }

    //error
    @Override
    public boolean update(Employee employee) throws SQLException {
        String sql = "update employee set emp_email=?,emp_add=? where emp_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, employee.getEmp_email());
        preparedStatement.setString(2, employee.getAdd());
        preparedStatement.setString(3, employee.getEmp_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("information  updated");
            return true;

        } else {
            System.out.println("error");
            return false;
        }


    }

    //error
    /*@Override
    public boolean update() throws SQLException {
        Employee employee = new Employee();
        String sql2 = "update employee set emp_email=?,emp_add=? where emp_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql2);
        preparedStatement.setString(1, employee.getEmp_email());
        preparedStatement.setString(2, employee.getAdd());
        preparedStatement.setString(3, employee.getEmp_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("information  updated");
            return true;

        } else {
            System.out.println("contact customer care");
            return false;
        }


    }
*/
    //running for employee
    @Override
    public List<String[]> allpending(String id) throws SQLException {
        List<String[]> pending = new ArrayList<>();
        String sql1 = "(select emp_id,rem_id,rem_type,rem_amt,rem_date,rem_status from Reimb where emp_id='" + id + "' and rem_status='pending')";
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql1);
            while (result.next()) {
                String[] row = new String[6];
                for (int i = 0; i < 6; i++) {
                    row[i] = result.getString(i + 1);
                }
                pending.add(row);

            }
        } catch (SQLException e) {
            System.out.println("no pending rem ");
        }
        return pending;
    }

    //running for employee
    @Override
    public boolean submit(Reimb rem) throws SQLException {
        String sql = "insert into Reimb(emp_id,rem_type,rem_amt) values (?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, rem.getEmp_id());
        preparedStatement.setString(2, rem.getRem_type());
        preparedStatement.setInt(3, rem.getRem_amt());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Reimbursement case accepted ");
            return true;
        } else {
            System.out.println("check out with manager");
        }
        return false;

    }
//running for employee
    @Override
    public List<String[]> allresolved(String id) {
        List<String[]>resolved = new ArrayList<>();
        String sql1 = "(select emp_id,rem_id,rem_type,rem_amt,rem_date,rem_status,remappdate,hr_id from Reimb where emp_id='" + id + "' and (rem_status='approved' or rem_status='deny'))";
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql1);
            while (result.next()) {
                String[] row = new String[8];
                for (int i = 0; i < 8; i++) {
                    row[i] = result.getString(i + 1);
                }
                resolved.add(row);

            }
        } catch (SQLException e) {
            System.out.println("no resolved rem ");
        }
        return resolved;

    }
//running
    @Override
    public List<String[]> viewinfo(String id)

    {
        List<String[]>info = new ArrayList<>();
        String sql="select e.emp_id,e.emp_name,e.emp_pwd,e.emp_email,r.rem_id,r.rem_status,r.rem_type,r.rem_date,r.rem_amt,r.remappdate,r.hr_id from employee e INNER JOIN Reimb r ON e.emp_id=r.emp_id where e.emp_id='" + id + "'";
        try {
            Statement statement = con.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                String[] row = new String[11];
                for (int i = 0; i < 11; i++) {
                    row[i] = resultset.getString(i + 1);
                }
                info.add(row);
            }
        }catch(SQLException e){
            System.out.println("record not found");
        }
        return info;


    }
}
