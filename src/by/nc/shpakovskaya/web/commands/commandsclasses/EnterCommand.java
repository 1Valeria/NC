package by.nc.shpakovskaya.web.commands.commandsclasses;

import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.enums.EnumURL;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 13.11.2016.
 */
public class EnterCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return EnumURL.ENTER;
    }
}
