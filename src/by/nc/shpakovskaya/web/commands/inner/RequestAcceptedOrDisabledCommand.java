package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.roles.users.client.Client;
import by.nc.shpakovskaya.dao.client.ClientDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Valeria on 25.11.2016.
 */
public class RequestAcceptedOrDisabledCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        int clientsIdToModify = Integer.valueOf(request.getParameter("clientId"));
        System.out.println("client Id: " + clientsIdToModify);
        List<Client> clientList = new ClientDAO().get();
        for (Client client : clientList){
            if(client.getId()==clientsIdToModify){
                if(client.getAdmit().equals("no")){
                    new ClientDAO().update(true, clientsIdToModify);
                }
                else if (client.getAdmit().equals("yes")){
                    new ClientDAO().update(false, clientsIdToModify);
                }
            }
        }

        return "/WEB-INF/jsps/personalPages/administrator/requestmodified.jsp";
    }
}
