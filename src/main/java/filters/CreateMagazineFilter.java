package filters;

import shared.FilterService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/task_war/createMagazine.jsp")
public class CreateMagazineFilter implements Filter {
    private FilterService filterService = FilterService.getFilterService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilterValidation(servletRequest, servletResponse, filterChain, Arrays.asList("admin"));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
