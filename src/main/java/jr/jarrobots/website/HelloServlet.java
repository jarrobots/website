package jr.jarrobots.website;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/diva")
public class HelloServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/diva.jsp").forward(request,response);
        request.getSession().setAttribute("list", );
    }

    public void destroy() {
    }

    private Optional<ArrayList<Question>> getList(HttpServletResponse response) throws IOException {

        try {
            FileReader fileReader = new FileReader("x");
             return Optional.of(fileReader.getQuestions());
        }
        catch(FileNotFoundException e){
            response.sendRedirect("/error.jsp");
            return Optional.empty();
        }
    }
}