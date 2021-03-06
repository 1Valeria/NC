package by.nc.shpakovskaya.web.commands.commandsclasses;

import by.nc.shpakovskaya.beans.roles.administrator.Administrator;
import by.nc.shpakovskaya.beans.roles.users.Doctor;
import by.nc.shpakovskaya.beans.roles.users.client.Client;
import by.nc.shpakovskaya.dao.administrator.AdministratorDAO;
import by.nc.shpakovskaya.dao.client.ClientDAO;
import by.nc.shpakovskaya.dao.stuff.DoctorDAO;
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

        // у последнего проверяемого записывается пустой путь (чтобы хоть какое-то значение было)

        String client = clientSearch(request),
                doctor = doctorSearch(request),
                admin = adminSearch(request),
                accessDenied = "/WEB-INF/jsps/requestdenied.jsp";


        if (!request.getSession().getAttribute("rememberedPath").toString().equals("none")) {
            System.out.println("rememberedPath: " + request.getSession().getAttribute("rememberedPath"));
            return request.getSession().getAttribute("rememberedPath").toString();
        } else if (!admin.equals("")) {
            return admin;
        } else if (!client.equals("")) {
            return client;
        } else if (!doctor.equals("")) {
            return client;
        } else {
            System.out.println("return to `request is not allowed` page + " + request.getSession().getAttribute("rememberedPath").toString());
            return accessDenied;
        }

    }

    String clientSearch(HttpServletRequest request){
        List<Client> clients = new ClientDAO().get();
        for (Client client : clients) {
//            System.out.println("login: " + request.getParameter("login"));
//            System.out.println("password: " + request.getParameter("password"));
//            System.out.println("client.getLogin(): " + client.getLogin());
//            System.out.println("client.getPassword(): " + client.getPassword());
            if(client.getLogin().equals(request.getParameter("login")) &&
                    client.getPassword().equals(request.getParameter("password"))){
                if(client.getAdmit().equals("yes")) {


                    HttpSession session = request.getSession(true);
                    session.setAttribute("access", "client");
                    session.setAttribute("login", request.getParameter("login"));
                    session.setAttribute("rememberedPath", "/WEB-INF/jsps/personalPages/user/user.jsp");
                    System.out.println("rememberedPath are set");

                    System.out.println("getAdmit() from yes = " + client.getAdmit());
                    return "/WEB-INF/jsps/personalPages/user/user.jsp";
                } else {
                    System.out.println("getAdmit() from else = " + client.getAdmit());
                    return  "";
                }
            }
        }
        return "";
    }

    String doctorSearch(HttpServletRequest request){
        List<Doctor> doctors = new DoctorDAO().get();
        for (Doctor doctor : doctors) {
            if(doctor.getLogin().equals(request.getParameter("login")) &&
                    doctor.getPassword().equals(request.getParameter("password"))){
                if(doctor.getAdmit().equals("yes")) {

                    HttpSession session = request.getSession(true);
                    session.setAttribute("access", "doctor");
                    session.setAttribute("login", request.getParameter("login"));
                    session.setAttribute("rememberedPath", "/WEB-INF/jsps/personalPages/user/doctor.jsp");

                    System.out.println("rememberedPath are set");
                    return "/WEB-INF/jsps/personalPages/user/doctor.jsp";
                }
                else{
                    System.out.println("getAdmit() from else = " + doctor.getAdmit());
                    return  "";
                }
            }
        }
        return "";
    }

    String adminSearch(HttpServletRequest request){
        List<Administrator> administrators = new AdministratorDAO().get();
        for (Administrator administrator : administrators) {
            if(administrator.getLogin().equals(request.getParameter("login")) &&
                    administrator.getPassword().equals(request.getParameter("password"))){

                HttpSession session = request.getSession(true);
                session.setAttribute("access", "admin");
                session.setAttribute("login", request.getParameter("login"));
                session.setAttribute("rememberedPath", "/WEB-INF/jsps/personalPages/administrator/administrator.jsp");

                System.out.println("rememberedPath are set");
                return "/WEB-INF/jsps/personalPages/administrator/administrator.jsp";
            }
        }
        try {
            if (request.getSession().getAttribute("rememberedPath").toString().isEmpty()) {
                System.out.println("set rememberedPath as null ");
                request.getSession().setAttribute("rememberedPath", "none");
            }
        }catch (Exception exception){
            request.getSession().setAttribute("rememberedPath", "none");
        }

        return "";
    }

}