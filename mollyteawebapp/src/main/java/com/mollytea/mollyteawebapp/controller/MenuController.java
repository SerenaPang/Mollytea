package com.mollytea.mollyteawebapp.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mollytea.mollyteawebapp.entity.Basket;
import com.mollytea.mollyteawebapp.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;
    private final Basket basket;

    MenuController(MenuService menuService, Basket basket){
        this.menuService = menuService;
        this.basket = basket;
    }

   @GetMapping
    ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        model.put("products", this.menuService.getProducts());
        return new ModelAndView("menu", model);
    }

}