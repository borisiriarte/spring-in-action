package com.example.tacocloud.web;

import com.example.tacocloud.Taco;
import com.example.tacocloud.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
  @GetMapping("/current")
  public String orderForm() {
    return "orderForm";
  }

  @ModelAttribute(name = "tacoOrder")
  public TacoOrder order(){
    return new TacoOrder();
  }

  @ModelAttribute(name = "tacos")
  public Taco taco() {
    return new Taco();
  }

  @PostMapping
  public String processOrder(TacoOrder order, SessionStatus sessionStatus) {
    log.info("Order Submitted: {}", order);
    sessionStatus.isComplete();

    return "redirect:/";
  }
}
