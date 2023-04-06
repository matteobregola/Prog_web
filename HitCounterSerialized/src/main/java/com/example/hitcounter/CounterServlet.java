package com.example.hitcounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "CounterServlet", value = "/CounterServlet")
public class CounterServlet extends HttpServlet {
    private static final String FILE_PATH = "./data.ser";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Counter obj;

        // Load the serialized object from the file
        File file = new File(FILE_PATH);

        if (file.exists() && file.length() > 0) {
            // File exists and is not empty, read the serialized object
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                obj = (Counter) in.readObject();
                obj.increase();
            } catch (IOException | ClassNotFoundException e) {
                throw new ServletException("Error loading serialized object", e);
            }
        } else {
            // File does not exist or is empty, create a new serialized object with default values
            try {
                obj = new Counter();
                obj.increase();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html; charset=UTF-8");
            request.getRequestDispatcher("/fragment1.html");
            out.println(obj);
            request.getRequestDispatcher("/fragment2.html");
        }
    }
}
