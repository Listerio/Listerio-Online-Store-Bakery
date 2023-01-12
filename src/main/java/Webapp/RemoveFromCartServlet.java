package Webapp;

import com.example.onlinestore.context.ApplicationContext;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.services.ProductManagementService;
import com.example.onlinestore.services.impl.DefaultProductManagementService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "RemoveFromCartServlet", value = "/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
    ApplicationContext context;
    ProductManagementService service;
    Product product;
    Set<Product> products;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        products=(Set<Product>) request.getSession().getAttribute("cList");
        if (products==null){
            System.out.println("new set");
            products=new HashSet<>();
        }
        service=new DefaultProductManagementService();
        context=(ApplicationContext) request.getSession().getAttribute("applicationContext");
        if (context==null){
            context=new ApplicationContext();
        }
        product=service.getProductByProductId(Integer.parseInt(request.getParameter("id")));

        for (Product p:products){
            if (p.getProductName().equals(product.getProductName())){
                context.getSessionCart().removeFromCart(product);
            }
        }

        products=new HashSet<>();
        products.addAll(context.getSessionCart().getProductList());

        request.getSession().setAttribute("applicationContext", context);
        request.getSession().setAttribute("cList", products);
        response.sendRedirect("index.jsp#product");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
