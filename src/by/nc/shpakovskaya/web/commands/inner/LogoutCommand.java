package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 18.11.2016.
 */
public class LogoutCommand implements ActionCommand{

        @Override
        public String execute(HttpServletRequest request) {
            request.getSession().invalidate();
            return "/WEB-INF/jsps/main.jsp";
    }
}
