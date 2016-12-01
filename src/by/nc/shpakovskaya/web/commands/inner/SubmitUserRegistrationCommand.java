package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.roles.users.client.Client;
import by.nc.shpakovskaya.dao.client.ClientDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Valeria on 18.11.2016.
 */
public class SubmitUserRegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        List<Client> clientList = new ClientDAO().get();
        System.out.println("************ clientList from ClientDAO().get() = " + clientList);
        for (Client client : clientList){
            System.out.println("************ client.getName() from clientList = " + client.getName());
            if(request.getParameter("login").equals(client.getLogin())){
                // найти адрес эрроор страницы
                request.setAttribute("loginAlreadyExists","yes");
                return "/WEB-INF/jsps/requestdenied.jsp";
            }
        }
        new ClientDAO().add(new Client(request.getParameter("name"), request.getParameter("surname"),
                request.getParameter("email"), request.getParameter("login"), request.getParameter("password1")));
        return "/WEB-INF/jsps/registrationSubmit.jsp";
    }
}
