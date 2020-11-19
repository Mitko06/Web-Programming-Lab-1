package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.implementation.BalloonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    public final BalloonService balloonService;
    public final ManufacturerService manufacturerService;
    public final OrderService orderService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService, OrderService orderService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){

        if (error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        List<Balloon> balloonList = balloonService.listAll();
        List<Manufacturer> manufacturerList = manufacturerService.findAll();
        model.addAttribute("manufacturers",manufacturerList);
        model.addAttribute("balloons",balloonList);

        return "listballoons";
    }

    @GetMapping("/add-balllon-page")
    public String getAddNewBalloonPage(Model model){
        List<Manufacturer> listManufacturer = manufacturerService.findAll();
        model.addAttribute("manufacturers",listManufacturer);
        return "add-balloon";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam(required = false) Long balloonID,@RequestParam String name, @RequestParam String description, @RequestParam Long id){
        Manufacturer manufacturer = manufacturerService.findAll().stream().filter(r->r.getId().equals(id)).findFirst().get();
        Balloon balloon = new Balloon(name,description,manufacturer);
        if (balloonService.saveBalloon(balloonID,name,description,manufacturer)){
            return "redirect:/balloons";
        }
        return "redirect:/balloons?error='Balloon has not been added'";

    }
    @GetMapping("/edit/{id}")
    public String editBalloon(@PathVariable Long id, Model model){
        Balloon balloon = balloonService.getBalloon(id);
        List<Manufacturer> manufacturerList = manufacturerService.findAll();
        model.addAttribute("balloon",balloon);
        model.addAttribute("manufacturers",manufacturerList);

        return "add-balloon";
    }
    @PostMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }
    @GetMapping("/orders")
    public String getOrdersPage(Model model){
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders",orders);
        return "userOrders";
    }


}
