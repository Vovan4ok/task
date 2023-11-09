package servlets;

import models.Magazine;
import services.MagazineService;
import services.impl.MagazineServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/magazine")
public class MagazineServlet extends HttpServlet {
    MagazineServiceImpl magazineService = MagazineServiceImpl.getMagazineService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String magazineId = request.getParameter("id");
        Magazine magazine = magazineService.read(Integer.parseInt(magazineId));

        request.setAttribute("magazine", magazine);
        request.getRequestDispatcher("singleMagazine.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("magazineName");
        String description = request.getParameter("magazineDescription");
        String author = request.getParameter("magazineAuthor");
        String price = request.getParameter("magazinePrice");

        if(name.isEmpty() || description.isEmpty() || author.isEmpty() || price.isEmpty()) {
            request.getRequestDispatcher("createMagazine.jsp").forward(request, response);
        }

        Magazine magazine = new Magazine(name, description, author, getValidatedPrice(price));

        magazineService.create(magazine);
        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }
    private int getValidatedPrice(String price) {
        if(price == null || price.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(price);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
