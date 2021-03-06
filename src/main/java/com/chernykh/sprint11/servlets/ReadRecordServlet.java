package com.chernykh.sprint11.servlets;

import com.chernykh.sprint11.dao.AddressBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/read")
public class ReadRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String address = addressBook.read(firstName, lastName);

        if(address == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Person with name '"+ firstName + " " + lastName
                    + "' not found in Address Book!");
            return;
        }

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("address", address);

        request.getRequestDispatcher("/WEB-INF/read-record.jsp").forward(request, response);
    }
}
