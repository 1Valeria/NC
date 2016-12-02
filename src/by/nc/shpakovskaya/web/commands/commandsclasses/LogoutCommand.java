package by.nc.shpakovskaya.web.commands.commandsclasses;

import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.enums.EnumURL;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 18.11.2016.
 */
public class LogoutCommand implements ActionCommand{

        @Override
        public String execute(HttpServletRequest request) {
            System.out.println("End of session");
            request.getSession().invalidate();
            return EnumURL.MAIN;
    }
}
