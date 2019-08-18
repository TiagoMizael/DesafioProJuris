package br.com.projuris.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class AppController {
    @RequestMapping("/")
    String home(ModelMap modal) {
        return "index";
    }

}
