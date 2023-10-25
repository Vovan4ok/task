package shared;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FilterService {
    private static FilterService filterService;
    private FilterService() {}

    public static FilterService getFilterService() {
        if(filterService == null) {
            filterService = new FilterService();
        }
        return filterService;
    }
    public void doFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain, List<String> userRoles) throws ServletException, IOException {
        try {
            HttpSession session = ((HttpServletRequest) request).getSession();
            String userRole = session.getAttribute("role").toString();

            if(userRole != null && userRoles.contains(userRole)) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch(Exception e) {
            ((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
