package edu.wctc.tacocloud.controller;

import edu.wctc.tacocloud.entity.Order;
import edu.wctc.tacocloud.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    private OrderRepository orderRepo;

    @Autowired
    public AdminController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/ordersByZip")
    public String viewOrdersByZip(@RequestParam String zipCode,
                                  Model model) {
        List<Order> orderList = orderRepo.findByZip(zipCode);

        model.addAttribute("orders", orderList);

        model.addAttribute("reportType", "With Zip Code " + zipCode);

        return "viewOrders";
    }

    @GetMapping("/waukeshaOrders")
    public String viewWaukesha(Model model) {
        List<Order> orderList = orderRepo.readOrdersDeliveredInWaukesha();

        model.addAttribute("orders", orderList);

        model.addAttribute("reportType", "Waukesha Orders");

        return "viewOrders";
    }
}
