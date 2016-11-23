package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.roles.users.Doctor;
import by.nc.shpakovskaya.dao.stuff.DoctorDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 24.11.2016.
 */
public class SubmitDoctorRegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        new DoctorDAO().add(new Doctor(request.getParameter("name"), request.getParameter("surname"),
                request.getParameter("issue"), request.getParameter("education"), request.getParameter("email"),
                request.getParameter("login"), request.getParameter("password1")));
        return "/WEB-INF/jsps/registrationSubmit.jsp";
    }
}
