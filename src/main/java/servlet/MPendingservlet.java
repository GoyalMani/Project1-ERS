package servlet;

import Dao.Employeemethod;
import Dao.Managermethod;
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
import java.util.ArrayList;
import java.util.List;
//running for manager
public class MPendingservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       // HttpSession session= request.getSession();
        //String id=session.getAttribute("Hr_id").toString();
        List<String[]> List1 = new ArrayList<>();
        Managermethod m1 = Managerstore.getmanagermethod();
        request.getRequestDispatcher("Mpending.html").include(request, response);
        //request.getRequestDispatcher("Mscreen.html").include(request, response);
        try {
            List1 = m1.allpending();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("<table border=\"4\">\n" +
                "        <thead>\n" +
                "        <tr>\n" +
                "            <th>EMP_ID</th>\n" +
                "             <th>REM_ID</th>\n" +
                "            <th>REM_TYPE</th>\n" +
                "            <th>REM_AMT</th>\n" +
                "            <th>REM_REQUDATE</th>\n" +
                "            <th>REM_STATUS</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "    <tbody>");
        for (String[] pending : List1) {
            out.println("<tr>");
            out.println("<td>" + pending[0] + "</td>");
            out.println("<td>" + pending[1] + "</td>");
            out.println("<td>" + pending[2] + "</td>");
            out.println("<td>" + pending[3] + "</td>");
            out.println("<td>" + pending[4] + "</td>");
            out.println("<td>"+pending[5]+"</td></tr>");
        }
        out.println("</tbody> </table>");
        out.close();
    }

}
