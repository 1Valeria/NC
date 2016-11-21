package by.nc.shpakovskaya.web.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valeria on 13.11.2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
