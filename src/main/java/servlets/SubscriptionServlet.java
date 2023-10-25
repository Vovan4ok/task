package servlets;

import models.Subscription;
import services.SubscriptionService;
import services.impl.SubscriptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/subscription")
public class SubscriptionServlet extends HttpServlet {
    private SubscriptionService subscriptionService = SubscriptionServiceImpl.getSubscriptionService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String magazineId = request.getParameter("magazineId");

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        Subscription subscription = new Subscription(userId, Integer.parseInt(magazineId), 1, new Date());
        subscriptionService.create(subscription);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}
