package by.nc.shpakovskaya.web.servlets;

import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.FindRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valeria on 08.11.2016.
 */

//@WebServlet("/controller")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletProcessing(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletProcessing(req, resp);
    }

    private void servletProcessing(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("UTF-8");
        ActionCommand findReq = new FindRequest().Command(req);
        String page = findReq.execute(req);

        try {
            System.out.println(req.getParameter("username"));
            try {
                req.getRequestDispatcher(page).forward(req, resp);
            } catch (IOException e) {
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        } catch (ServletException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
}


