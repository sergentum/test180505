package web;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("doGet");

        User user = new User("TestUser");
//        System.out.println(userRepository);
//        userRepository.save(user);

//        req.getRequestDispatcher("/hello.html").forward(req, resp);


//        PrintWriter writer = resp.getWriter();

        Map<String, ? extends ServletRegistration> registrations = req
                .getServletContext().getServletRegistrations();

        for (String key : registrations.keySet()) {
            ServletRegistration registration = registrations.get(key);
            System.out.print(("Name: " + registration.getName()));
            System.out.print(" Mappings: ");
            for (String mapping : registration.getMappings()) {
                System.out.print(mapping);
            }
            System.out.println();
        }

        // of course you can write that to log or console also depending on your
        // requirement.
    }
}
