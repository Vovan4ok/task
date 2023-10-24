package servlets;

import models.Magazine;
import services.MagazineService;
import services.impl.MagazineServiceImpl;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/magazines")
public class Magazines extends HttpServlet {
    private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Magazine> magazineList = magazineService.readAll();
        String json = new Gson().toJson(magazineList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
