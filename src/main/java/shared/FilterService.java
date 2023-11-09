package shared;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
