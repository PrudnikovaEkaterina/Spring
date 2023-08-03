package org.example.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class Calculator {
    @GetMapping("/calculator")
    public String calculate (@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action, Model model){
        switch (action){
            case "multiplication":
                model.addAttribute("action", "Result of multiplication = "+(a*b));
                break;
            case "addition":
                model.addAttribute("action", "Result of addition = "+(a+b));
                break;
            case "subtraction":
                model.addAttribute("action", "Result of subtraction = "+(a-b));
                break;
            case "division":
                model.addAttribute("action", "Result of division = "+(a/(double)b));
                break;
            default:
                model.addAttribute("action","Not correct param action");
                break;
        }
        return "calculator/calculator";
    }
}
