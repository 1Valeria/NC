package by.nc.shpakovskaya.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Valeria on 14.11.2016.
 */
public class SetCharacterEncodingFilter implements Filter {


    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {	}

}
