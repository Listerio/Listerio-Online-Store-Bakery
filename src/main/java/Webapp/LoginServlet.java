package Webapp;

import com.example.onlinestore.context.ApplicationContext;
import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.facade.UserFacade;
import com.example.onlinestore.facade.impl.DefaultUserFacade;
import com.example.onlinestore.services.impl.DefaultCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    ApplicationContext context;

    UserFacade facade;
    String email;
    String password;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        context=ApplicationContext.getInstance();
        email=request.getParameter("email");
        password=request.getParameter("password");

        if (email==null||password==null){
            returnBack(request,response,"Cannot have blank spaces");
        }
        facade=new DefaultUserFacade();
        User userChecker=facade.getUser(email,password);
        if (userChecker == null) {
            returnBack(request,response,"Wrong email or password");
        }
        else{
            context=ApplicationContext.getInstance();
            context.setLoggedInUser(userChecker);
            context.setSessionCart(new DefaultCart());
            forwarding(request,response,context);
        }

    }
    private  void returnBack(HttpServletRequest request,HttpServletResponse response,String err) throws ServletException, IOException {
        request.setAttribute("err",err);
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    private void forwarding(HttpServletRequest request,HttpServletResponse response,ApplicationContext context) throws IOException {
        request.getSession().setAttribute("applicationContext",context);
        response.sendRedirect("index.jsp");
    }

}
