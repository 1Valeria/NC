package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.beans.departments.Department;
import by.nc.shpakovskaya.dao.hospital.DepartmentDAO;
import by.nc.shpakovskaya.dao.hospital.HospitalDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Valeria on 21.11.2016.
 */
public class DepartmentAddedCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        if(request.getSession().getAttribute("access").equals("admin")) {

            int hospitalIdToAdd = Integer.valueOf(request.getParameter("hospitalIdText"));
            String departmentNameToAdd = request.getParameter("departmentNameText");
            List<Hospital> hospitalSet = new HospitalDAO().get();

            // можно заменить forEach но будет плохо читаться
            for (Hospital hospital : hospitalSet) {
                if (hospital.getId() == (hospitalIdToAdd)) {
                    System.out.println("hospital.getId() = " + hospital.getId());
                    System.out.println("hospitalIdToAdd = " + hospitalIdToAdd);
                    new DepartmentDAO().add(new Department(departmentNameToAdd, hospital));
                }
            }
            return "/WEB-INF/jsps/personalPages/administrator/departmentadded.jsp";
        }
        else {
            return "/WEB-INF/jsps/requestdenied.jsp";        }
    }
}