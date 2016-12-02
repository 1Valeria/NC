package by.nc.shpakovskaya.web.commands.commandsclasses;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.dao.hospital.HospitalDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.enums.EnumURL;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 21.11.2016.
 */
public class HospitalAddedCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        if(request.getSession().getAttribute("access").equals("admin")) {
            new HospitalDAO().add(new Hospital(request.getParameter("newHospitalName")));
            return EnumURL.HOSPITAL_ADDED;
        } else {
            return EnumURL.REQUEST_DENIED;        }
    }
}