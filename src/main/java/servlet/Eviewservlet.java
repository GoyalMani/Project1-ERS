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
import java.util.ArrayList;
import java.util.List;

public class Eviewservlet extends HttpServlet
{
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     response.setContentType("text/html");
     PrintWriter out=response.getWriter();
     HttpSession session= request.getSession();
   String id=session.getAttribute("Emp_id").toString();
   List<String[]> List1=new ArrayList<>();
     Employeemethod e1= Employeestore.getemployeemethod();
     Employee employee=new Employee();
     employee.setEmp_id(id);
     request.getRequestDispatcher("eview.html").include(request,response);
     List1=e1.viewinfo(id);
     out.println("<table border=\"4\">\n" +
             "        <thead>\n" +
             "        <tr>\n" +
             "            <th>EMP_ID</th>\n" +
             "            <th>EMP_NAME</th>\n" +
             "            <th>EMP_PWD</th>\n" +
             "            <th>EMP_EMAIL</th>\n" +
             "            <th>REM_ID</th>\n" +
             "            <th>REM_STATUS</th>\n" +
             "            <th>REM_TYPE</th>\n" +
             "            <th>REM_REQUDATE</th>\n" +
             "            <th>REM_AMT</th>\n" +
             "            <th>REM_APPDATE</th>\n" +
             "            <th>HR_ID</th>\n" +
             "                 </tr>\n" +
             "        </thead>\n"+
             "      <tbody>");
        for(String[]info:List1){
           out.println("<tr>");
           out.println("<td>"+info[0]+"</td>");
            out.println("<td>"+info[1]+"</td>");
            out.println("<td>"+info[2]+"</td>");
            out.println("<td>"+info[3]+"</td>");
            out.println("<td>"+info[4]+"</td>");
            out.println("<td>"+info[5]+"</td>");
            out.println("<td>"+info[6]+"</td>");
            out.println("<td>"+info[7]+"</td>");
            out.println("<td>"+info[8]+"</td>");
            out.println("<td>"+info[9]+"</td>");
            out.println("<td>"+info[10]+"</td></tr>");

        }
        out.println("</tbody></table>");
        out.close();
 }

}
