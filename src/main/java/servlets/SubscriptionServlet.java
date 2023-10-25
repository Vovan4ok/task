package servlets;

import com.google.gson.Gson;
import models.Magazine;
import models.Subscription;
import models.SubscriptionDto;
import services.MagazineService;
import services.SubscriptionService;
import services.impl.MagazineServiceImpl;
import services.impl.SubscriptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet("/subscription")
public class SubscriptionServlet extends HttpServlet {
    private SubscriptionService subscriptionService = SubscriptionServiceImpl.getSubscriptionService();
    private MagazineServiceImpl magazineService = MagazineServiceImpl.getMagazineService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userId");

        List<Subscription> subscriptionList = subscriptionService.readAll();
        Map<Integer, Magazine> idToMagazine = magazineService.readAllMap();
        List<SubscriptionDto> listOfSubscriptions = map(subscriptionList, idToMagazine, userID);

        String json = new Gson().toJson(listOfSubscriptions);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public List<SubscriptionDto> map(List<Subscription> subscriptions, Map<Integer, Magazine> idToMagazine, Integer userId) {
        return subscriptions.stream().filter(sub -> Objects.equals(sub.getUserId(), userId)).map(sub -> {
           SubscriptionDto subDto = new SubscriptionDto();
           subDto.subscriptionId = sub.getId();
           subDto.purchaseDate = sub.getSubscriptionDate();

           Magazine magazine = idToMagazine.get(sub.getMagazineId());
           subDto.name = magazine.getName();
           subDto.description = magazine.getDescription();
           subDto.price = magazine.getPrice();

           return subDto;
        }).collect(Collectors.toList());
    }

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

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer subscriptionId = Integer.parseInt(request.getParameter("subscriptionId"));
        subscriptionService.delete(subscriptionId);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}
