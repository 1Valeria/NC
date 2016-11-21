package by.nc.shpakovskaya.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Valeria on 20.11.2016.
 */

@WebFilter("/controller?command=main")
public class AuthentificationFilter implements Filter {

        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            HttpSession session = request.getSession(false);
            String loginURI = request.getContextPath() + "/controller?command=enter";

            boolean loggedIn = session != null && session.getAttribute("someone") != null;
            boolean loginRequest = request.getRequestURI().equals(loginURI);

            if (loggedIn || loginRequest) {
                System.out.println("+++yes");
                chain.doFilter(request, response);
            } else {
                System.out.println("++no");
                response.sendRedirect(loginURI);
            }
        }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}