package hu.elte.inf.alkfejl.cinema.controller;


import hu.elte.inf.alkfejl.cinema.dao.UserDao;
import hu.elte.inf.alkfejl.cinema.exception.UserNotValidException;
import hu.elte.inf.alkfejl.cinema.model.User;
import hu.elte.inf.alkfejl.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@Controller
@RequestMapping("/home")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute(new User());
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        try {
            userService.login(user);
            return redirectToGreeting(user);
        }
        catch (UserNotValidException e) {
            model.addAttribute("error", true);
            return "index";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        user.setRole(USER);
        userService.register(user);

        return redirectToGreeting(user);
    }

    private String redirectToGreeting(@ModelAttribute User user) {
        return "redirect:/greet?name=" + user.getUsername();
    }
}
