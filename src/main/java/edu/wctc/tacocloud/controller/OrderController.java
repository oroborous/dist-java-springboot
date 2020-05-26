package edu.wctc.tacocloud.controller;

import edu.wctc.tacocloud.entity.Order;
import edu.wctc.tacocloud.repository.OrderRepository;
import edu.wctc.tacocloud.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    private OrderRepository orderRepo;

    private EmailService emailService;

    @Autowired
    public OrderController(OrderRepository orderRepo, EmailService emailService) {
        this.orderRepo = orderRepo;
        this.emailService = emailService;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order,
                               Errors errors,
                               Model model,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: " + order);

        orderRepo.save(order);
        sessionStatus.setComplete();

        emailService.sendSimpleMessage(order.getEmail(), "Taco Cloud Order Confirmation", "Order #" + order.getId() + " is on its way!");

        return "confirm";
    }
}
