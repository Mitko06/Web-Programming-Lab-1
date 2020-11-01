package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.implementation.BalloonService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="balloon-list-servlet",urlPatterns = "")
public class balloonListServlet extends HttpServlet {

    BalloonService balloonService=new BalloonService();
    private final SpringTemplateEngine springTemplateEngine;

    public balloonListServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Balloon> list = balloonService.listAll();



        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");
        out.write("IP address of a client: "+req.getRemoteAddr());
        out.write("<h3>Category List</h3>");
        out.write("<ul>");
        this.balloonService.listAll().stream().forEach(r->
                out.write("<li>"+r.getName()+" ("+r.getDescription()+")</li>")
        );
        out.write("</ul>");
        out.write("<form method='POST' action='/servlet/category'>");
        out.write("<label for='name'>Insert Category Name:</label>");
        out.write("<input type='text' name='name'>");
        out.write("<input type='text' name='description'>");
        out.write("<input type='submit' value='Submit'>");
        out.write("</form>");
        out.write("</body>");
        out.write("</html>");

        WebContext context = new WebContext(req,resp,req.getServletContext());

        context.setVariable("ipAddress",req.getRemoteAddr());
        context.setVariable("balloons",balloonService.listAll());
        springTemplateEngine.process("listballoons.html", context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
