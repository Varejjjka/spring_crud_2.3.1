package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers (Model model) {
        model.addAttribute("all_us", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/new")
    public String newUser (Model model) {
        model.addAttribute("new_user", new User());
        return "new_user";
    }

    @PostMapping("/add")
    public String saveUser (@ModelAttribute("/add_user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String showUser (@PathVariable("id") int id, Model model) {
        model.addAttribute("show_user", userService.getUserById(id));
        return "show_user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("upd_user", userService.getUserById(id));
        return "update_user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("update_user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}
