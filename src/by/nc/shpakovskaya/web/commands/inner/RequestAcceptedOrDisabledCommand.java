package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.roles.users.Doctor;
import by.nc.shpakovskaya.beans.roles.users.client.Client;
import by.nc.shpakovskaya.dao.client.ClientDAO;
import by.nc.shpakovskaya.dao.stuff.DoctorDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Valeria on 25.11.2016.
 */
public class RequestAcceptedOrDisabledCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        int usersIdToModify = Integer.valueOf(request.getParameter("userId"));
        System.out.println("user Id: " + usersIdToModify);
        List<Client> clientList = new ClientDAO().get();
        for (Client client : clientList){
            if(client.getId()==usersIdToModify){
                if(client.getAdmit().equals("no")){
                    new ClientDAO().update(true, usersIdToModify);
                }
                else if (client.getAdmit().equals("yes")){
                    new ClientDAO().update(false, usersIdToModify);
                }
            }
        }
        List<Doctor> doctorList = new DoctorDAO().get();
        for (Doctor doctor : doctorList){
            if(doctor.getId()==usersIdToModify){
                if(doctor.getAdmit().equals("no")){
                    new DoctorDAO().update(true, usersIdToModify);
                }
                else if (doctor.getAdmit().equals("yes")){
                    new DoctorDAO().update(false, usersIdToModify);
                }
            }
        }

        return "/WEB-INF/jsps/personalPages/administrator/requestmodified.jsp";
    }
}
