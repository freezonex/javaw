package com.supos.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;


@Controller
@RequestMapping("/frontend")
public class frontEnd {

    @Value("${app.path}")
    private String path;
    @GetMapping
    public String view(Model model) {
        String pathNew = path + "apps/wenhao-javaw/css/example.css";
        String pathNewPNG = path + "apps/wenhao-javaw/i12.png";
        String pathExample1 = path + "apps/wenhao-javaw/css/example1.css";
        model.addAttribute("pathNew", pathNew);
        model.addAttribute("pathNewPNG", pathNewPNG);
        model.addAttribute("pathExample1", pathExample1);
        return "example.html";
    }


}
