package Webapp;

import com.example.onlinestore.context.ApplicationContext;
import com.example.onlinestore.entities.impl.DefaultUser;
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

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    ApplicationContext context;
    private String firstName;
    private String lastName;
    private String email;
    private String cPassword;
    private String password;
    UserFacade facade;
    private String phoneNumber;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        context=ApplicationContext.getInstance();
        email=request.getParameter("email");
        password=request.getParameter("password");
        cPassword=request.getParameter("Cpassword");
        firstName=request.getParameter("firstName");
        lastName=request.getParameter("lastName");
        phoneNumber=request.getParameter("phoneNumber");
        if (email==null||password==null||cPassword==null||firstName==null||lastName==null||phoneNumber==null) {
            returnBack(request, response, "Cannot have blank spaces");
        }
        facade=new DefaultUserFacade();
        User userChecker=facade.getUser(email,password);
        if (userChecker==null){
                User user=new DefaultUser();
                user.setUserPassword(password);
                user.setPhoneNumber(phoneNumber);
                user.setUserEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                facade.RegisterUser(user);
                context.setLoggedInUser(user);
                context.setSessionCart(new DefaultCart());
                forwarding(request,response,context);
        }
        else {
            returnBack(request,response,"user email already exists");
        }


    }

    private  void returnBack(HttpServletRequest request,HttpServletResponse response,String err) throws ServletException, IOException {
        request.setAttribute("err",err);
        request.getRequestDispatcher("regis.jsp").forward(request,response);
    }

    private void forwarding(HttpServletRequest request,HttpServletResponse response,ApplicationContext context) throws IOException {
        request.getSession().setAttribute("applicationContext",context);
        response.sendRedirect("index.jsp");
    }

}
