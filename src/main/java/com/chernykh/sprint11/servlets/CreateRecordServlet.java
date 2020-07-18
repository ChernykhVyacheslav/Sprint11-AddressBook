package com.chernykh.sprint11.servlets;

import com.chernykh.sprint11.dao.AddressBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/create")
public class CreateRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");

        if (addressBook.read(firstName, lastName) != null) {
            request.setAttribute("errorMessage", "Record with such first name and last name already exists. Please try different first and/or last name");
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("address", address);
            request.getRequestDispatcher("/WEB-INF/create-record.jsp").forward(request, response);
        } else {

            addressBook.create(firstName, lastName, address);

            response.sendRedirect("/records/list");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/create-record.jsp").forward(request, response);
    }
}
