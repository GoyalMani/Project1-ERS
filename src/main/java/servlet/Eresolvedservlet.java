package servlet;

import Dao.Employeemethod;

import model.Reimb;
import util.Employeestore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Eresolvedservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String id = session.getAttribute("Emp_id").toString();
        List<String[]>List2=new ArrayList<>();
        Employeemethod e1 = Employeestore.getemployeemethod();
        Reimb rem = new Reimb();
        rem.setEmp_id(id);
        request.getRequestDispatcher("eresolved.html").include(request, response);

        List2= e1.allresolved(id);


        out.println("<table border=\"4\">\n" +
                "        <thead>\n" +
                "        <tr>\n" +
                "            <th>EMP_ID</th>\n" +
                "             <th>REM_ID</th>\n" +
                "            <th>REM_TYPE</th>\n" +
                "            <th>REM_AMT</th>\n" +
                "            <th>R_REQUDATE</th>\n" +
                "            <th>REM_STATUS</th>\n" +
                "            <th>R_APPDATE</th>\n" +
                "            <th>HR_ID</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "    <tbody>");
        for (String[] resolved: List2) {
            out.println("<tr>");
            out.println("<td>" + resolved[0] + "</td>");
            out.println("<td>" + resolved[1] + "</td>");
            out.println("<td>" + resolved[2] + "</td>");
            out.println("<td>" + resolved[3] + "</td>");
            out.println("<td>" + resolved[4] + "</td>");
            out.println("<td>" + resolved[5] + "</td>");
            out.println("<td>" + resolved[6] + "</td>");
            out.println("<td>" + resolved[7] + "</td> </tr>");

        }
        out.println("</tbody> </table>");
        out.close();
    }

}

