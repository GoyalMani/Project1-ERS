package servlet;

import Dao.Managermethod;
import util.Managerstore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//running for manager
public class MViewallservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<String[]> List1 = new ArrayList<>();
        Managermethod m1 = Managerstore.getmanagermethod();
        //request.getRequestDispatcher("Mscreen.html").include(request, response);//will display list on mscreen
        request.getRequestDispatcher("mview.html").include(request,response);
        try {
            List1 = m1.displayall();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       out.println(" <table border=\"4\">\n" +
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
               "            <th>HR_ID</th>\n"   +
                "</tr></thead><tbody>");
        for (String[] info : List1) {

            out.println("<tr>");
            out.println("<td>" + info[0] + "</td>");
            out.println("<td>" + info[1] + "</td>");
            out.println("<td>" + info[2] + "</td>");
            out.println("<td>" + info[3] + "</td>");
            out.println("<td>" + info[4] + "</td>");
            out.println("<td>" + info[5] + "</td>");
            out.println("<td>" + info[6] + "</td>");
            out.println("<td>" + info[7] + "</td>");
            out.println("<td>" + info[8] + "</td>");
            out.println("<td>" + info[9] + "</td>");
            out.println("<td>" +info[10] +"<td></tr>");


        }
        out.println("</tbody> </table>");
        out.close();
    }


}
