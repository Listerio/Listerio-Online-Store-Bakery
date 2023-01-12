package Webapp;

import com.example.onlinestore.context.ApplicationContext;
import com.example.onlinestore.entities.impl.DefaultOrder;
import com.example.onlinestore.entities.script.Order;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.services.OrderManagementService;
import com.example.onlinestore.services.impl.DefaultOrderManagementService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    ApplicationContext context;
    Order order;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        order=new DefaultOrder();
        context=(ApplicationContext) request.getSession().getAttribute("applicationContext");
        if (context==null){
            context=new ApplicationContext();
        }
        if (context.getSessionCart().getProductList().size()==0){
            request.setAttribute("noCI","No items in cart");
        }

        int total=0;
        for (Product product:context.getSessionCart().getProductList()) {
            total += product.getProductPrice().getPrice();
        }
        String cardStr=request.getParameter("cardNumber");
        if (cardStr!=null){
            boolean valid=order.isValid(cardStr);
            if (valid)
            {
                order.setProducts(context.getSessionCart().getProductList());
                order.setCreditCardNumber(cardStr);
                OrderManagementService service=new DefaultOrderManagementService();
                service.addOrder(order);
                request.setAttribute("cong","Purchase successful");
                System.out.println("Purchase Successful");
                context.getSessionCart().clearCart();
                request.getSession().setAttribute("applicationContext",context);
                request.getSession().setAttribute("purchaseSuccessful","true");
                response.sendRedirect("index.jsp");
            }
            else {
                request.setAttribute("cardErr","Invalid card number");
                request.getRequestDispatcher("index.jsp#order").forward(request,response);
            }
        }
        else {
            request.setAttribute("cardErr","Invalid card number");
            response.sendRedirect("index.jsp#order");
        }




    }





}
