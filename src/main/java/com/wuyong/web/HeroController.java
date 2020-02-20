package com.wuyong.web;

import com.wuyong.domain.Hero;
import com.wuyong.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HeroController {
    @Autowired
    private HeroService heroService;
    @RequestMapping("/heroList")
    public String heroList(Model model){
        List<Hero>heroList=heroService.getAllHero();
        model.addAttribute("heroList",heroList);
        return "index";
    }
    @GetMapping("/addPage")
    public String addPage(){
        return "add";
    }

    @PostMapping("/addHero")
    public String addHero(Hero hero){
        heroService.addHero(hero);
        return "redirect:/heroList";
    }
    @PutMapping("/addHero")
    public String updataHero(Hero hero){
        heroService.updateHero(hero);
        return "redirect:/heroList";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") Long id,Model model){
        Hero hero=heroService.getHeroById(id);
        model.addAttribute("hero",hero);
        return "add";
    }
    @GetMapping("/delete/{id}")
    public String deleteHero(@PathVariable("id") Long id){
        heroService.deleteHero(id);
        return "redirect:/heroList";
    }
    @InitBinder
    public void initbinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
            public void setAsText(String value){
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
            public String getAsText(){
                return new SimpleDateFormat("yyyy-MM-dd").format(getValue());
            }
        });
    }
}
