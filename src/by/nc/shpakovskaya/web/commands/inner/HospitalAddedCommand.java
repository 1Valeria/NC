package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.dao.hospital.HospitalDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 21.11.2016.
 */
public class HospitalAddedCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        new HospitalDAO().add(new Hospital(request.getParameter("enter name")));
        return "/WEB-INF/jsps/personalPages/administrator/hospitaladded.jsp";
    }
}