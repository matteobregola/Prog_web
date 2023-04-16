package com.example.calculatorwithsessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "input", value = "/input")
public class input extends Calculator {
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String msg;
        boolean newUser = false;
        boolean first = false;

        String nameS = getValueFromSession(request, "name"); // Change 1
        String iteration = getValueFromSession(request, "iteration"); // Change 1

        if (iteration != null) {
            if(iteration.equals(iteration.toLowerCase())) {
                first = true;
            }
        }

        if (nameS == null) {
            /*
              Option 1: new user coming from the homepage page
              need to create the session
             */

            String nameP = getValueFromParameters(request, "name");
            newUser = true;

            nameS = nameP;
        }

        /*
            Here I have to check if the user has arrived to the input from the homepage
            or if it is another operation.
         */
        String first_iteration = getValueFromParameters(request, "first_iteration");
        if (first_iteration == null) {
            first = true;
        }

        if (newUser && first) {
            // option 1

            // Change 2:
            HttpSession session = request.getSession();
            session.setAttribute("name", nameS);
            session.setAttribute("first_iteration", "false");

            msg = "<b>Nice to meet you, " + nameS + "!</b><br><br> Let's do an operation: <br><br>";
        } else if (!newUser && first)
            // option 2, known user, coming back
            msg = "<b>Welcome Back, " + nameS + "!</b><br><br> Let's do an operation: <br><br>";
        else {
            // option 3, known or new user, another operation
            msg = "<b> Let's Continue, " + nameS + "!<b><br><br> Insert new data: <br><br>";
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("./header.html").include(request, response);
            out.println(msg);
            print_input_form(out, nameS);
            request.getRequestDispatcher("./footer.html").include(request, response);
        }
    }
}
