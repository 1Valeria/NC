package by.nc.shpakovskaya.web.filter;

import by.nc.shpakovskaya.web.commands.enums.EnumURL;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valeria on 20.11.2016.
 */
@WebFilter( urlPatterns = { "/jsps" },
        initParams = { @WebInitParam(name = "INDEX_PATH", value = "index.jsp") })
public class AuthentificationFilter implements Filter {

        private String indexPath;

    public void init(FilterConfig fConfig) throws ServletException {
        indexPath = fConfig.getInitParameter("INDEX_PATH");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest;
        HttpServletResponse httpResponse;
        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;
        try {
            // переход на заданную страницу
            httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
            chain.doFilter(request, response);
        } catch (Exception ex) {
            httpResponse.sendRedirect(EnumURL.MAIN);
        }
    }

    public void destroy() {
    }

}