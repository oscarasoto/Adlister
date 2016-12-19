package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oscarsoto on 12/19/16.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
@WebServlet(name = "ShowAdServlet", urlPatterns = "/ads/show")
public class ShowAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Ad adById = DaoFactory.getAdsDao().findAdById(id);

        if (adById != null) {
            request.setAttribute("ad", adById);
        }

        request.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(request, response);

    }
}
