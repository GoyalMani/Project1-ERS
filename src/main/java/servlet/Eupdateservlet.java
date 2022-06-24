package servlet;

import Dao.Employeemethod;
import model.Employee;
import util.Employeestore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Eupdateservlet extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
   response.setContentType("text/html");
   PrintWriter out=response.getWriter();
   HttpSession session= request.getSession();
   String id= session.getAttribute("Emp_id").toString();

    String email=request.getParameter("email");
    String add1=request.getParameter("add1");
    Employee employee=new Employee();
   employee.setEmp_id(id);
   employee.setEmp_email(email);
   employee.setAdd(add1);
    Employeemethod e1= Employeestore.getemployeemethod();
    boolean result=false;
    try {

        result=e1.update(employee);
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    if(result){
        System.out.println("info updated");
        request.getRequestDispatcher("Escreen.html").include(request,response);

    }
    else{
        System.out.println("Error in updating");
        request.getRequestDispatcher("eupdate.html").include(request,response);

    }



}




}
