package by.nc.shpakovskaya.web.commands.commandsclasses;

import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.enums.EnumURL;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 18.11.2016.
 */
public class AcceptRequestsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        if(request.getSession().getAttribute("access").equals("admin")) {
            return EnumURL.ACCEPT_REQUESTS_PAGE;
        }
        else {
            return EnumURL.REQUEST_DENIED;
        }
    }
}