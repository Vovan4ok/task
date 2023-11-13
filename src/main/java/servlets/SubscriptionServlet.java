package servlets;

import com.google.gson.Gson;
import models.Magazine;
import models.Subscription;
import models.SubscriptionDto;
import models.User;
import services.MagazineService;
import services.SubscriptionService;
import services.impl.MagazineServiceImpl;
import services.impl.SubscriptionServiceImpl;
import services.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/subscription")
public class SubscriptionServlet extends HttpServlet {
    private SubscriptionServiceImpl subscriptionService = SubscriptionServiceImpl.getSubscriptionService();
    private MagazineServiceImpl magazineService = MagazineServiceImpl.getMagazineService();
    private UserServiceImpl userService = UserServiceImpl.getUserService();

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

        Magazine magazine = magazineService.read(Integer.parseInt(magazineId));

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.read(userId);

        Subscription subscription = new Subscription();
        subscription.setId(UUID.randomUUID().toString());
        subscription.setMagazineId(magazine.getId());
        subscription.setUserId(user.getId());
        subscription.setMonthsNumber(1);
        subscription.setSubscriptionDate(new Date());

        subscriptionService.create(subscription);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subscriptionId = request.getParameter("subscriptionId");
        subscriptionService.delete(subscriptionId);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}
