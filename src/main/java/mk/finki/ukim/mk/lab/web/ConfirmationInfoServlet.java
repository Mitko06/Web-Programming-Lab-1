package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;

@WebServlet(name="confirmation-info-servlet", urlPatterns = "/confirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getSession().getAttribute("balloon-color").toString();
        String size = req.getSession().getAttribute("size").toString();
        String clientName = req.getSession().getAttribute("clientName").toString();
        String clientAddress = req.getSession().getAttribute("clientAddress").toString();

        Order order = orderService.placeOrder(color,size,clientName,clientAddress);

        req.getSession().setAttribute("order",order);

        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("ipAddress",req.getRemoteAddr());
        context.setVariable("clientAgent",req.getHeader("User-Agent"));

        context.setVariable("order",order);

        springTemplateEngine.process("confirmatIonInfo.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

