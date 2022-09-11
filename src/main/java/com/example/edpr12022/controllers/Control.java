package com.example.edpr12022.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Control {

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/get")
    public String GetView() {
        return "get";
    }

    @GetMapping("/result")
    public String GetController(@RequestParam(value = "a", required = false) int a,
                                @RequestParam(value = "b", required = false) int b,
                                @RequestParam(value = "rez", required = false) String rez, Model model) {

        double result = 0;
        switch (rez) {
            case "+":
                result = a + b;
                break;

            case "-":
                result = a - b;
                break;

            case "*":
                result = a * b;
                break;

            case "/":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "get";

    }

    @GetMapping("/post")
    public String PostView() {
        return "post";
    }

    @PostMapping("/postrez")
    public String PostController(@RequestParam int a,
                                @RequestParam int b,
                                @RequestParam String rez, Model model) {

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("rez", rez);


        double result;
        switch (rez) {
            case "+":
                result = a + b;
                break;

            case "-":
                result = a - b;
                break;

            case "*":
                result = a * b;
                break;

            case "/":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "post";

    }
}
