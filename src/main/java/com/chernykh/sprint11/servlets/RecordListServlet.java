package com.chernykh.sprint11.servlets;

import com.chernykh.sprint11.dao.AddressBook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/list")
public class RecordListServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/record-list.jsp");
        request.setAttribute("records", addressBook);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("ascBtn") != null) {
            addressBook.sortedBy(AddressBook.SortOrder.ASC);
        } else {
            addressBook.sortedBy(AddressBook.SortOrder.DESC);
        }
        request.setAttribute("records", addressBook);
        request.getRequestDispatcher("/WEB-INF/record-list.jsp").forward(request, response);
    }
}
