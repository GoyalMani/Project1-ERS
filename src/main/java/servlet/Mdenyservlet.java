package servlet;

import Dao.Reimbmethod;
import model.Reimb;
import util.Reimbstore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Mdenyservlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        String stat=request.getParameter("Rem_stat");
        int  remid= Integer.parseInt(request.getParameter("Rem_id"));
        HttpSession session=request.getSession();
        String id= session.getAttribute("Hr_id").toString();
        Reimb rem=new Reimb();
        rem.setRem_status(stat);
        rem.setHr_id(id);
        rem.setRem_id(remid);
        Reimbmethod r1= Reimbstore.getreimbmethod();

//        request.getRequestDispatcher("MPendingservlet").include(request,response);
        request.getRequestDispatcher("mapprove.html").include(request,response);
        boolean result=false;
        try {


           result=r1.denyrequest(id,remid);
        }
       catch(SQLException e){
            e.printStackTrace();
        }
        if(result){
            System.out.println("updated request:deny");
            request.getRequestDispatcher("mapprove.html").include(request,response);

        }
        /*else{
            System.out.println("not updated");
            request.getRequestDispatcher("mapprove.html").include(request,response);

        }
*/
    }
    }

