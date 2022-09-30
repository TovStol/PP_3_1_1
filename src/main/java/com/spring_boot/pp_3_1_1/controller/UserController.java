package com.spring_boot.pp_3_1_1.controller;


import com.spring_boot.pp_3_1_1.model.User;
import com.spring_boot.pp_3_1_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private final UserService userService;

//    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {

        return "redirect:users";
    }

    @GetMapping(value = "/users")
    public String getAllUser(Model model) {
        model.addAttribute("listUser", userService.getAllUsers());

        return "users";
    }

    @GetMapping(value = "/users/new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

    @PostMapping(value = "/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping(value = "/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        User existUser = userService.getUserById(id);
        existUser.setId(id);
        existUser.setName(user.getName());
        existUser.setLastName(user.getLastName());
        existUser.setAge(user.getAge());
        userService.updateUser(existUser);
        return "redirect:/users";
    }

    @GetMapping(value = "users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

}
