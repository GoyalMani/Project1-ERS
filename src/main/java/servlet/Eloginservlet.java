package servlet;

import Dao.Employeemethod;
import model.Employee;
import util.Employeestore;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//running for employee
public class Eloginservlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       String id=request.getParameter("Emp_id");
       String pwd=request.getParameter("Emp_Pwd");
        HttpSession session= request.getSession();
        session.setAttribute("Emp_id",id);
        session.setAttribute("Emp_pwd",pwd);
        Employeemethod e1= Employeestore.getemployeemethod();

        //Employee employee=new Employee();
         boolean count=false;

        try {
           count= e1.login(id,pwd);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
  if(count){
      System.out.println("successful login");

      request.getRequestDispatcher("Escreen.html").include(request,response);
  }
else{
      System.out.println("invalid login");
      request.getRequestDispatcher("Elogin.html").include(request,response);
  }
    }

}
