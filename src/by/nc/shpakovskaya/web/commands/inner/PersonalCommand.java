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

// здесь можно перенаправлять на личные кабинеты в зависимости от наличия логина и пароля в списках


        String client = clientSearch(request),
                admin = adminSearch(request),
                enterPage = "/WEB-INF/jsps/enter.jsp";

        if (!request.getSession().getAttribute("rememberedPath").toString().isEmpty()) {
            System.out.println("rememberedPath: " + request.getSession().getAttribute("rememberedPath"));
            return request.getSession().getAttribute("rememberedPath").toString();
        } else if (!admin.equals("")) {
            return admin;
        } else if (!client.equals("")) {
            return client;
        } else {
            return enterPage;
        }

    }

    String clientSearch(HttpServletRequest request){
        List<Client> clients = new ClientDAO().get();
        for (Client client : clients) {
            if(client.getLogin().equals(request.getParameter("login")) &&
                    client.getPassword().equals(request.getParameter("password"))){
                request.getSession().setAttribute("someone", "logged");
                System.out.println("Entered as " + client.getLogin());
                HttpSession session = request.getSession(true);
                session.setAttribute("login", request.getParameter("login"));
                session.setAttribute("rememberedPath", "/WEB-INF/jsps/personalPages/user/user.jsp");
                System.out.println("rememberedPath are set");
                return "/WEB-INF/jsps/personalPages/user/user.jsp";
            }
        }
        return "";
    }

    String adminSearch(HttpServletRequest request){
        List<Administrator> administrators = new AdministratorDAO().get();
        for (Administrator administrator : administrators) {
            if(administrator.getLogin().equals(request.getParameter("login")) &&
                    administrator.getPassword().equals(request.getParameter("password"))){
                System.out.println("Entered as " + administrator.getLogin());
                HttpSession session = request.getSession(true);
                session.setAttribute("login", request.getParameter("login"));
                session.setAttribute("rememberedPath", "/WEB-INF/jsps/personalPages/administrator/administrator.jsp");
                System.out.println("rememberedPath are set");
                return "/WEB-INF/jsps/personalPages/administrator/administrator.jsp";
            }
        }

        return "";
    }

}
