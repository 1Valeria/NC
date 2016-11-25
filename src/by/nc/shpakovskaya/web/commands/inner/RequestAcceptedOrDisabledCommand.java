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

        if (request.getSession().getAttribute("access").equals("admin")) {
            try {
                activateUser(request);
                return "/WEB-INF/jsps/personalPages/administrator/requestmodified.jsp";
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            //    keep going
            }
            try{
                activateDoctor(request);
            } catch (Exception exception) {
                return "/WEB-INF/jsps/requestdenied.jsp";
            }
            return "/WEB-INF/jsps/personalPages/administrator/requestmodified.jsp";
        } else {
            return "/WEB-INF/jsps/requestdenied.jsp";
        }
    }

    public void activateUser(HttpServletRequest request) {
        int usersIdToModify = Integer.valueOf(request.getParameter("userId"));
        System.out.println("user Id: " + usersIdToModify);
        List<Client> clientList = new ClientDAO().get();
        for (Client client : clientList) {
            if (client.getId() == usersIdToModify) {
                if (client.getAdmit().equals("no")) {
                    new ClientDAO().update(true, usersIdToModify);
                } else if (client.getAdmit().equals("yes")) {
                    new ClientDAO().update(false, usersIdToModify);
                }
            }
        }
    }

    public void activateDoctor(HttpServletRequest request) {
        int doctorsIdToModify = Integer.valueOf(request.getParameter("doctorId"));
        System.out.println("doctor Id: " + doctorsIdToModify);
        List<Doctor> doctorList = new DoctorDAO().get();
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == doctorsIdToModify) {
                if (doctor.getAdmit().equals("no")) {
                    new DoctorDAO().update(true, doctorsIdToModify);
                } else if (doctor.getAdmit().equals("yes")) {
                    new DoctorDAO().update(false, doctorsIdToModify);
                }
            }
        }
    }

}
