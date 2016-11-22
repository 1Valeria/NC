package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 18.11.2016.
 */
public class LogoutCommand implements ActionCommand{

        @Override
        public String execute(HttpServletRequest request) {
            System.out.println("End of session");
            request.getSession().invalidate();
            return "/WEB-INF/jsps/main.jsp";
    }
}
