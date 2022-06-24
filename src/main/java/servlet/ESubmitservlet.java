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
//running for employee
public class ESubmitservlet extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    HttpSession session= request.getSession();
    String id=session.getAttribute("Emp_id").toString();
            //request.getParameter("Emp_id");
    String rtype= request.getParameter("Rem_type");
    int amt= Integer.parseInt(request.getParameter("Rem_amt"));
    Reimb rem =new Reimb();
   rem.setEmp_id(id);
    rem.setRem_type(rtype);
    rem.setRem_amt(amt);

    Employeemethod e1= Employeestore.getemployeemethod();
    boolean result=false;
    try {

        result=e1.submit(rem);
    }
    catch(SQLException e){
        e.printStackTrace();
    }
 if(result){
     System.out.println("submit reimbursement");
     request.getRequestDispatcher("Escreen.html").include(request,response);

 }
else{
     System.out.println("not accepted");
     request.getRequestDispatcher("esubmit.html").include(request,response);

 }

}

}
