package Webapp;

import com.example.onlinestore.context.ApplicationContext;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.services.ProductManagementService;
import com.example.onlinestore.services.impl.DefaultProductManagementService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "AddToCartServlet", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    ApplicationContext context;
    ProductManagementService service;
    Product product;
    Set<Product>  products;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean nxt=false;
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

                request.getSession().setAttribute("applicationContext",context);
                request.getSession().setAttribute("cList",products);
                response.sendRedirect("index.jsp#product");
                nxt=true;
            }
        }
        if (!nxt) {

            products.add(product);
            context.getSessionCart().addToCart(product);
            request.getSession().setAttribute("applicationContext", context);
            request.getSession().setAttribute("cList", products);
            response.sendRedirect("index.jsp#product");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
