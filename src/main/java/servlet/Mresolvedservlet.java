package servlet;

import Dao.Managermethod;
import model.Manager;
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
public class Mresolvedservlet extends HttpServlet {
    public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException, ServletException {
     response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        String id=session.getAttribute("Hr_id").toString();
        List<String[]> List1=new ArrayList<>();
        Managermethod m1= Managerstore.getmanagermethod();
        Manager mgn=new Manager();
        mgn.setHr_id(id);
        request.getRequestDispatcher("Mresolved.html").include(request,response);
        List1 = m1.allresolved();
        out.println(" <table border=\"4\">\n" +
                "        <thead>\n" +
                "        <tr>\n" +
                "            <td>EMP_ID</td>\n" +
                "            <td>REM_ID</td>\n" +
                "            <td>REM_TYPE</td>\n" +
                "            <td>REM_AMT</td>\n" +
                "            <td>REM_DATE</td>\n" +
                "            <td>REM_STATUS</td>\n" +
                "            <td>REM_APPDATE</td>\n" +
                "            <td>HR_ID</td>\n" +
                "            \n" +
                "        </tr>\n" +
                "        </thead>\n"+
                "         <tbody>");

                for(String[] resolved:List1){
       out.println("<tr>");
       out.println("<td>"+resolved[0]+"</td>");
       out.println("<td>"+resolved[1]+"</td>");
       out.println("<td>"+resolved[2]+"</td>");
       out.println("<td>"+resolved[3]+"</td>");
       out.println("<td>"+resolved[4]+"</td>");
       out.println("<td>"+resolved[5]+"</td>");
       out.println("<td>"+resolved[6]+"</td>");
       out.println("<td>"+resolved[7]+"</td>");

   }
   out.println("</tbody></table>");
   out.close();
    }


}
