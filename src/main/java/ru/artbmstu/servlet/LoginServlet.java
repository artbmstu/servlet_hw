package ru.artbmstu.servlet;

import ru.artbmstu.util.AuthHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("username");
        String pword=request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(AuthHelper.isAllowed(uname, pword)) {
            RequestDispatcher dispatcher=request.getRequestDispatcher("app");
            dispatcher.forward(request,response);
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/loginWithError.html");
            rd.include(request,response);
        }
    }
}