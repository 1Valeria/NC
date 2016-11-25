package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 18.11.2016.
 */
public class AcceptRequestsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        if(request.getSession().getAttribute("access").equals("admin")) {
            return "/WEB-INF/jsps/personalPages/administrator/acceptRequests.jsp";
        }
        else {
            return "/WEB-INF/jsps/requestdenied.jsp";
        }
    }
}