package servlets;

import models.Magazine;
import services.MagazineService;
import services.impl.MagazineServiceImpl;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
