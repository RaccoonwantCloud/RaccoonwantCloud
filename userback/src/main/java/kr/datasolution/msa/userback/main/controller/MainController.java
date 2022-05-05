package kr.datasolution.msa.userback.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String getViewMain() {
        return "redirect:/user";
    }
}
