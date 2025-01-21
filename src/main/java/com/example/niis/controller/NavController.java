package com.example.niis.controller;

import com.example.niis.model.Kolegij;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @GetMapping("/kolegiji/add-kolegij")
    public String addKolegij(Model model) {
        model.addAttribute("kolegij", new Kolegij());
        return "add-kolegij";
    }

    @GetMapping("/kolegiji/add-kolegij-unsafe")
    public String addKolegijUnsafe(Model model) {
        model.addAttribute("kolegij", new Kolegij());
        return "add-kolegij-unsafe";
    }

}
