package servlet;



import Dao.Managermethod;

import util.Managerstore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
//running for manager
public class Mloginservlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String id=request.getParameter("Hr_id");
        String pwd=request.getParameter("Hr_Pwd");
        HttpSession session= request.getSession();
        session.setAttribute("Hr_id",id);
        session.setAttribute("Hr_Pwd",pwd);
        Managermethod m1= Managerstore.getmanagermethod();


        boolean count=false;

        try {
            count= m1.login(id,pwd);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        if(count){
            System.out.println("successful login");
            // out.println("welcome"+id);
            request.getRequestDispatcher("Mscreen.html").include(request,response);
        }
        else{
            System.out.println("invalid login");
            request.getRequestDispatcher("Mlogin.html").include(request,response);
        }
    }

}



