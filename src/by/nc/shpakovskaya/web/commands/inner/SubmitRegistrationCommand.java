package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.roles.users.client.Client;
import by.nc.shpakovskaya.dao.client.ClientDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 18.11.2016.
 */
public class SubmitRegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        new ClientDAO().add(new Client(request.getParameter("name"), request.getParameter("surname"),
                request.getParameter("email"), request.getParameter("login"), request.getParameter("password1")));
        return "/WEB-INF/jsps/registrationSubmit.jsp";
    }
}
