package by.nc.shpakovskaya.web.commands.commandsclasses;

import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.enums.EnumURL;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 21.11.2016.
 */
public class AddDepartmentCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        if(request.getSession().getAttribute("access").equals("admin")) {
            return EnumURL.ADD_DEPARTMENT;
        } else {
            return EnumURL.REQUEST_DENIED;        }
    }
}