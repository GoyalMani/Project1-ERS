package Dao.impl;

import Dao.Managermethod;
import model.Employee;
import model.Manager;
import model.Reimb;
import util.Connectionfac;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Managermethodimpl implements Managermethod
{
    Connection con;
    public Managermethodimpl()
    {
        this.con= Connectionfac.getConnection();
    }



//running
    @Override
    public boolean login(String id, String pwd) throws SQLException {
        Manager manager=new Manager();
        String sql="(select hr_id,hr_pwd from manager where hr_id='"+ id +"' and hr_pwd='"+ pwd+"')";
        Statement statement= con.createStatement();
        ResultSet rs= statement.executeQuery(sql);
        if(rs.next()){
            System.out.println("Login successfully");
            return true;
        }
        else {
            System.out.println("Login failed");
            return false;
        }

    }



    //running
    @Override
    public List<String[]> displayall() throws SQLException {
        List<String[]>info = new ArrayList<>();
        String sql="select e.emp_id,e.emp_name,e.emp_pwd,e.emp_email,r.rem_id,r.rem_status,r.rem_type,r.rem_date,r.rem_amt,r.remappdate,r.hr_id from employee e INNER JOIN Reimb r ON e.emp_id=r.emp_id";
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
            System.out.println("user not found");
        }
   return info;
    }

    @Override
    public Reimb getempbyid(String empid) throws SQLException {
        String sql = "select emp_id,rem_id,rem_status,rem_amt,rem_type,rem_date,remappdate,hr_id From Reimb where emp_id='" + empid + "'";
        Statement statement1 = con.createStatement();
        ResultSet rs;
        rs = statement1.executeQuery(sql);

        Reimb rem=new Reimb();
        if (rs.next()) {
            rs.getString(1);
          int  remid=  rs.getInt(2);
            String remstatus=rs.getString(3);
            int amt=rs.getInt(4);
            String remt=rs.getString(5);
            String date1=rs.getString(6);
            String date2=rs.getString(7);
            String manid=rs.getString(8);

//          List<Reimb>rem1=new ArrayList<>();
//            while(rs.next())
//
//              {
//                  String[] row1 = new String[8];
//                  for (int i = 0; i < 8; i++) {
//                      row1[i] = rs.getString(i + 1);
//                  }
//              }
//                rem1.add(rem);


                rem=new Reimb(empid,remid,remstatus,amt,remt,date1,date2,manid);

            System.out.println(rem);
        } else {
            System.out.println("User not found");

        }
       return rem;
    }

//running
    @Override
    public List<String[]> allpending() throws SQLException {
        List<String[]>pending=new ArrayList<>();
        String sql1="(select emp_id,rem_id,rem_type,rem_amt,rem_date,rem_status from Reimb where rem_status='pending')";
        try{
            Statement statement=con.createStatement();
            ResultSet result=statement.executeQuery(sql1);
            while(result.next()){
                String[] row=new String[6];
                for(int i=0;i<6;i++){
                    row[i]=result.getString(i+1);
                }
                pending.add(row);

            }
        ;}

        catch (SQLException e){
            System.out.println("no pending rem ");
        }
        return pending;
    }
//running
    @Override
    public List<String[]> allresolved() {
        List<String[]>resolved=new ArrayList<>();
        String sql1="(select emp_id,rem_id,rem_type,rem_amt,rem_date,rem_status,remappdate,hr_id from Reimb where (rem_status='approved' or rem_status='deny'))";
        try{
            Statement statement=con.createStatement();
            ResultSet result=statement.executeQuery(sql1);
            while(result.next()){
                String[] row=new String[8];
                for(int i=0;i<8;i++){
                    row[i]=result.getString(i+1);
                }
                resolved.add(row);

            }
        }

        catch (SQLException e){
            System.out.println("no approved rem ");
        }
        return resolved;
    }


}


//    @Override
//    public Employee getempbyid(String id) throws SQLException {
//        String sql = "select e.emp_id,e.emp_name,e.emp_pwd,e.emp_email,r.rem_id,r.rem_status,r.rem_type,r.rem_date," +
//                "r.rem_amt,r.remappdate,r.hr_id from employee e INNER JOIN Reimb r ON e.emp_id=r.emp_id where e.emp_id='" + id + "'";
//        Statement statement1 = con.createStatement();
//        ResultSet rs = statement1.executeQuery(sql);
//        Employee emp=new Employee();
//        Reimb rem=new Reimb();
//        if (rs.next()) {
//            rs.getString(1);
//            String n=  rs.getString(2);
//            String m=rs.getString(3);
//            String o=rs.getString(4);
//            int b=rs.getInt(5);
//            String p=rs.getString(6);
//            String h=rs.getString(7);
//            String j=rs.getString(8);
//            int k=rs.getInt(9);
//            String d=rs.getString(10);
//            String z=rs.getString(11);
//            emp=new Employee(id,n,m,o);
//            System.out.println(emp);
//            rem=new Reimb(b,p,h,j,k,d,z);
//            System.out.println(rem);
//        } else {
//            System.out.println("User not found");
//
//        }
//        return emp;
//    }
