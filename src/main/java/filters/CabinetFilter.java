package filters;

import shared.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/task_war/cabinet.jsp")
public class CabinetFilter implements Filter {
    private FilterService filterService = FilterService.getFilterService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilterValidation(servletRequest, servletResponse, filterChain, Arrays.asList("default", "admin"));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
