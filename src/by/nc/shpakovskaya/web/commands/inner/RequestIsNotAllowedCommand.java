package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 25.11.2016.
 */
public class RequestIsNotAllowedCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/jsps/registrationSubmit.jsp";
    }
}