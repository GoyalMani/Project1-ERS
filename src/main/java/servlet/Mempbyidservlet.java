package servlet;

import Dao.Employeemethod;
import Dao.Managermethod;
import model.Employee;
import model.Reimb;
import util.Employeestore;
import util.Managerstore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Mempbyidservlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter out= response.getWriter();
      String id=request.getParameter("emp_id");
      Managermethod m1= Managerstore.getmanagermethod();
      Employee emp=new Employee();
      Reimb rem=new Reimb();
      //String a=emp.getEmp_name();
      request.getRequestDispatcher("Mempbyid.html").include(request,response);


      try {
         rem=  m1.getempbyid(id);
      }
      catch (SQLException e)
      {
          e.printStackTrace();
      }
       out.println("<table>\n" +
               "            <thead>\n" +
               "            <tr>\n" +
               "                <th>EMP_ID</th>\n" +
               "                <th>REM_ID</th>\n" +
               "                <th>REM_STATUS</th>\n" +
               "                <th>REM_AMT</th>\n" +
               "                <th>REM_TYPE</th>\n" +
               "                <th>REM_DATE</th>\n" +
               "                <th>REM_APPDATE</th>\n" +
               "                <th>HR_ID</th>\n" +
               "    \n" +
               "            </tr>\n" +
               "            </thead><tbody>");


          out.println("<tr>");
          out.printf("<td></td>");
          out.println("<td></td>");


          out.println("</tbody> </table>");
          out.close();

  }


}






