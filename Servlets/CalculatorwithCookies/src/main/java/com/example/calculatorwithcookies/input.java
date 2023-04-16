package com.example.calculatorwithcookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "input", value = "/input")
public class input extends Calculator {

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String msg;
        boolean newUser = false;
        boolean first = false;

        String nameC = getValueFromCookie(request, "name");
        if (nameC == null) {
            /*
              Option 1: new user coming from the homepage page
              need to create the cookie
             */

            String nameP = getValueFromParameters(request, "name");
            newUser = true;

            Cookie newCookie = new Cookie("name", nameP);
            newCookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(newCookie);

            nameC = nameP;
        }

        /*
            Here i have to check if the user has arrived to the input from the homepage
            or if it is another operation.
         */
        String first_iteration = getValueFromParameters(request, "first_iteration");
        if (first_iteration == null) {
            first = true;
        }

        if (newUser && first) {
            // option 1
            msg = "<b>Nice to meet you, " + nameC + "!</b><br><br> Let's do an operation: <br><br>";
        } else if (!newUser && first)
            // option 2, known user, coming back
            msg = "<b>Welcome Back, " + nameC + "!</b><br><br> Let's do an operation: <br><br>";
        else {
            // option 3, known or new user, another operation
            msg = "<b> Let's Continue, " + nameC + "!<b><br><br> Insert new data: <br><br>";
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("./header.html").include(request, response);
            out.println(msg);
            print_input_form(out, nameC);
            request.getRequestDispatcher("./footer.html").include(request, response);
        }
    }
}
