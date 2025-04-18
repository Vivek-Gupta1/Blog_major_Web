package com.dmw.blogcontroller;

import com.dmw.blogentity.UserTable;
import com.dmw.blogserviceimpl.UserImpl;
import com.dmw.model.LoginForm;
import com.dmw.model.RegisterM;
import com.dmw.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    UserImpl userService;




    @GetMapping("/loginuser")
    public String loginUser(Model model) {
        model.addAttribute("loginpage", new LoginForm());
        return "login";
    }

    @PostMapping("/loginuser")
    public String LoginPage(@ModelAttribute("loginpage") LoginForm loginForm, Model model) {
        boolean login = userService.login(loginForm);
        if (login ) {
            model.addAttribute("success","Login successfully");
            return "redirect:/dashboard";
        }else{
            model.addAttribute("error","Password did not match or User Not Found ");
        }
          return "login";

    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserTable());
        return "register";
    }

    @PostMapping("/register")
    public String saveUsedData(@ModelAttribute("user") RegisterM registerM, Model model) {
        boolean user = userService.saveUser(registerM);
        if (user) {
            model.addAttribute("success", AppUtils.SAVE_SUCCESS);
        } else {
            model.addAttribute("error", AppUtils.SAVE_ERROR);
        }
        return "register";
    }
}
