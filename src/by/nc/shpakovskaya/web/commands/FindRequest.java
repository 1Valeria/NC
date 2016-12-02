package by.nc.shpakovskaya.web.commands;

import by.nc.shpakovskaya.web.commands.enums.EnumRoutes;
import by.nc.shpakovskaya.web.commands.commandsclasses.EnterCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 13.11.2016.
 */
public class FindRequest {
    public ActionCommand Command(HttpServletRequest request){
        String command = request.getParameter("command");
        ActionCommand current = null;
        try {
            EnumRoutes currentEnum = EnumRoutes.valueOf(command.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            current = new EnterCommand();
        }
        return current;
    }
}