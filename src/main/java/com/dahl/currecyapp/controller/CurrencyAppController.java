package com.dahl.currecyapp.controller;

import com.dahl.currecyapp.service.ApiService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Dahl
 */
@Controller
public class CurrencyAppController {

    private final ApiService api;
    private final String[] names = {
        "Oficial",
        "Blue",
        "Bolsa",
        "CCL",
        "Tarjeta",
        "Mayorista",
        "Cripto"
    };

    public CurrencyAppController(ApiService api) {
        this.api = api;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<String> namesList = List.of(names);

        model.addAttribute("names", namesList);
        model.addAttribute("records", api.get("all"));
        return "index";
    }

    @GetMapping("/get-info")
    public String getInfo(@RequestParam(value = "name") String name, Model model) {
        
        if (name.equalsIgnoreCase("CCL")) {
            name = "contadoconliqui";
        }
        
        model.addAttribute("records", api.get(name.toLowerCase()));
        List<String> namesList = List.of(names);

        model.addAttribute("names", namesList);
        return "index";
    }

}
