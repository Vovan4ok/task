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

@WebServlet("/bucket")
public class BucketServlet extends HttpServlet {
    private SubscriptionService subscriptionService = SubscriptionServiceImpl.getSubscriptionService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String magazineId = request.getParameter("magazineId");
            Integer subscriptionMonth = Integer.parseInt(request.getParameter("subscriptionMonth"));

            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("userId");

            Subscription subscription = new Subscription(userId, Integer.parseInt(magazineId), subscriptionMonth, new Date());
            subscriptionService.create(subscription);

            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Success");
        } catch(Exception e) {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Failure");
        }
    }
}
