package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FirstServlet",urlPatterns = "/first_servlet")
public class FirstServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String objectType = req.getParameter("type");
        Integer count = Integer.parseInt(req.getParameter("count"));

        if(objectType.equals("Iphone")){
            List<Product>list = new ArrayList<>();
            Integer total = 0;
            for (int i = 0; i < count ; i++) {
                list.add(new Product(Integer.toString(i),objectType,1500));
                total += 1500;
            }
            out.println(list);
            out.println("Total Price: " + total);
        }

        out.close();
    }
}
