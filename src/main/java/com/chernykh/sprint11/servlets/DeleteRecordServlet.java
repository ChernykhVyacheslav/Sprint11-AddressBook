package com.chernykh.sprint11.servlets;

import com.chernykh.sprint11.dao.AddressBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/delete")
public class DeleteRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        if(!addressBook.delete(firstName, lastName)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Person with name '"+ firstName + " " + lastName
                    + "' not found in Address Book!");
        } else {
            response.sendRedirect("/records/list");
        }
    }
}
