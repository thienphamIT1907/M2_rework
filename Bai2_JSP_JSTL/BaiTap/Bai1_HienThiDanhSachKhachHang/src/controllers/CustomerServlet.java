package controllers;

import models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showListCustomer(request,response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        customerArrayList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "pic1.jpg"));
        customerArrayList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "pic1.jpg"));
        customerArrayList.add(new Customer("Nguyễn Thái Hoà", "1983-05-22", "Nam Định", "pic1.jpg"));
        customerArrayList.add(new Customer("Trần Đăng Khoa", "1983-01-19", "Hà Tây", "pic1.jpg"));
        customerArrayList.add(new Customer("Nguyễn Đình Thi", "1983-12-13", "Đà Nẵng", "pic1.jpg"));

        request.setAttribute("customerArrayList", customerArrayList);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
