package jr.jarrobots.website;

import java.io.*;
import java.util.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/diva")
public class HelloServlet extends HttpServlet {
    ArrayList<Question> list;
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getList(request);
        request.setAttribute("question",list.get(0));
        request.getRequestDispatcher("/diva.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentQuestion;

        if(request.getSession().getAttribute("currentQuestion")==null){
            currentQuestion = 0;
            request.getSession().setAttribute("currentQuestion", currentQuestion);
        }
        else {
            currentQuestion = (int) request.getSession().getAttribute("currentQuestion");
        }

        if(request.getParameter("button2") != null){
            if(currentQuestion < list.size()-1){
                currentQuestion++;
                request.getSession().setAttribute("currentQuestion", currentQuestion);
            }
            request.setAttribute("question",list.get(currentQuestion));
        } else if(request.getParameter("button1") != null){
            if(currentQuestion > 0){
                currentQuestion--;
                request.getSession().setAttribute("currentQuestion", currentQuestion);
            }
            request.setAttribute("question",list.get(currentQuestion));
        }

        request.getRequestDispatcher("/diva.jsp").forward(request,response);
    }

    public void destroy() {
    }

    private void getList(HttpServletRequest request) {
        if(request.getServletContext().getAttribute("List") == null){
            try {
                FileReader fileReader = new FileReader("/Users/jarek/IdeaProjects/website/src/main/webapp/File.txt");
                list = fileReader.getQuestions();
                request.getServletContext().setAttribute("List",list);
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        else{
            list = (ArrayList<Question>)request.getServletContext().getAttribute("List");

        }
    }
    private Optional<Cookie> getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return Optional.empty();
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName))
                return Optional.of(cookie);
        }
        return Optional.empty();
    }
}