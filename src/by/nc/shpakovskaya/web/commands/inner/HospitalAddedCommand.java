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
        if(request.getSession().getAttribute("access").equals("admin")) {
            new HospitalDAO().add(new Hospital(request.getParameter("newHospitalName")));
            return "/WEB-INF/jsps/personalPages/administrator/hospitaladded.jsp";
        } else {
            return "/WEB-INF/jsps/requestdenied.jsp";        }
    }
}