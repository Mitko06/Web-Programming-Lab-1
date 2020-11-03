package mk.finki.ukim.mk.lab.service.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter
public class ColorSelectFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String path = request.getServletPath();
        
        if (("/selectBalloon".equals(path) || "/confirmationInfo".equals(path) ||"/BalloonOrder.do".equals(path)) && request.getSession().getAttribute("balloon-color")==null){
            response.sendRedirect("/");
        }
        else
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
