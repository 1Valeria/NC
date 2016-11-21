package by.nc.shpakovskaya.web.commands.inner;

import by.nc.shpakovskaya.beans.roles.administrator.Administrator;
import by.nc.shpakovskaya.beans.roles.users.client.Client;
import by.nc.shpakovskaya.dao.administrator.AdministratorDAO;
import by.nc.shpakovskaya.dao.client.ClientDAO;
import by.nc.shpakovskaya.web.commands.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Valeria on 13.11.2016.
 */
public class PersonalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

// здесь можно перенаправлять на личные кабинееты в зависимости от наличия логина и пароля в списках

        List<Client> clients = new ClientDAO().get();
        for (Client client : clients) {
            System.out.println("login: " + request.getParameter("login"));
            System.out.println("password: " + request.getParameter("password"));
            System.out.println("client.getLogin(): " + client.getLogin());
            System.out.println("client.getPassword(): " + client.getPassword());
            if(client.getLogin().equals(request.getParameter("login")) &&
                    client.getPassword().equals(request.getParameter("password"))){
                request.getSession().setAttribute("someone", "logged");
                System.out.println("Entered as " + client.getLogin());
                return "/WEB-INF/jsps/personalPages/user/user.jsp";
            }
        }

        List<Administrator> administrators = new AdministratorDAO().get();
        for (Administrator administrator : administrators) {
            if(administrator.getLogin().equals(request.getParameter("login")) &&
                        administrator.getPassword().equals(request.getParameter("password"))){
                System.out.println("Entered as " + administrator.getLogin());
                HttpSession session = request.getSession(true);
                request.getSession().setAttribute("someone", "logged");
                return "/WEB-INF/jsps/personalPages/administrator/administrator.jsp";
            }
        }

        return "/WEB-INF/jsps/enter.jsp";
    }
}
