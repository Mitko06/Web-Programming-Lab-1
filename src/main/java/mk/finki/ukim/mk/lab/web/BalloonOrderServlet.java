package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="balloon-order-servlet",urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {

        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext context = new WebContext(req,resp,req.getServletContext());
        System.out.println(req.getSession().getAttribute("balloon-color"));
        String color = req.getSession().getAttribute("balloon-color").toString();
        String size = req.getSession().getAttribute("size").toString();

        context.setVariable("color",color);
        context.setVariable("size",size);
        springTemplateEngine.process("deliveryinfo.html",context,resp.getWriter());


        System.out.println("SelectBalloonServlet: " + color);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("clientName",req.getParameter("clientName"));
        req.getSession().setAttribute("clientAddress",req.getParameter("clientAddress"));
        resp.sendRedirect("/confirmationInfo");
    }
}
