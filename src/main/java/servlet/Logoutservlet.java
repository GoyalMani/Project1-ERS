package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Logoutservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        HttpSession session= request.getSession();
         session.removeAttribute("Hr_id");
          session.removeAttribute("Hr_Pwd");
          request.getRequestDispatcher("logout.html").include(request,response);
          out.close();
    }

    }



