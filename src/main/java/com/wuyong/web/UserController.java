package com.wuyong.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @PostMapping("/userlogin")
    public String userlogin(String username, String password, Model model, HttpSession session){
        System.out.println(username+"--"+password);
        if("jack".equals(username)&&"111".equals(password)){
            session.setAttribute("loginuser",username);
            return "redirect:/heroList";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "login";
    }
    @GetMapping("/loginout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "redirect:login.html";
    }

}
