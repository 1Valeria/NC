package by.nc.shpakovskaya.web.commands.commandsclasses;

import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.enums.EnumURL;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 24.11.2016.
 */
public class ChooseRegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        return EnumURL.CHOOSE_REGISTRATION_FORM;
    }
}