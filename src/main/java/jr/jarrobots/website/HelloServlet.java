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
        Optional<ArrayList<Question>> optional = getList();
        request.getSession().setAttribute("List", optional);
        //request.getSession().setAttribute("test","ok");
        request.getRequestDispatcher("/diva.jsp").forward(request,response);
    }

    public void destroy() {
    }

    private Optional<ArrayList<Question>> getList() {

        try {
            FileReader fileReader = new FileReader("File.txt");
             return Optional.of(fileReader.getQuestions());
        }
        catch(FileNotFoundException e){
            return Optional.empty();
        }
    }
}